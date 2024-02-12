package com.proyecto.proyecto.dtos;

import com.proyecto.proyecto.models.Ejercicios;
import com.proyecto.proyecto.models.TipoEntrenamiento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor

public class RutinasResponseDto {
    private final int rutinaID;
    private final String nombre;
    private final String descripcion;
    private final Boolean completo;
    private TipoEntrenamiento tipoEntrenamiento;
    private List<Ejercicios> ejercicios;
}
