package com.noCountry.petConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.noCountry.petConnect.model.PerfilUsuario;

import java.util.Date;

public record PerfilUsuarioDTO(@JsonProperty("name") String nombre,
                               @JsonProperty("photo") String foto,
                               @JsonProperty("telephone") String telefono,
                               @JsonProperty("sex") String sexo,
                               @JsonProperty("description") String descripcion,
                               @JsonProperty("birthDate") Date fecha_nacimiento,
                               @JsonProperty("latitude") int latitud,
                               @JsonProperty("longitude") int longitud) {

    public PerfilUsuarioDTO(PerfilUsuario perfil) {
        this(perfil.getNombre(), perfil.getFoto(),
                perfil.getTelefono(),
                perfil.getSexo(),
                perfil.getDescripcion(),
                perfil.getFecha_nacimiento(),
                perfil.getLatitud(),
                perfil.getLongitud());

    }
}


