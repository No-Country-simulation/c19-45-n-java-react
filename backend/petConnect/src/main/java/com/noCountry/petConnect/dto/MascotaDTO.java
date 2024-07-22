package com.noCountry.petConnect.dto;

import com.noCountry.petConnect.model.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MascotaDTO {

    private Long id;
    private String nombre;
    private Long especie_id;
    private String raza;
    private String edad;
    private Sexo sexo;
    private String color;
    private String necesidadesEspeciales;
    private Boolean vacunado;
    private Boolean esterilizado;
    private String estado;
    private Long propietarioId;
    private String fotoPrincipalUrl;
    private List<String> fotosExtra;
}
