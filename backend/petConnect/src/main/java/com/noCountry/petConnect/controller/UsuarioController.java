package com.noCountry.petConnect.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.noCountry.petConnect.config.S3Config;
import com.noCountry.petConnect.constants.Status;
import com.noCountry.petConnect.dto.ApiResponseDTO;
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
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Tag(name = "Usuario")
@RestController
public class UsuarioController {

    @Autowired
    private S3Config s3Config;

    @Autowired
    private AmazonS3 s3Client;

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Operation(summary = "Api para crear nuevos usuarios, no incluye administradores")
    @Transactional
    @PostMapping(value = "/api/usuarios", consumes = "multipart/form-data")
    public ResponseEntity<ApiResponseDTO> crearUsuario(
            @RequestParam("username") String username,
            @RequestParam("email") @Email String email,
            @RequestParam("password") String password,
            @RequestParam("sex") String sexo,
            @RequestParam(value = "photo", required = false) MultipartFile foto,
            @RequestParam("description") String descripcion,
            @RequestParam("name") String nombre,
            @RequestParam("telephone") String telefono,
            @RequestParam("birthDate") String fechaNacimiento) {

        if (usuarioService.isEmailExists(email)) {
            throw new ApplicationException("El correo electrónico ya ha sido registrado anteriormente. Por favor, intenta iniciar sesión.");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimientoFormat;
        try {
            fechaNacimientoFormat = format.parse(fechaNacimiento);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Fecha de nacimiento inválida", e);
        }

        // Creación del usuario
        String passwordEncriptado = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(username, email, passwordEncriptado);
        Rol rolUser = usuarioService.getRolUser(); // Recuperar rol por defecto
        usuario.setRoles(Collections.singletonList(rolUser)); // Asignar el rol al usuario

        // Generar el token de confirmación y establecer la fecha de expiración
        String confirmationToken = usuarioService.createConfirmationToken(usuario);
        usuario.setConfirmationToken(confirmationToken);
        usuario.setTokenExpiration(usuarioService.calculateExpirationDate());

        // Guardar usuario
        Usuario usuarioGuardado = usuarioService.saveUsuario(usuario);

        // Manejo de la imagen
        String fotoUrl = null;
        if (foto != null && !foto.isEmpty()) {
            // Generar nombre único para el archivo
            String fileName = UUID.randomUUID().toString() + "-" + foto.getOriginalFilename();

            // Crear el ObjectMetadata y configurar Content-Type y Content-Disposition
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(foto.getContentType()); // Configura el Content-Type del archivo
            metadata.setContentDisposition("inline"); // Muestra el archivo en el navegador

            try (InputStream inputStream = foto.getInputStream()) {
                // Subir la imagen a S3 con los metadatos configurados
                s3Client.putObject(new PutObjectRequest(s3Config.bucketName(), fileName, inputStream, metadata));
                fotoUrl = s3Client.getUrl(s3Config.bucketName(), fileName).toString(); // Obtener URL de la imagen
            } catch (IOException e) {
                throw new RuntimeException("Error al subir la imagen a S3", e);
            }
        }

        // Crear perfil de usuario
        PerfilUsuario perfil = new PerfilUsuario();
        perfil.setUsuario(usuarioGuardado); // Establece la relación con el usuario guardado
        perfil.setNombre(nombre);
        perfil.setFoto(fotoUrl);
        perfil.setTelefono(telefono);
        perfil.setSexo(sexo);
        perfil.setDescripcion(descripcion);
        perfil.setFechaNacimiento(fechaNacimientoFormat);
        perfil.setLatitud(0); // Ajusta según sea necesario
        perfil.setLongitud(0); // Ajusta según sea necesario

        perfilUsuarioRepository.save(perfil);

        // Enviar el correo de confirmación
        String confirmationLink = "http://localhost:8080/email/confirmacion?token=" + confirmationToken;
        emailService.sendConfirmationEmail(usuario.getEmail(), confirmationLink);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDTO(Status.SUCCESS,
                "Usuario y perfil creados con éxito. Por favor, verifica tu correo electrónico para activar tu cuenta.", null));
    }

    @PostMapping("/api/usuario/password")
    public ResponseEntity<ApiResponseDTO> changePassword(@RequestBody String password) {
        String passwordEncriptada = passwordEncoder.encode(password);
        //obtener usuario
        return ResponseEntity.ok().body(new ApiResponseDTO(Status.SUCCESS,"Contraseña cambiada correctamente",null));
    }

}
