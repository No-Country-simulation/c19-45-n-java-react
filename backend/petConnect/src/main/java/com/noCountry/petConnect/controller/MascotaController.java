package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.constants.Status;
import com.noCountry.petConnect.dto.ApiResponseDTO;
import com.noCountry.petConnect.dto.MascotaDTO;
import com.noCountry.petConnect.dto.MascotaResponseDTO;
import com.noCountry.petConnect.dto.MascotaSimpleResponseDTO;
import com.noCountry.petConnect.infra.errores.ApplicationException;
import com.noCountry.petConnect.mapper.MascotaMapper;
import com.noCountry.petConnect.model.Mascota;
import com.noCountry.petConnect.model.Sexo;
import com.noCountry.petConnect.service.MascotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Tag(name = "Mascotas")
@SecurityRequirement(name = "bearer-key")
@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

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
    public ResponseEntity<ApiResponseDTO<MascotaSimpleResponseDTO>> getMascotaById(@PathVariable long id) {
        try {
            Mascota mascota = mascotaService.getMascotaById(id);
            MascotaSimpleResponseDTO responseDTO = mascotaMapper.toSimpleResponseDTO(mascota);
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Mascota obtenida exitosamente", responseDTO));
        } catch (ApplicationException e) {
            return ResponseEntity.status(404).body(new ApiResponseDTO<>(Status.ERROR, "Mascota con el id: " + id + " no encontrada", null));
        }
    }

    @Operation(summary = "Api para filtrar mascotas por nombre, raza o sexo")
    @GetMapping("/filtrar")
    public ResponseEntity<ApiResponseDTO<List<MascotaResponseDTO>>> filtrarMascotas(@RequestParam(required = false) String nombre, @RequestParam(required = false) Sexo sexo, @RequestParam(required = false) Long especieId) {
        try {
            List<Mascota> mascotas = mascotaService.filtrarMascotas(nombre, sexo, especieId);
            List<MascotaResponseDTO> responseDTOs = mascotas.stream().map(mascotaMapper::toResponseDTO).collect(Collectors.toList());
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Mascotas filtradas exitosamente", responseDTOs));
        } catch (ApplicationException e) {
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.ERROR, e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO<>(Status.ERROR, e.getMessage(), null));
        }
    }

    @Operation(summary = "Api para crear una nueva mascota")
    @PostMapping
    public ResponseEntity<ApiResponseDTO<MascotaResponseDTO>> createMascota(@RequestBody MascotaDTO mascotaDTO) {
        try {
            Mascota nuevaMascota = mascotaService.createMascota(mascotaDTO);
            MascotaResponseDTO responseDTO = new MascotaResponseDTO(nuevaMascota);
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Mascota creada exitosamente", responseDTO));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponseDTO<>(Status.ERROR, e.getMessage(), null));
        } catch (ApplicationException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO<>(Status.ERROR, e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO<>(Status.ERROR, "Error al crear la mascota", null));
        }
    }

    @Operation(summary = "Api para actualizar los datos de una mascota")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<MascotaResponseDTO>> updateMascota(@PathVariable Long id, @RequestBody MascotaDTO mascotaDTO) {
        try {
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
