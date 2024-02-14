package com.proyecto.proyecto.dtos;
import com.proyecto.proyecto.models.Ejercicios;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class MusculosResponseDto {
    private final Long musculoID;
    private final String nombre;
    private List<Ejercicios> ejercicios;
}
