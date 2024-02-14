package com.proyecto.proyecto.dtos;

import com.proyecto.proyecto.models.Musculos;
import com.proyecto.proyecto.models.Rutinas;
import com.proyecto.proyecto.models.TipoEntrenamiento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class EjerciciosResponseDto {
    private final Long ejercicioID;
    private final String nombre;
    private final String descripcion;
    private final Double peso;
    private final Integer repeticiones;
    private Musculos musculos;
    private List<TipoEntrenamiento> tipoEntrenamiento;
    private List<Rutinas> rutinas;

}
