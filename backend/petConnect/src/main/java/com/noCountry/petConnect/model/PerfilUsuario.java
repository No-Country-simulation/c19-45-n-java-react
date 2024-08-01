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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Nueva clave primaria

    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true) // Establece la relación con Usuario
    private Usuario usuario;

    private String nombre;

    private String foto;

    private String telefono;

    private String sexo;

    private String descripcion;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    private int latitud;

    private int longitud;

    // Constructor con todos los parámetros
    public PerfilUsuario(Usuario usuario, String nombre, String foto, String telefono, String sexo, String descripcion, Date fechaNacimiento, int latitud, int longitud) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.foto = foto;
        this.telefono = telefono;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.fechaNacimiento = fechaNacimiento;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // Método para actualizar el perfil de usuario
    public void actualizarPerfilUsuario(PerfilUsuarioDTO perfilUsuario) {
        this.nombre = perfilUsuario.nombre();
        this.foto = perfilUsuario.foto();
        this.telefono = perfilUsuario.telefono();
        this.sexo = perfilUsuario.sexo();
        this.descripcion = perfilUsuario.descripcion();
        this.fechaNacimiento = perfilUsuario.fecha_nacimiento();
        this.latitud = perfilUsuario.latitud();
        this.longitud = perfilUsuario.longitud();
    }
}
