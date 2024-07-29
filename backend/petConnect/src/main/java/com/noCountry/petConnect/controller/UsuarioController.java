package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.constants.Status;
import com.noCountry.petConnect.dto.ApiResponseDTO;
import com.noCountry.petConnect.dto.UsuarioCrearDTO;
import com.noCountry.petConnect.infra.errores.ApplicationException;
import com.noCountry.petConnect.model.PerfilUsuario;
import com.noCountry.petConnect.model.Rol;
import com.noCountry.petConnect.model.Usuario;
import com.noCountry.petConnect.repository.PerfilUsuarioRepository;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

@Tag(name = "Usuario")
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final PerfilUsuarioRepository perfilUsuarioRepository;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder, EmailService emailService, PerfilUsuarioRepository perfilUsuarioRepository) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.perfilUsuarioRepository = perfilUsuarioRepository;
    }

    @Operation(summary = "Api para crear nuevos usuarios, no incluye administradores")
    @Transactional
    @PostMapping("/api/usuarios")
    public ResponseEntity<ApiResponseDTO> crearUsuario(@RequestBody @Valid UsuarioCrearDTO datosUsuario) {
        if (usuarioService.isEmailExists(datosUsuario.email())) {
            throw new ApplicationException("El correo electrónico ya ha sido registrado anteriormente. Por favor, intenta iniciar sesión.");
        }

        // Creación del usuario
        String password = passwordEncoder.encode(datosUsuario.password());
        Usuario usuario = new Usuario(datosUsuario.username(), datosUsuario.email(), password);
        Rol rolUser = usuarioService.getRolUser(); // Recuperar rol por defecto
        usuario.setRoles(Collections.singletonList(rolUser)); // Asignar el rol al usuario

        // Generar el token de confirmación y establecer la fecha de expiración
        String confirmationToken = usuarioService.createConfirmationToken(usuario);
        usuario.setConfirmationToken(confirmationToken);
        usuario.setTokenExpiration(usuarioService.calculateExpirationDate());

        // Guardar usuario
        usuarioService.saveUsuario(usuario);

        // Manejo de la imagen
        MultipartFile foto = datosUsuario.foto();
        if (foto != null && !foto.isEmpty()) {
            String fileName = foto.getOriginalFilename();
            String filePath = "src/main/resources/static/images/" + fileName; // Ajusta la ruta según sea necesario
            File destino = new File(filePath);
            try {
                foto.transferTo(destino);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Crear perfil de usuario
        PerfilUsuario perfil = new PerfilUsuario(usuario, datosUsuario.nombre(), foto.getOriginalFilename(),
                datosUsuario.telefono(), datosUsuario.sexo(),
                datosUsuario.descripcion(), datosUsuario.fechaNacimiento());
        perfilUsuarioRepository.save(perfil);

        // Enviar el correo de confirmación
        String confirmationLink = "http://localhost:8080/email/confirmacion?token=" + confirmationToken;
        emailService.sendConfirmationEmail(usuario.getEmail(), confirmationLink);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDTO(Status.SUCCESS,
                "Usuario y perfil creados con éxito. Por favor, verifica tu correo electrónico para activar tu cuenta.", null));
    }

    @Operation(summary = "Api para crear un nuevo password")
    @PostMapping("/api/usuario/password")
    public ResponseEntity<ApiResponseDTO> changePassword(@RequestBody String password) {
        String passwordEncriptada = passwordEncoder.encode(password);
        //obtener usuario
        return ResponseEntity.ok().body(new ApiResponseDTO(Status.SUCCESS,"Contraseña cambiada correctamente",null));
    }

    @Operation(summary = "Api para recuperar restablecer password")
    @PostMapping("/api/usuario/password/recuperar")
    public ResponseEntity<ApiResponseDTO> recuperarPassword(@RequestBody String password) {
        String passwordEncriptada = passwordEncoder.encode(password);
        //obtener usuario
        return ResponseEntity.ok().body(new ApiResponseDTO(Status.SUCCESS,"Contraseña cambiada correctamente",null));
    }

}
