package com.noCountry.petConnect.security;

import com.noCountry.petConnect.repository.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    private UsuarioRespository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correroElectronico) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(correroElectronico);
    }
}
