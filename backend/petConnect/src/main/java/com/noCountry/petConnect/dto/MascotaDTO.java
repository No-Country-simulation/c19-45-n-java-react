package com.noCountry.petConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.noCountry.petConnect.model.Sexo;

import java.util.List;


public record MascotaDTO(
                        @JsonProperty("name")  String nombre,
                        @JsonProperty("specieId")  Long especieId,
                        @JsonProperty("breed")  String raza,
                        @JsonProperty("age")  String edad,
                        @JsonProperty("sex")  Sexo sexo,
                        @JsonProperty("color")  String color,
                        @JsonProperty("specialNeeds") String necesidadesEspeciales,
                        @JsonProperty("vaccinated") Boolean vacunado,
                        @JsonProperty("sterilized") Boolean esterilizado,
                        @JsonProperty("status") String estado,
                        @JsonProperty("ownerId") Long propietarioId,
                        @JsonProperty("photo") String fotoPrincipalUrl,
                        @JsonProperty("additionalPhotos") List<String> fotosExtra) {
}
