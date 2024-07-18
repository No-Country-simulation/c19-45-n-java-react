package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.constants.Status;
import com.noCountry.petConnect.dto.ApiResponseDTO;
import com.noCountry.petConnect.dto.PerfilUsuarioDTO;
import com.noCountry.petConnect.infra.errores.ApplicationException;
import com.noCountry.petConnect.model.PerfilUsuario;
import com.noCountry.petConnect.model.Usuario;
import com.noCountry.petConnect.repository.PerfilUsuarioRepository;
import com.noCountry.petConnect.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Perfil Usuario")
@SecurityRequirement(name = "bearer-key")
@RestController
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Operation(summary = "Obtiene el perfil de usuario con el ID ingresado")
    @GetMapping("/api/usuario/{id}")
    public ResponseEntity obtenerPerfilUsuario(@PathVariable long id){
        PerfilUsuario perfil = perfilUsuarioRepository.findById(id).orElseThrow(()->new ApplicationException("El perfil del usuario no se ha encontrado"));
        PerfilUsuarioDTO perfilUsuarioDTO = new PerfilUsuarioDTO(perfil);
        return ResponseEntity.ok().body(new ApiResponseDTO<>(Status.SUCCESS,"Perfil usuario ecnontrado",perfilUsuarioDTO));
    }
    @Operation(summary = "Crea el perfil de usuario")
    @PostMapping("/api/usuario/{id}")
    public ResponseEntity crearPerfilUsuario(@PathVariable long id, @RequestBody PerfilUsuarioDTO perfilUsuario){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->new ApplicationException("El id del usuario no se ha encontrado"));
        PerfilUsuario perfil = new PerfilUsuario(id,perfilUsuario);
        perfilUsuarioRepository.save(perfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDTO<>(Status.SUCCESS,"El perfil de usuario ha sido creado",null));
    };

    @Operation(summary = "Actualiza el perfil de usuario")
    @PutMapping("/api/usuario/{id}")
    public ResponseEntity actualizarPerfilUsuario(@PathVariable long id, @RequestBody PerfilUsuarioDTO perfilUsuario) {
        PerfilUsuario perfil = perfilUsuarioRepository.findById(id)
                .orElseThrow(()->new ApplicationException("No se ha encontrado el perfil de usuario"));

        perfil.actualizarPerfilUsuario(perfilUsuario);
        perfilUsuarioRepository.save(perfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDTO<>(Status.SUCCESS,"El perfil de usuario se ha actualizado correctamente",null));
    }

    @DeleteMapping("/api/usuario/{id}")
    public ResponseEntity borrarPerfilUsuario(@PathVariable long id) {
        PerfilUsuario perfil = perfilUsuarioRepository.findById(id)
            .orElseThrow(()->new ApplicationException("Nose encontro el perfil de usuario"));

        perfilUsuarioRepository.delete(perfil);
        return ResponseEntity.ok().body(new ApiResponseDTO<>(Status.SUCCESS,"El perfil de usuario ha sido eliminado",null));

    }
}
