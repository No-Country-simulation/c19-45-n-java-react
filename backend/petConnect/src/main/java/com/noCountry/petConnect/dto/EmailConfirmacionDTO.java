package com.noCountry.petConnect.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailConfirmacionDTO(@Email @NotBlank String email) {
}
