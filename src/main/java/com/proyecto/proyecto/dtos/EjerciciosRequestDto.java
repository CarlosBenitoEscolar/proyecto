package com.proyecto.proyecto.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EjerciciosRequestDto {
    private final String nombre;
    private final String descripcion;
    private final Double peso;
    private final Integer repeticiones;
    private final Long MusculosID;
}
