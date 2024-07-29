package com.noCountry.petConnect.dto;

public record MascotaSimpleResponseDTO(
        Long id,
        String name,
        String sex,
        String age,
        String picture
) {
}

