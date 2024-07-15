package com.noCountry.petConnect.dto;

import com.noCountry.petConnect.constants.Status;

public record ApiResponseDTO<T>(Status status, String message,T data) {
}
