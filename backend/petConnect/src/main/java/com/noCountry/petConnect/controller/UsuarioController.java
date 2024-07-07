package com.noCountry.petConnect.controller;

import com.noCountry.petConnect.model.CrearUsuarioDTO;
import com.noCountry.petConnect.model.RespuesUsuarioDTO;
import com.noCountry.petConnect.model.Usuario;
import com.noCountry.petConnect.repository.UsuarioRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRespository userRespository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid CrearUsuarioDTO datosUsuario) {

        Usuario usuario = new Usuario(datosUsuario.username(), datosUsuario.email(), datosUsuario.password());
        userRespository.save(usuario);

        RespuesUsuarioDTO respuesUsuario = new RespuesUsuarioDTO(usuario.getUsername(), usuario.getEmail());

        return ResponseEntity.ok().body(respuesUsuario);
    }
}
