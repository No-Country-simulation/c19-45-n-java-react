package com.noCountry.petConnect.mapper;

import com.noCountry.petConnect.dto.MascotaResponseDTO;
import com.noCountry.petConnect.dto.MascotaSimpleResponseDTO;
import com.noCountry.petConnect.model.Mascota;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MascotaMapper {

    public MascotaSimpleResponseDTO toSimpleResponseDTO(Mascota mascota) {
        return new MascotaSimpleResponseDTO(
                mascota.getId(),
                mascota.getNombre(),
                mascota.getSexo().toString(),
                mascota.getEdad(),
                mascota.getFotoPrincipalUrl()
        );
    }

    public MascotaResponseDTO toResponseDTO(Mascota mascota) {
        return new MascotaResponseDTO(mascota);
    }

    public List<MascotaSimpleResponseDTO> toSimpleResponseDTOList(List<Mascota> mascotas) {
        return mascotas.stream()
                .map(this::toSimpleResponseDTO)
                .collect(Collectors.toList());
    }

    public List<MascotaResponseDTO> toResponseDTOList(List<Mascota> mascotas) {
        return mascotas.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
