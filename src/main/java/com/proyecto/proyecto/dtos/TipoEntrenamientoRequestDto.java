package com.proyecto.proyecto.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class TipoEntrenamientoRequestDto {
    private final String nombre;
    private final String descripcion;
}
