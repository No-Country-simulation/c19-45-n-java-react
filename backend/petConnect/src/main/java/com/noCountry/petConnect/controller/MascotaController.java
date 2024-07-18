package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.constants.Status;
import com.noCountry.petConnect.dto.ApiResponseDTO;
import com.noCountry.petConnect.dto.MascotaDTO;
import com.noCountry.petConnect.model.Mascota;
import com.noCountry.petConnect.service.MascotaService;
import com.noCountry.petConnect.infra.errores.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ssl.DefaultSslBundleRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;
    private final DefaultSslBundleRegistry sslBundleRegistry;

    @Autowired
    public MascotaController(MascotaService mascotaService, DefaultSslBundleRegistry sslBundleRegistry) {
        this.mascotaService = mascotaService;
        this.sslBundleRegistry = sslBundleRegistry;
    }

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<Mascota>>> getAllMascotas() {
        List<Mascota> mascotas = mascotaService.getAllMascotas();
        if (mascotas.isEmpty()) {
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.ERROR, "No hay mascotas para mostrar", null));
        }
        return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Lista de mascotas obtenida exitosamente", mascotas));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Mascota>> getMascotaById(@PathVariable long id) {
        try {
            Mascota mascota = mascotaService.getMascotaById(id);
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Mascota obtenida exitosamente", mascota));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(new ApiResponseDTO<>(Status.ERROR, "Mascota con el id: " + id + " no encontrada", null));
        }
    }


    @PostMapping
    public ResponseEntity<ApiResponseDTO<Mascota>> createMascota(@RequestBody MascotaDTO mascotaDTO) {
        try {
            Mascota nuevaMascota = mascotaService.createMascota(mascotaDTO);
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Mascota creada exitosamente", nuevaMascota));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponseDTO<>(Status.ERROR, e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponseDTO<>(Status.ERROR, "Error al crear la mascota", null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Mascota>> updateMascota(@PathVariable Long id, @RequestBody MascotaDTO mascotaDTO) {
        try {
            Mascota updatedMascota = mascotaService.updateMascota(id, mascotaDTO);
            return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Mascota actualizada exitosamente", updatedMascota));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO<>(Status.ERROR, e.getMessage(), null));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponseDTO<>(Status.ERROR, e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO<>(Status.ERROR, "Error al actualizar la mascota", null));
        }
    }


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
