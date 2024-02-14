package com.proyecto.proyecto.dtos;

import com.proyecto.proyecto.models.Rutinas;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor

public class TipoEntrenamientoResponseDto {
    private final Long tipoEntrenamientoID;
    private final String nombre;
    private final String descripcion;
    private List<Rutinas> rutinas;

}
