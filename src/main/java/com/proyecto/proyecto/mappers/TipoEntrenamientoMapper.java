package com.proyecto.proyecto.mappers;

import com.proyecto.proyecto.dtos.TipoEntrenamientoRequestDto;
import com.proyecto.proyecto.dtos.TipoEntrenamientoResponseDto;
import com.proyecto.proyecto.models.TipoEntrenamiento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class TipoEntrenamientoMapper {
    public TipoEntrenamientoResponseDto toResponse(TipoEntrenamiento tipoEntrenamiento) {
        return new TipoEntrenamientoResponseDto(
                tipoEntrenamiento.getTipoEntrenamientoID(),
                tipoEntrenamiento.getNombre(),
                tipoEntrenamiento.getDescripcion(),
                tipoEntrenamiento.getRutinas()

        );
    }
    public List<TipoEntrenamientoResponseDto> toResponse(List<TipoEntrenamiento> tipoEntrenamientos) {
        return tipoEntrenamientos.stream()
                .map(this::toResponse)
                .toList();
    }
    public TipoEntrenamiento toModel(TipoEntrenamientoRequestDto tipoEntrenamientosRequestDto) {
        return new TipoEntrenamiento(
                0L,
                tipoEntrenamientosRequestDto.getNombre(),
                tipoEntrenamientosRequestDto.getDescripcion(),
                null
        );
    }
    public TipoEntrenamiento toModelfromRequestDto(Long tipoEntrenamientoID) {
        return new TipoEntrenamiento(
                tipoEntrenamientoID,
                null,
                null,
                null
        );
    }

}
