package com.noCountry.petConnect.service;

import com.noCountry.petConnect.model.dto.MascotaDTO;
import com.noCountry.petConnect.model.entity.Mascota;
import com.noCountry.petConnect.repository.MascotaRepository;

import com.noCountry.petConnect.service.exepcions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    @Autowired
    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public Mascota getMascotaById(long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota con el id: " + id + " no encontrada"));
    }

    @Transactional
    public Mascota createMascota(MascotaDTO mascotaDTO) {
        Mascota mascota = mapToEntity(mascotaDTO);
        return mascotaRepository.save(mascota);
    }

    @Transactional
    public Mascota updateMascota(long id, MascotaDTO mascotaDTO) {
        Mascota existingMascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota con el id: " + id + " no encontrada"));

        existingMascota.setNombre(mascotaDTO.getNombre());
        existingMascota.setEspecie(mascotaDTO.getEspecie());
        existingMascota.setRaza(mascotaDTO.getRaza());
        existingMascota.setEdad(mascotaDTO.getEdad());
        existingMascota.setSexo(mascotaDTO.getSexo());
        existingMascota.setColor(mascotaDTO.getColor());
        existingMascota.setNecesidadesEspeciales(mascotaDTO.getNecesidadesEspeciales());
        existingMascota.setVacunado(mascotaDTO.getVacunado());
        existingMascota.setEsterilizado(mascotaDTO.getEsterilizado());
        existingMascota.setFoto(mascotaDTO.getFoto());
        existingMascota.setEstado(mascotaDTO.getEstado());

        return mascotaRepository.save(existingMascota);
    }

    public String deleteMascota(long id) {
        if (mascotaRepository.existsById(id)) {
            mascotaRepository.deleteById(id);
            return "Mascota eliminada";
        } else {
            throw new ResourceNotFoundException("Mascota no encontrada");
        }
    }

    private Mascota mapToEntity(MascotaDTO mascotaDTO) {
        Mascota mascota = new Mascota();
        mascota.setNombre(mascotaDTO.getNombre());
        mascota.setEspecie(mascotaDTO.getEspecie());
        mascota.setRaza(mascotaDTO.getRaza());
        mascota.setEdad(mascotaDTO.getEdad());
        mascota.setSexo(mascotaDTO.getSexo());
        mascota.setColor(mascotaDTO.getColor());
        mascota.setNecesidadesEspeciales(mascotaDTO.getNecesidadesEspeciales());
        mascota.setVacunado(mascotaDTO.getVacunado());
        mascota.setEsterilizado(mascotaDTO.getEsterilizado());
        mascota.setFoto(mascotaDTO.getFoto());
        mascota.setEstado(mascotaDTO.getEstado());
        return mascota;
    }
}
