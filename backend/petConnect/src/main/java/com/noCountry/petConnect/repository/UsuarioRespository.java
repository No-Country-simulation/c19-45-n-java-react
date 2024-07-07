package com.noCountry.petConnect.repository;

import com.noCountry.petConnect.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UsuarioRespository extends JpaRepository<Usuario, Long> {

    UserDetails findByEmail(String email);

}
