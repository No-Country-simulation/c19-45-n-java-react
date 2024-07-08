package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.infra.errores.ApplicationException;
import com.noCountry.petConnect.model.dto.UsuarioCrearDTO;
import com.noCountry.petConnect.model.dto.UsuarioRespuestaDTO;
import com.noCountry.petConnect.model.entity.Rol;
import com.noCountry.petConnect.model.entity.Usuario;
import com.noCountry.petConnect.repository.RolRepository;
import com.noCountry.petConnect.repository.UsuarioRepository;
import com.noCountry.petConnect.service.EmailService;
import com.noCountry.petConnect.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@RestController
public class UsuarioController {

    final UsuarioRepository usuarioRespository;
    final PasswordEncoder passwordEncoder;
    final UsuarioService usuarioService;
    final EmailService emailService;
    private final RolRepository rolRepository;

    public UsuarioController(UsuarioRepository usuarioRespository, PasswordEncoder passwordEncoder, UsuarioService usuarioService, EmailService emailService, RolRepository rolRepository) {
        this.usuarioRespository = usuarioRespository;
        this.passwordEncoder = passwordEncoder;
        this.usuarioService = usuarioService;
        this.emailService = emailService;
        this.rolRepository = rolRepository;
    }

    @Transactional
    @PostMapping("/usuario/crear")
    public ResponseEntity login(@RequestBody @Valid UsuarioCrearDTO datosUsuario) {
        if (usuarioService.isEmailExists(datosUsuario.email()))
            throw new ApplicationException("email","El email ya se encuentra registrado");

        String password = passwordEncoder.encode(datosUsuario.password());
        Usuario usuario = new Usuario(datosUsuario.username(), datosUsuario.email(), password);

        Rol rolUser = rolRepository.findByNombre("USER"); // Suponiendo que "USER" es el nombre del rol por defecto
        if (rolUser == null) {
            // Manejar caso en el que el rol "USER" no exista en la base de datos
            throw new ApplicationException("rol", "El rol por defecto 'USER' no está configurado correctamente");
        }
        usuario.setRoles(Collections.singletonList(rolUser)); // Asignar el rol al usuario

        String confirmationToken = usuarioService.enviarCorreoConfirmacion(usuario);

        usuario.setConfirmationToken(confirmationToken);
        usuario.setTokenExpiration(calculateExpirationDate());

        usuarioRespository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("Usuario creado exitosamente. Por favor, confirma tu email para activar tu cuenta."));
    }

    record ApiResponse(String mensaje) {}

    private Date calculateExpirationDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 24);
        return cal.getTime();
    }
}
