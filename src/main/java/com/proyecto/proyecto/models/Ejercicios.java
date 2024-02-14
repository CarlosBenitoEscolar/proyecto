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
    private Long ejercicioID;
    private String nombre;
    private String descripcion;
    private Double peso;
    private Integer repeticiones;
    @ManyToOne
    private Musculos musculos;
    @OneToMany
    private List<TipoEntrenamiento> tipoEntrenamiento;
    @ManyToMany(mappedBy = "ejercicios")
    private List<Rutinas> rutinas;


}
