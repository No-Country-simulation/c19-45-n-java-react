package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.infra.errores.ApplicationException;
import com.noCountry.petConnect.model.dto.TokenEmailDTO;
import com.noCountry.petConnect.model.entity.Usuario;
import com.noCountry.petConnect.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@RestController
public class EmailController {

    final UsuarioRepository usuarioRepository;

    public EmailController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("email/confirmacion")
    public ResponseEntity confirmarEmail(@RequestParam TokenEmailDTO token) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findByConfirmationToken(token.token());
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El token proporcionado no es valido.");
        }

        Usuario usuario = usuarioOptional.get();

        LocalDateTime tokenExpiracion = convertToLocalDateTime(usuario.getTokenExpiration());
        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(tokenExpiracion)) {
            //throw new ApplicationException("El link de autenticación ha expirado.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El link de autenticación ha expirado.");
        }

        usuario.setEmail_confirmado(true);
        usuarioRepository.save(usuario);

        return ResponseEntity.ok("El email ha sido confirmado.");
    }

    private LocalDateTime convertToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
