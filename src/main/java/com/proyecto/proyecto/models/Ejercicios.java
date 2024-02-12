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

public class Ejercicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ejercicioID;
    private String nombre;
    private String descripcion;
    private double peso;
    private int repeticiones;
    @ManyToOne
    private Musculos musculos;
    @OneToMany
    private List<TipoEntrenamiento> tipoEntrenamiento;
    @ManyToMany(mappedBy = "ejercicios")
    private List<Rutinas> rutinas;


}
