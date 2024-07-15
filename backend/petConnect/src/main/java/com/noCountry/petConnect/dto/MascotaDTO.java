package com.noCountry.petConnect.model.dto;

import com.noCountry.petConnect.model.entity.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MascotaDTO {

    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private String edad;
    private Sexo sexo;
    private String color;
    private String necesidadesEspeciales;
    private Boolean vacunado;
    private Boolean esterilizado;
    private byte[] foto;
    private String estado;
}
