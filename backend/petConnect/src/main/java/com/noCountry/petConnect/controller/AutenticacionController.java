package com.noCountry.petConnect.controller;


import com.noCountry.petConnect.infra.security.TokenService;
import com.noCountry.petConnect.model.dto.AutenticacionUsuarioCrearDTO;
import com.noCountry.petConnect.model.dto.JWTTokenDTO;
import com.noCountry.petConnect.model.entity.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "bearer-key")
@Tag(name = "Autenticacion")
@RestController
@RequestMapping("/login")
public class AutenticacionController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AutenticacionController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    @Operation(summary = "Obtiene el token para el usuario asignado que da acceso al resto de endpoints")
    public ResponseEntity<JWTTokenDTO> autenticarUsuario(@RequestBody @Valid AutenticacionUsuarioCrearDTO datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.email(), datosAutenticacionUsuario.password());
        Authentication usuarioAutenticado = authenticationManager.authenticate(authToken);
        String JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new JWTTokenDTO(JWTtoken));
    }

}
