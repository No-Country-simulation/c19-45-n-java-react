package com.noCountry.petConnect.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.noCountry.petConnect.dto.MascotaDTO;
import com.noCountry.petConnect.model.Mascota;
import com.noCountry.petConnect.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    @Autowired
    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public ResponseEntity<?> getAllMascotas() {
        try {
            List<Mascota> mascotas = mascotaService.getAllMascotas();
            if (mascotas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay mascotas para mostrar");
            }
            return new ResponseEntity<>(mascotas, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al obtener las mascotas: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable Long id) {
        Mascota mascota = mascotaService.getMascotaById(id);
        return ResponseEntity.ok(mascota);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Mascota> createMascota(
            @RequestPart("mascota") String mascotaJson,
            @RequestPart("foto") MultipartFile foto) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MascotaDTO mascotaDTO = objectMapper.readValue(mascotaJson, MascotaDTO.class);

        if (!foto.isEmpty()) {
            mascotaDTO.setFoto(foto.getBytes());
        }

        Mascota nuevaMascota = mascotaService.createMascota(mascotaDTO);
        return ResponseEntity.ok(nuevaMascota);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Mascota> updateMascota(
            @PathVariable Long id,
            @RequestPart("mascota") String mascotaJson,
            @RequestPart("foto") MultipartFile foto) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        MascotaDTO mascotaDTO = objectMapper.readValue(mascotaJson, MascotaDTO.class);

        // Convertimos la imagen a bytes y la asignamos al DTO
        if (!foto.isEmpty()) {
            mascotaDTO.setFoto(foto.getBytes());
        }

        // Llamamos al servicio para actualizar la mascota
        Mascota mascotaActualizada = mascotaService.updateMascota(id, mascotaDTO);
        return ResponseEntity.ok(mascotaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMascota(@PathVariable Long id) {
        try {
            boolean isDeleted = mascotaService.deleteMascota(id);
            if (isDeleted) {
                return ResponseEntity.ok("Mascota eliminada exitosamente.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo eliminar la mascota. Error: " + e.getMessage());
        }
    }


}