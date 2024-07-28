package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.constants.Status;
import com.noCountry.petConnect.dto.ApiResponseDTO;
import com.noCountry.petConnect.dto.EspecieDTO;
import com.noCountry.petConnect.infra.errores.ApplicationException;
import com.noCountry.petConnect.model.Especie;
import com.noCountry.petConnect.repository.EspecieRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name ="Especies")
@RestController
public class EspecieController {


    private final EspecieRepository especieRepository;

    @Autowired
    public EspecieController(EspecieRepository especieRepository) {
        this.especieRepository = especieRepository;
    }

    @Operation(summary = "Api para mostrar todas las especies")
    @GetMapping("/api/especies")
    public ResponseEntity obtenerEspecies() {
        List<Especie> especies = especieRepository.findAll();
        if (especies.isEmpty()) {
            throw new ApplicationException("No hay nunguna especie registrada aún");
        }
        List<EspecieDTO> especieDTOs = especies.stream()
                .map(especie -> new EspecieDTO(especie.getId(), especie.getNombre()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(new ApiResponseDTO<>(Status.SUCCESS,"Petición exitosa",especieDTOs));
    }

}
