package com.noCountry.petConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.noCountry.petConnect.model.Mascota;
import com.noCountry.petConnect.model.Sexo;

import java.util.List;

public record MascotaResponseDTO(
        Long id,
        @JsonProperty("name") String name,
        @JsonProperty("specie") EspecieDTO especie,
        @JsonProperty("breed") String raza,
        @JsonProperty("age") String edad,
        @JsonProperty("sex") Sexo sexo,
        @JsonProperty("color") String color,
        @JsonProperty("vaccinated") Boolean vacunado,
        @JsonProperty("sterilized") Boolean esterilizado,
        @JsonProperty("photo") String fotoPrincipalUrl,
        @JsonProperty("additionalPhotos")List<String> fotosExtra,
        @JsonProperty("status") String estado,
        @JsonProperty("owner") UsuarioMascotaResponseDTO usuario
) {
    public MascotaResponseDTO(Mascota mascota) {
        this(mascota.getId(),
                mascota.getNombre(),
                new EspecieDTO(mascota.getEspecie()),
                mascota.getRaza(),
                mascota.getEdad(),
                mascota.getSexo(),
                mascota.getColor(),
                mascota.getVacunado(),
                mascota.getEsterilizado(),
                mascota.getFotoPrincipalUrl(),
                mascota.getFotosExtra(),
                mascota.getEstado(),
                new UsuarioMascotaResponseDTO(mascota.getDueño().getPerfilUsuario().getNombre(),mascota.getDueño().getEmail())
        );


    }
}
