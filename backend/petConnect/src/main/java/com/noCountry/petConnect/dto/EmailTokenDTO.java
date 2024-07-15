package com.noCountry.petConnect.dto;

import jakarta.validation.constraints.NotBlank;

public record EmailTokenDTO(@NotBlank String token) {
}
