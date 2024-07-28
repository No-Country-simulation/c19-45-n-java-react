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

    private String telefono;

    private String sexo;

    private String descripcion;

    private Date fecha_nacimiento;

    private int latitud;

    private int longitud;


    public PerfilUsuario(long id, PerfilUsuarioDTO perfilUsuario) {
        this.nombre = perfilUsuario.nombre();
        this.usuario_id = id;
        this.foto = perfilUsuario.foto();
        this.telefono = perfilUsuario.telefono();
        this.sexo = perfilUsuario.sexo();
        this.descripcion = perfilUsuario.descripcion();
        this.fecha_nacimiento = perfilUsuario.fecha_nacimiento();
        this.latitud = perfilUsuario.latitud();
        this.longitud = perfilUsuario.longitud();
    }

    public PerfilUsuario(Usuario usuario, String nombre, String foto, String telefono, String sexo, String descripcion, Date fecha_nacimiento) {
        this.usuario = usuario;
        this.usuario_id = usuario.getId();
        this.nombre = nombre;
        this.foto = foto;
        this.telefono = telefono;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public void actualizarPerfilUsuario(PerfilUsuarioDTO perfilUsuario) {
        this.nombre = perfilUsuario.nombre();
        this.foto = perfilUsuario.foto();
        this.telefono = perfilUsuario.telefono();
        this.sexo = perfilUsuario.sexo();
        this.descripcion = perfilUsuario.descripcion();
        this.fecha_nacimiento = perfilUsuario.fecha_nacimiento();
        this.latitud = perfilUsuario.latitud();
        this.longitud = perfilUsuario.longitud();
    }
}
