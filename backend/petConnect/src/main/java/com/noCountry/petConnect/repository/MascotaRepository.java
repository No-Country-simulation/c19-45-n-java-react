package com.noCountry.petConnect.repository;

import com.noCountry.petConnect.model.Mascota;
import com.noCountry.petConnect.model.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    @Query("SELECT m FROM mascotas m WHERE " +
            "(COALESCE(:nombre, '') = '' OR LOWER(m.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND " +
            "(:sexo IS NULL OR m.sexo = :sexo) AND " +
            "(:especieId IS NULL OR m.especie.id = :especieId)")
    List<Mascota> filtrarMascotas(@Param("nombre") String nombre,
                                  @Param("sexo") Sexo sexo,
                                  @Param("especieId") Long especieId);

}
