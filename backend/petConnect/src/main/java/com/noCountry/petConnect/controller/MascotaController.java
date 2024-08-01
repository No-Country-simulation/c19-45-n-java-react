package com.noCountry.petConnect.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.noCountry.petConnect.config.S3Config;
import com.noCountry.petConnect.constants.Status;
import com.noCountry.petConnect.dto.ApiResponseDTO;
import com.noCountry.petConnect.dto.MascotaDTO;
import com.noCountry.petConnect.dto.MascotaResponseDTO;
import com.noCountry.petConnect.dto.MascotaSimpleResponseDTO;
import com.noCountry.petConnect.infra.errores.ApplicationException;
import com.noCountry.petConnect.mapper.MascotaMapper;
import com.noCountry.petConnect.model.Mascota;
import com.noCountry.petConnect.model.Sexo;
import com.noCountry.petConnect.repository.EspecieRepository;
import com.noCountry.petConnect.repository.UsuarioRepository;
import com.noCountry.petConnect.service.MascotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Tag(name = "Mascotas")
@SecurityRequirement(name = "bearer-key")
@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private S3Config s3Config;

    @Autowired
    private AmazonS3 s3Client;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EspecieRepository especieRepository;

    private final MascotaService mascotaService;
    private final MascotaMapper mascotaMapper;

    @Autowired
    public MascotaController(MascotaService mascotaService, MascotaMapper mascotaMapper) {
        this.mascotaService = mascotaService;
        this.mascotaMapper = mascotaMapper;
    }

    @Operation(summary = "Api para obtener todas las mascotas")
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<MascotaSimpleResponseDTO>>> getAllMascotas() {
        List<Mascota> mascotas = mascotaService.getAllMascotas();
        if (mascotas.isEmpty()) {
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.ERROR, "No hay mascotas para mostrar", null));
        }
        List<MascotaSimpleResponseDTO> responseDTOs = mascotaMapper.toSimpleResponseDTOList(mascotas);
        return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Lista de mascotas obtenida exitosamente", responseDTOs));
    }

    @Operation(summary = "Api obtener el detalle de una mascota en especifico")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<MascotaResponseDTO>> getMascotaById(@PathVariable long id) {
        try {
            Mascota mascota = mascotaService.getMascotaById(id);
            MascotaResponseDTO responseDTO = mascotaMapper.toResponseDTO(mascota);
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Mascota obtenida exitosamente", responseDTO));
        } catch (ApplicationException e) {
            return ResponseEntity.status(404).body(new ApiResponseDTO<>(Status.ERROR, "Mascota con el id: " + id + " no encontrada", null));
        }
    }

    @Operation(summary = "Api para filtrar mascotas por nombre, raza o sexo")
    @GetMapping("/filtrar")
    public ResponseEntity<ApiResponseDTO<List<MascotaSimpleResponseDTO>>> filtrarMascotas(@RequestParam(required = false) String nombre, @RequestParam(required = false) Sexo sexo, @RequestParam(required = false) Long especieId) {
        try {
            List<Mascota> mascotas = mascotaService.filtrarMascotas(nombre, sexo, especieId);
            List<MascotaSimpleResponseDTO> responseDTOs = mascotas.stream().map(mascotaMapper::toSimpleResponseDTO).collect(Collectors.toList());
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Mascotas filtradas exitosamente", responseDTOs));
        } catch (ApplicationException e) {
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.ERROR, e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO<>(Status.ERROR, e.getMessage(), null));
        }
    }

    @Operation(summary = "Api para crear una nueva mascota")
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<ApiResponseDTO<MascotaResponseDTO>> createMascota(
            @RequestPart("fotoPrincipal") MultipartFile fotoPrincipal,
            @RequestPart("fotosExtras") List<MultipartFile> fotosExtras,
            @RequestParam("name") String name,
            @RequestParam("specieId") Long specieId,
            @RequestParam("breed") String breed,
            @RequestParam("age") String age,
            @RequestParam("sex") Sexo sex,
            @RequestParam("color") String color,
            @RequestParam("specialNeeds") String specialNeeds,
            @RequestParam("vaccinated") boolean vaccinated,
            @RequestParam("sterilized") boolean sterilized,
            @RequestParam("status") String status,
            @RequestParam("ownerId") Long ownerId) {

        try {
            String fotoUrl = uploadFileToS3(fotoPrincipal);
            List<String> fotosExtraUrls = new ArrayList<>();

            // Subir las fotos adicionales
            for (MultipartFile file : fotosExtras) {
                String fileUrl = uploadFileToS3(file);
                if (fileUrl != null) {
                    fotosExtraUrls.add(fileUrl);
                }
            }

            MascotaDTO mascotaDTO = new MascotaDTO(
                    name, specieId, breed, age, sex, color, specialNeeds,
                    vaccinated, sterilized, status, ownerId, fotoUrl, fotosExtraUrls
            );

            Mascota nuevaMascota = mascotaService.createMascota(mascotaDTO);
            MascotaResponseDTO responseDTO = new MascotaResponseDTO(nuevaMascota);
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Mascota creada exitosamente", responseDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDTO<>(Status.ERROR, "Error al crear la mascota", null));
        }
    }

    // Método auxiliar para subir un archivo a S3 y obtener la URL
    private String uploadFileToS3(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return null;
        }

        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType()); // Configura el Content-Type del archivo
        metadata.setContentDisposition("inline");
        try (InputStream inputStream = file.getInputStream()) {
            s3Client.putObject(new PutObjectRequest(s3Config.bucketName(), fileName, inputStream, metadata));
            return s3Client.getUrl(s3Config.bucketName(), fileName).toString();
        } catch (IOException e) {
            throw new RuntimeException("Error al subir el archivo a S3", e);
        }
    }

    @Operation(summary = "Api para actualizar los datos de una mascota")
    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ResponseEntity<ApiResponseDTO<MascotaResponseDTO>> updateMascota(
            @PathVariable Long id,
            @RequestPart(value = "fotoPrincipal", required = false) MultipartFile fotoPrincipal,
            @RequestPart(value = "fotosExtras", required = false) List<MultipartFile> fotosExtras,
            @RequestParam(value = "name", required = false) String nombre,
            @RequestParam(value = "specieId", required = false) Long especieId,
            @RequestParam(value = "breed", required = false) String raza,
            @RequestParam(value = "age", required = false) String edad,
            @RequestParam(value = "sex", required = false) Sexo sexo,
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "specialNeeds", required = false) String necesidadesEspeciales,
            @RequestParam(value = "vaccinated", required = false) Boolean vacunado,
            @RequestParam(value = "sterilized", required = false) Boolean esterilizado,
            @RequestParam(value = "status", required = false) String estado,
            @RequestParam(value = "ownerId", required = false) Long propietarioId) {

        try {
            // Obtener la mascota existente
            Mascota mascotaExistente = mascotaService.getMascotaById(id);

            // Actualizar foto principal si se proporciona una nueva
            String fotoPrincipalUrl = uploadFileToS3(fotoPrincipal);
            if (fotoPrincipal != null && !fotoPrincipal.isEmpty()) {
                mascotaExistente.setFotoPrincipalUrl(fotoPrincipalUrl);
            }

            // Actualizar fotos adicionales si se proporcionan nuevas
            List<String> fotosExtraUrls = new ArrayList<>();
            if (fotosExtras != null && !fotosExtras.isEmpty()) {
                for (MultipartFile file : fotosExtras) {
                    String fileUrl = uploadFileToS3(file);
                    if (fileUrl != null) {
                        fotosExtraUrls.add(fileUrl);
                    }
                }
                mascotaExistente.setFotosExtra(fotosExtraUrls);
            }

            // Actualizar otros campos si se proporcionan nuevos valores
            MascotaDTO mascotaDTO = new MascotaDTO(
                    nombre, especieId, raza, edad, sexo, color, necesidadesEspeciales,
                    vacunado, esterilizado, estado, propietarioId, fotoPrincipalUrl, fotosExtraUrls
            );

            // Guardar los cambios
            Mascota updatedMascota = mascotaService.updateMascota(id, mascotaDTO);
            MascotaResponseDTO responseDTO = mascotaMapper.toResponseDTO(updatedMascota);
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Mascota actualizada exitosamente", responseDTO));

        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO<>(Status.ERROR, e.getMessage(), null));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponseDTO<>(Status.ERROR, e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO<>(Status.ERROR, "Error al actualizar la mascota", null));
        }
    }


    @Operation(summary = "Api para borrar una mascota en especifico")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> deleteMascota(@PathVariable Long id) {
        try {
            boolean isDeleted = mascotaService.deleteMascota(id);
            if (isDeleted) {
                return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Mascota eliminada exitosamente", null));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO<>(Status.ERROR, "Mascota no encontrada", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO<>(Status.ERROR, "Error al eliminar la mascota", null));
        }
    }


}
