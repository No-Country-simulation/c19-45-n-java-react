package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.constants.Status;
import com.noCountry.petConnect.dto.ApiResponseDTO;
import com.noCountry.petConnect.dto.EmailConfirmacionDTO;
import com.noCountry.petConnect.dto.EmailTokenDTO;
import com.noCountry.petConnect.infra.errores.ApplicationException;
import com.noCountry.petConnect.model.Usuario;
import com.noCountry.petConnect.service.EmailService;
import com.noCountry.petConnect.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Tag(name = "Email")
@RestController
public class EmailController {

    private final UsuarioService usuarioService;
    private final EmailService emailService;

    public EmailController(UsuarioService usuarioService, EmailService emailService) {
        this.usuarioService = usuarioService;
        this.emailService = emailService;
    }

    @Operation(summary = "Api de confirmación de email, si el toquen recibido es valido el email queda verificado")
    @PostMapping("/api/email/confirmacion")
    public ResponseEntity<ApiResponseDTO> confirmarEmail(@RequestBody EmailTokenDTO token) {
        Usuario usuario = usuarioService.findByConfirmationToken(token.token())
                .orElseThrow(()-> new ApplicationException("El link de confirmación de email no es valido."));

        //Si el usuario ya ha confirmado su correo no es necesario crear un nuevo token
        if(!usuario.isEmail_confirmado()) {
            LocalDateTime tokenExpiracion = convertToLocalDateTime(usuario.getTokenExpiration());
            LocalDateTime now = LocalDateTime.now();
            if (now.isAfter(tokenExpiracion)) {
                throw new ApplicationException("El link de autenticación ha expirado.");
            }

            usuario.setEmail_confirmado(true);
        }

        usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS,"El email ha sido verificado.",null));
    }

    @Operation(summary = "Api para reenviar email, envia un nuevo mensaje de verificación al email especificado")
    @PostMapping("/api/email/reenviar")
    public ResponseEntity<ApiResponseDTO> reenviarEmailConfirmacion(@RequestBody @Valid EmailConfirmacionDTO email) {
        Usuario usuario = usuarioService.findByEmail(email.email())
                .orElseThrow(() -> new ApplicationException("No se encontró ningún usuario con el correo proporcionado, por favor registrate."));

        if(usuario.isEmail_confirmado()) {
            throw new ApplicationException("Este email ya ha sido verificado anteriormente, intente iniciar sesión");
        }

        // Generar un nuevo token y actualizar la fecha de expiración
        String newConfirmationToken = usuarioService.createConfirmationToken(usuario);
        usuario.setConfirmationToken(newConfirmationToken);
        usuario.setTokenExpiration(usuarioService.calculateExpirationDate());

        usuarioService.saveUsuario(usuario);

        String confirmationLink = "http://localhost:8080/email/confirmacion?token=" + newConfirmationToken;
        emailService.sendConfirmationEmail(usuario.getEmail(), confirmationLink);

        return ResponseEntity.ok(new ApiResponseDTO(Status.SUCCESS, "Se ha enviado un nuevo correo de confirmación a " + email.email(), null));

    }

    private LocalDateTime convertToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
