package com.proyecto.proyecto.dtos;
import com.proyecto.proyecto.models.Ejercicios;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class MusculosResponseDto {
    private final int id;
    private final String name;
    private List<Ejercicios> ejercicios;
}
