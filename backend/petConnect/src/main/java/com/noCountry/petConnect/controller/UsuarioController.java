package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.constants.Status;
import com.noCountry.petConnect.dto.ApiResponseDTO;
import com.noCountry.petConnect.dto.UsuarioCrearDTO;
import com.noCountry.petConnect.infra.errores.ApplicationException;
import com.noCountry.petConnect.model.Rol;
import com.noCountry.petConnect.model.Usuario;
import com.noCountry.petConnect.service.EmailService;
import com.noCountry.petConnect.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Tag(name = "Usuario")
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Operation(summary = "Api para crear nuevos usuarios, no incluye administradores")
    @Transactional
    @PostMapping("/api/usuarios")
    public ResponseEntity<ApiResponseDTO> crearUsuario(@RequestBody @Valid UsuarioCrearDTO datosUsuario) {
        if (usuarioService.isEmailExists(datosUsuario.email())) {
            throw new ApplicationException("El correo electrónico ya ha sido registrado anteriormente. Por favor, intenta iniciar sesión.");
        }

        String password = passwordEncoder.encode(datosUsuario.password());
        Usuario usuario = new Usuario(datosUsuario.username(), datosUsuario.email(), password);

        Rol rolUser = usuarioService.getRolUser(); // Recuperar rol por defecto
        usuario.setRoles(Collections.singletonList(rolUser)); // Asignar el rol al usuario

        // Generar el token de confirmación y establecer la fecha de expiración
        String confirmationToken = usuarioService.createConfirmationToken(usuario);
        usuario.setConfirmationToken(confirmationToken);
        usuario.setTokenExpiration(usuarioService.calculateExpirationDate());

        usuarioService.saveUsuario(usuario);

        // Enviar el correo de confirmación
        String confirmationLink = "http://localhost:8080/email/confirmacion?token=" + confirmationToken;
        emailService.sendConfirmationEmail(usuario.getEmail(), confirmationLink);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDTO(Status.SUCCESS,
                                "Usuario creado con éxito. Por favor, verifica tu correo electrónico para activar tu cuenta.",null));
    }

    @PostMapping("/usuario/password")
    public ResponseEntity<ApiResponseDTO> changePassword(@RequestBody String password) {
        String passwordEncriptada = passwordEncoder.encode(password);
        //obtener usuario
        return ResponseEntity.ok().body(new ApiResponseDTO(Status.SUCCESS,"Contraseña cambiada correctamente",null));
    }

}
