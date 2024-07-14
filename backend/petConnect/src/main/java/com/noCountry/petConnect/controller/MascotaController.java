package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.model.dto.MascotaDTO;
import com.noCountry.petConnect.model.entity.Mascota;
import com.noCountry.petConnect.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    @Autowired
    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable Long id) {
        Mascota mascota = mascotaService.getMascotaById(id);
        return ResponseEntity.ok(mascota);
    }

    @PostMapping
    public ResponseEntity<Mascota> createMascota(
            @RequestPart("mascota") MascotaDTO mascotaDTO,
            @RequestPart("foto") MultipartFile foto) throws IOException {

        mascotaDTO.setFoto(foto.getBytes());
        Mascota nuevaMascota = mascotaService.createMascota(mascotaDTO);
        return ResponseEntity.ok(nuevaMascota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> updateMascota(
            @PathVariable Long id,
            @RequestPart("mascota") MascotaDTO mascotaDTO,
            @RequestPart("foto") MultipartFile foto) throws IOException {

        mascotaDTO.setFoto(foto.getBytes());
        Mascota mascotaActualizada = mascotaService.updateMascota(id, mascotaDTO);
        return ResponseEntity.ok(mascotaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable Long id) {
        mascotaService.deleteMascota(id);
        return ResponseEntity.noContent().build();
    }
}
