package com.noCountry.petConnect.service;

import com.noCountry.petConnect.infra.errores.ApplicationException;
import com.noCountry.petConnect.model.Rol;
import com.noCountry.petConnect.model.Usuario;
import com.noCountry.petConnect.repository.RolRepository;
import com.noCountry.petConnect.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    public boolean isEmailExists(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public Optional<Usuario> findByConfirmationToken(String token) {
        return usuarioRepository.findByConfirmationToken(token);
    }

    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Rol getRolUser() {
        Rol rolUser = rolRepository.findByNombre("USER");
        if (rolUser == null) {
            throw new ApplicationException("rol", "El rol por defecto 'USER' no está configurado correctamente");
        }
        return rolUser;
    }

    public String createConfirmationToken(Usuario usuario) {
        return UUID.randomUUID().toString();
    }

    public Date calculateExpirationDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 24);
        return cal.getTime();
    }

    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
