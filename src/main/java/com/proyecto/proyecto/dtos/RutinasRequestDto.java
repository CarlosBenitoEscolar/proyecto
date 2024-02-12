package com.proyecto.proyecto.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RutinasRequestDto {
    private final String nombre;
    private final String descripcion;
    private final Double completo;
}
