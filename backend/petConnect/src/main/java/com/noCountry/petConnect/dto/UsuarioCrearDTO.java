package com.noCountry.petConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record UsuarioCrearDTO(
        @NotBlank String username,
        @Email @NotBlank String email,
        @NotBlank String password,
        @JsonProperty("sex") String sexo,
        @JsonProperty("photo") MultipartFile foto,
        @JsonProperty("description") String descripcion,
        @JsonProperty("name")String nombre,
        @JsonProperty("telephone") String telefono,
        @JsonProperty("birthDate") Date fechaNacimiento) {
}