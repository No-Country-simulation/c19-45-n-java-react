package com.noCountry.petConnect.dto;

import com.noCountry.petConnect.model.Sexo;
import java.util.List;

public record MascotaResponseDTO(
        Long id,
        String nombre,
        String especie,
        String raza,
        String edad,
        Sexo sexo,
        String color,
        String fotoPrincipalUrl,
        List<String> fotosExtra,
        String estado
) {}
