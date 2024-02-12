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

public class TipoEntrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoEntrenamientoID;
    private String nombre;
    private String descripcion;
    @OneToMany
    private List<Rutinas> rutinas;


}
