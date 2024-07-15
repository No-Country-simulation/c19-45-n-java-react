package com.noCountry.petConnect.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AutenticacionUsuarioCrearDTO(
        @Email String email,
        @NotBlank String password){
}
