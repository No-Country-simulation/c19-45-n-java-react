package com.noCountry.petConnect.model;

import com.noCountry.petConnect.dto.PerfilUsuarioDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "perfil_usuario")
public class PerfilUsuario {
    @Id
    @Column(name = "usuario_id")
    private Long usuario_id ;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String nombre;

    private String foto;

    private int telefono;

    private String sexo;

    private Date fecha_nacimiento;

    private int latitud;

    private int longitud;


    public PerfilUsuario(long id, PerfilUsuarioDTO perfilUsuario) {
        this.nombre = perfilUsuario.nombre();
        this.usuario_id = id;
        this.foto = perfilUsuario.foto();
        this.telefono = perfilUsuario.telefono();
        this.sexo = perfilUsuario.sexo();
        this.fecha_nacimiento = perfilUsuario.fecha_nacimiento();
        this.latitud = perfilUsuario.latitud();
        this.longitud = perfilUsuario.longitud();
    }

        public void actualizarPerfilUsuario(PerfilUsuarioDTO perfilUsuario) {
        this.nombre = perfilUsuario.nombre();
        this.foto = perfilUsuario.foto();
        this.telefono = perfilUsuario.telefono();
        this.sexo = perfilUsuario.sexo();
        this.fecha_nacimiento = perfilUsuario.fecha_nacimiento();
        this.latitud = perfilUsuario.latitud();
        this.longitud = perfilUsuario.longitud();
    }
}
