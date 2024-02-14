package com.proyecto.proyecto.mappers;

import com.proyecto.proyecto.dtos.MusculosRequestDto;
import com.proyecto.proyecto.dtos.MusculosResponseDto;
import com.proyecto.proyecto.models.Musculos;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MusculosMapper {
    public MusculosResponseDto toResponse(Musculos musculos) {
        return new MusculosResponseDto(
                musculos.getMusculoID(),
                musculos.getNombre(),
                musculos.getEjercicios()

        );
    }
    public List<MusculosResponseDto> toResponse(List<Musculos> musculos) {
        return musculos.stream()
                .map(this::toResponse)
                .toList();
    }
    public Musculos toModel(MusculosRequestDto musculosRequestDto) {
        return new Musculos(
                0L,
                musculosRequestDto.getNombre(),
                null
        );
    }
    public Musculos toModelfromRequestDto(Long musculosID) {
        return new Musculos(
                musculosID,
                null,
                null
        );
    }
}
