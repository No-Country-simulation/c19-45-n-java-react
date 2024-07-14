package com.noCountry.petConnect.repository;

import com.noCountry.petConnect.model.entity.Mascota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends CrudRepository<Mascota, Long> {
}
