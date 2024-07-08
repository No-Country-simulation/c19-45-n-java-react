package com.noCountry.petConnect.model.dto;

import jakarta.validation.constraints.NotBlank;

public record TokenEmailDTO(@NotBlank String token) {
}
