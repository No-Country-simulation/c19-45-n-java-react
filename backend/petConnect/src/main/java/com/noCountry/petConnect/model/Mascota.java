package com.noCountry.petConnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String especie;

    private String raza;

    private String edad;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private String color;

    private String necesidadesEspeciales;

    private Boolean vacunado;

    private Boolean esterilizado;

    @Lob
    private byte[] foto;

    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_propietario")
    private Usuario dueño;

}
