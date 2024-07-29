package com.noCountry.petConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.noCountry.petConnect.model.Especie;

public record EspecieDTO(Long id, @JsonProperty("name") String nombre) {

    public EspecieDTO(Especie especie) {
        this(especie.getId(), especie.getNombre());
    }
}
