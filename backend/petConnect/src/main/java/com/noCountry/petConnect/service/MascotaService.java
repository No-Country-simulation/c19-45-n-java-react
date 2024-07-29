package com.noCountry.petConnect.service;

import com.noCountry.petConnect.dto.MascotaDTO;
import com.noCountry.petConnect.infra.errores.ApplicationException;
import com.noCountry.petConnect.model.Especie;
import com.noCountry.petConnect.model.Mascota;
import com.noCountry.petConnect.model.Sexo;
import com.noCountry.petConnect.model.Usuario;
import com.noCountry.petConnect.repository.EspecieRepository;
import com.noCountry.petConnect.repository.MascotaRepository;
import com.noCountry.petConnect.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumSet;
import java.util.List;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final UsuarioRepository usuarioRepository;
    private final EspecieRepository especieRepository;

    @Autowired
    public MascotaService(MascotaRepository mascotaRepository, UsuarioRepository usuarioRepository, EspecieRepository especieRepository) {
        this.mascotaRepository = mascotaRepository;
        this.usuarioRepository = usuarioRepository;
        this.especieRepository = especieRepository;
    }

    public List<Mascota> getAllMascotas() {
        List<Mascota> mascotas = mascotaRepository.findAll();
        if (mascotas.isEmpty()) {
            throw new ApplicationException("No hay mascotas para mostrar");
        }
        return mascotas;
    }

    public Mascota getMascotaById(long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new ApplicationException("Mascota con el id: " + id + " no encontrada"));
    }

    public List<Mascota> filtrarMascotas(String nombre, Sexo sexo, Long especieId) {
        if(especieId != null) {
            especieRepository.findById(especieId)
                    .orElseThrow(()-> new ApplicationException("Especie: " + especieId + " no encontrado"));
        }

        if(sexo != null && !EnumSet.allOf(Sexo.class).contains(sexo)) {
            throw new ApplicationException("El sexo proporcionado no es valido");
        }

        List<Mascota> mascotas = mascotaRepository.filtrarMascotas(nombre, sexo, especieId);

        if (mascotas.isEmpty()) {
            throw new ApplicationException("No se encontraron mascotas con los criterios especificados");
        }

        return mascotas;
    }


    @Transactional
    public Mascota createMascota(MascotaDTO mascotaDTO) {
        Mascota mascota = mapToEntity(mascotaDTO);

        if (mascotaDTO.propietarioId() != null) {
            Usuario propietario = usuarioRepository.findById(mascotaDTO.propietarioId())
                    .orElseThrow(() -> new ApplicationException("Usuario no encontrado con id: " + mascotaDTO.propietarioId()));
            mascota.setDueño(propietario);
        } else {
            throw new IllegalArgumentException("Se requiere un ID de propietario para crear una mascota");
        }

        if (mascotaDTO.especieId() != null) {
            Especie especie = especieRepository.findById(mascotaDTO.especieId())
                    .orElseThrow(() -> new ApplicationException("Especie no encontrada con id: " + mascotaDTO.especieId()));
            mascota.setEspecie(especie);
        } else {
            throw new IllegalArgumentException("Se requiere un ID de especie para crear una mascota");
        }

        return mascotaRepository.save(mascota);
    }
    @Transactional
    public Mascota updateMascota(long id, MascotaDTO mascotaDTO) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new ApplicationException("Mascota con el id: " + id + " no encontrada"));

        Especie especie = especieRepository.findById(mascotaDTO.especieId())
                .orElseThrow(() -> new ApplicationException("Especie con el id: " + mascotaDTO.especieId() + " no encontrada"));

        mascota.setNombre(mascotaDTO.nombre());
        mascota.setEspecie(especie);
        mascota.setRaza(mascotaDTO.raza());
        mascota.setEdad(mascotaDTO.edad());
        mascota.setSexo(mascotaDTO.sexo());
        mascota.setColor(mascotaDTO.color());
        mascota.setNecesidadesEspeciales(mascotaDTO.necesidadesEspeciales());
        mascota.setVacunado(mascotaDTO.vacunado());
        mascota.setEsterilizado(mascotaDTO.esterilizado());
        mascota.setEstado(mascotaDTO.estado());
        mascota.setFotoPrincipalUrl(mascotaDTO.fotoPrincipalUrl());
        mascota.setFotosExtra(mascotaDTO.fotosExtra());

        return mascotaRepository.save(mascota);
    }


    public boolean deleteMascota(long id) {
        if (mascotaRepository.existsById(id)) {
            mascotaRepository.deleteById(id);
            return true;
        } else {
            throw new ApplicationException("Mascota no encontrada");
        }
    }

    private Mascota mapToEntity(MascotaDTO mascotaDTO) {

        Especie especie = especieRepository.findById(mascotaDTO.especieId())
                .orElseThrow(() -> new ApplicationException("Especie con el id: " + mascotaDTO.especieId() + " no ecnotrado"));

        Mascota mascota = new Mascota();
        mascota.setNombre(mascotaDTO.nombre());
        mascota.setEspecie(especie);
        mascota.setRaza(mascotaDTO.raza());
        mascota.setEdad(mascotaDTO.edad());
        mascota.setSexo(mascotaDTO.sexo());
        mascota.setColor(mascotaDTO.color());
        mascota.setNecesidadesEspeciales(mascotaDTO.necesidadesEspeciales());
        mascota.setVacunado(mascotaDTO.vacunado());
        mascota.setEsterilizado(mascotaDTO.esterilizado());
        mascota.setEstado(mascotaDTO.estado());
        mascota.setFotoPrincipalUrl(mascotaDTO.fotoPrincipalUrl());
        mascota.setFotosExtra(mascotaDTO.fotosExtra());

        return mascota;
    }
}
