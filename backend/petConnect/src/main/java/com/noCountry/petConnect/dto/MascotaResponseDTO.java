package com.noCountry.petConnect.dto;

import com.noCountry.petConnect.model.Mascota;
import com.noCountry.petConnect.model.Sexo;
import java.util.List;

public record MascotaResponseDTO(
        Long id,
        String nombre,
        EspecieDTO especie,
        String raza,
        String edad,
        Sexo sexo,
        String color,
        String fotoPrincipalUrl,
        List<String> fotosExtra,
        String estado
) {
    public MascotaResponseDTO(Mascota mascota) {
        this(mascota.getId(),
             mascota.getNombre(),
             new EspecieDTO(mascota.getEspecie()),
             mascota.getRaza(),
             mascota.getEdad(),
             mascota.getSexo(),
             mascota.getColor(),
             mascota.getFotoPrincipalUrl(),
             mascota.getFotosExtra(),
             mascota.getEstado()
        );


    }
}
