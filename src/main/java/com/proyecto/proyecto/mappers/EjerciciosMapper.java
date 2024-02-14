package com.proyecto.proyecto.mappers;

import com.proyecto.proyecto.dtos.EjerciciosRequestDto;
import com.proyecto.proyecto.dtos.EjerciciosResponseDto;
import com.proyecto.proyecto.models.Ejercicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class EjerciciosMapper {
    private final MusculosMapper musculosMapper;
    @Autowired
    public EjerciciosMapper(MusculosMapper musculosMapper){
        this.musculosMapper = musculosMapper;
    }
    public EjerciciosResponseDto toResponse(Ejercicios ejercicios) {
        return new EjerciciosResponseDto(
                ejercicios.getEjercicioID(),
                ejercicios.getNombre(),
                ejercicios.getDescripcion(),
                ejercicios.getPeso(),
                ejercicios.getRepeticiones(),
                ejercicios.getMusculos(),
                ejercicios.getTipoEntrenamiento(),
                ejercicios.getRutinas()


        );
    }
    public List<EjerciciosResponseDto> toResponse(List<Ejercicios> ejercicios) {
        return ejercicios.stream()
                .map(this::toResponse)
                .toList();
    }
    public Ejercicios toModel(EjerciciosRequestDto ejerciciosRequestDto) {
        return new Ejercicios(
                0L,
                ejerciciosRequestDto.getNombre(),
                ejerciciosRequestDto.getDescripcion(),
                ejerciciosRequestDto.getPeso(),
                ejerciciosRequestDto.getRepeticiones(),
                ejerciciosRequestDto.getMusculosID() != null ?
                        musculosMapper.toModelfromRequestDto(ejerciciosRequestDto.getMusculosID()) : null,
                null,
                null
        );
    }
    public Ejercicios toModelfromRequestDto(Long ejerciciosID) {
        return new Ejercicios(
                ejerciciosID,
                null,
                null,
                null,
                null,
                null,
                null,
                null

        );
    }
}
