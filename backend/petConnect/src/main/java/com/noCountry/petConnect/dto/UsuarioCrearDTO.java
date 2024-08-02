package com.noCountry.petConnect.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioCrearDTO(
        @NotBlank String username,
        @Email @NotBlank String email,
        @NotBlank String password) {
}