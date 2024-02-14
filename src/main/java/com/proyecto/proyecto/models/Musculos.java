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

public class Musculos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musculoID;
    private String nombre;
    @OneToMany
    private List<Ejercicios> ejercicios;

}
