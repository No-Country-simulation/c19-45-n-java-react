package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.constants.Status;
import com.noCountry.petConnect.dto.ApiResponseDTO;
import com.noCountry.petConnect.dto.AutenticacionUsuarioCrearDTO;
import com.noCountry.petConnect.dto.AccessTokenDTO;
import com.noCountry.petConnect.infra.security.CustomUserDetails;
import com.noCountry.petConnect.infra.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Autenticacion")
@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Operation(summary = "Al autenticarse se obtiene el token para el usuario asignado que da acceso a los endpoints que asi lo requieren")
    public ResponseEntity<ApiResponseDTO> autenticarUsuario(@RequestBody @Valid AutenticacionUsuarioCrearDTO datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.email(), datosAutenticacionUsuario.password());
        Authentication usuarioAutenticado = authenticationManager.authenticate(authToken);
        CustomUserDetails customUserDetails = (CustomUserDetails) usuarioAutenticado.getPrincipal();

        String JWTtoken = tokenService.generarToken(customUserDetails.getUsuario());
        return ResponseEntity.ok(new ApiResponseDTO<>(Status.SUCCESS, "Autenticación exitosa", new AccessTokenDTO(JWTtoken)));

    }
}
