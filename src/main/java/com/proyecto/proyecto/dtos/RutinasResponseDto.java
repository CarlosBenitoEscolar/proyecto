package com.proyecto.proyecto.dtos;

import com.proyecto.proyecto.models.Ejercicios;
import com.proyecto.proyecto.models.TipoEntrenamiento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor

public class RutinasResponseDto {
    private Long rutinaID;
    private String nombre;
    private String descripcion;
    private Boolean completo;
    private TipoEntrenamiento tipoEntrenamiento;
    private List<Ejercicios> ejercicios;
}
