package com.noCountry.petConnect.dto;

import com.noCountry.petConnect.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public record UsuarioDatosDTO (
        Long id,
        String email,
        List<RoleDTO> roles
        ){

    public UsuarioDatosDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getRoles().stream()
                        .map(role -> new RoleDTO(role.getNombre()))
                        .collect(Collectors.toList())
        );
    }
}
