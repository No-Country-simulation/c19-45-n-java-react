package com.noCountry.petConnect.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.noCountry.petConnect.infra.errores.ListToJsonConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String raza;

    private String edad;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private String color;

    private String necesidadesEspeciales;

    private Boolean vacunado;

    private Boolean esterilizado;

    private String estado;

    @Column(name = "foto_principal_url")
    private String fotoPrincipalUrl;

    @Convert(converter = ListToJsonConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<String> fotosExtra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_propietario", nullable = false)
    @JsonBackReference
    private Usuario dueño;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especie_id", nullable = false)
    @JsonBackReference
    private Especie especie;

}
