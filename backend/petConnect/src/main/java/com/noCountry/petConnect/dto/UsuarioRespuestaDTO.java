package com.noCountry.petConnect.dto;

import com.noCountry.petConnect.model.Usuario;

public record UsuarioRespuestaDTO(
        String status,
        String message,
        UsuarioDatosDTO usuario) {

    public UsuarioRespuestaDTO(String status, String message, Usuario usuario) {
        this(status,
             message,
             new UsuarioDatosDTO(usuario)
        );
    }
}
