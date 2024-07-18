package com.noCountry.petConnect.dto;

import com.noCountry.petConnect.model.PerfilUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record PerfilUsuarioDTO(@NotBlank String nombre,
                               String foto,
                               int telefono,
                               String sexo,
                               Date fecha_nacimiento,
                               int latitud,
                               int longitud) {

    public PerfilUsuarioDTO(PerfilUsuario perfil) {
    this(perfil.getNombre(), perfil.getFoto(),
            perfil.getTelefono(),
            perfil.getSexo(),
            perfil.getFecha_nacimiento(),
            perfil.getLatitud(),
            perfil.getLongitud());
    }
}


