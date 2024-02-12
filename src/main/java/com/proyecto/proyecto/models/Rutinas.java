package com.proyecto.proyecto.models;
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
    private int rutinaID;
    private String nombre;
    private String descripcion;
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
