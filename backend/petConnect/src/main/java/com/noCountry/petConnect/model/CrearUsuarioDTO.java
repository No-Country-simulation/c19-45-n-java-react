package com.noCountry.petConnect.model;

import jakarta.validation.constraints.NotBlank;

public record CrearUsuarioDTO(
        @NotBlank
        String username,
        @NotBlank
        String email,
        @NotBlank
        String password) {
}
