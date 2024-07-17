package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.dto.MascotaDTO;
import com.noCountry.petConnect.model.Mascota;
import com.noCountry.petConnect.service.MascotaService;
import com.noCountry.petConnect.infra.errores.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return ResponseEntity.ok(mascotas);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMascotaById(@PathVariable long id) {
        try {
            Mascota mascota = mascotaService.getMascotaById(id);
            return ResponseEntity.ok(mascota);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> crearMascota(@RequestBody MascotaDTO mascotaDTO) {
        try {
            Mascota nuevaMascota = mascotaService.createMascota(mascotaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMascota(@PathVariable long id, @RequestBody MascotaDTO mascotaDTO) {
        try {
            Mascota updatedMascota = mascotaService.updateMascota(id, mascotaDTO);
            return ResponseEntity.ok(updatedMascota);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMascota(@PathVariable long id) {
        try {
            boolean eliminado = mascotaService.deleteMascota(id);
            if (eliminado) {
                return ResponseEntity.ok("Mascota eliminada exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la mascota");
            }
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
