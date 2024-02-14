package com.proyecto.proyecto.models;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rutinas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rutinaID;
    private String nombre;
    private String descripcion;
    @Nullable
    private Boolean completo;
    @ManyToOne
    private TipoEntrenamiento tipoEntrenamiento;

    @ManyToMany
    @JoinTable(
            name = "Rutina_Ejercicio",
            joinColumns = @JoinColumn(name = "rutinaID"),
            inverseJoinColumns = @JoinColumn(name = "ejercicioID")
    )
    private List<Ejercicios> ejercicios;
}
