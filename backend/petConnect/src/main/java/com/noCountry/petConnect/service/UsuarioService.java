package com.noCountry.petConnect.service;

import com.noCountry.petConnect.model.entity.Usuario;
import com.noCountry.petConnect.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EmailService emailService;

    public UsuarioService(UsuarioRepository usuarioRepository, EmailService emailService) {
        this.usuarioRepository = usuarioRepository;
        this.emailService = emailService;
    }

    public boolean isEmailExists(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public String enviarCorreoConfirmacion(Usuario usuario) {
        String confirmationToken = UUID.randomUUID().toString();
        String confirmationLink = "http://localhost:8080/email/confirmacion?token=" + confirmationToken;
        emailService.sendConfirmationEmail(usuario.getEmail(), confirmationLink);

        return confirmationToken;
    }
}
