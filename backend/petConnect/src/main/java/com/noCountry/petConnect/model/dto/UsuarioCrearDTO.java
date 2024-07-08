package com.noCountry.petConnect.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioCrearDTO(
        @NotBlank String username,
        @Email String email,
        @NotBlank String password) {
}