package com.noCountry.petConnect.dto;

import com.noCountry.petConnect.model.Especie;

public record EspecieDTO(Long id, String nombre) {

    public EspecieDTO(Especie especie) {
        this(especie.getId(), especie.getNombre());
    }
}
