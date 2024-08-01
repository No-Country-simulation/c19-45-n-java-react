package com.noCountry.petConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UsuarioMascotaResponseDTO (@JsonProperty("name") String nombre,
                                         @JsonProperty("email") String email){
    ;

}
