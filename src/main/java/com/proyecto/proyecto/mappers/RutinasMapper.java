package com.proyecto.proyecto.mappers;

import com.proyecto.proyecto.dtos.RutinasRequestDto;
import com.proyecto.proyecto.dtos.RutinasResponseDto;
import com.proyecto.proyecto.models.Rutinas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RutinasMapper {
    private final TipoEntrenamientoMapper tipoEntrenamientoMapper;
    @Autowired
    public RutinasMapper(TipoEntrenamientoMapper tipoEntrenamientoMapper){
        this.tipoEntrenamientoMapper = tipoEntrenamientoMapper;
    }
    public RutinasResponseDto toResponse(Rutinas rutinas) {
        return new RutinasResponseDto(
                rutinas.getRutinaID(),
                rutinas.getNombre(),
                rutinas.getDescripcion(),
                rutinas.getCompleto(),
                rutinas.getTipoEntrenamiento(),
                rutinas.getEjercicios()


        );
    }
    public List<RutinasResponseDto> toResponse(List<Rutinas> rutinas) {
        return rutinas.stream()
                .map(this::toResponse)
                .toList();
    }
    public Rutinas toModel(RutinasRequestDto rutinasRequestDto) {
        return new Rutinas(
                0L,
                rutinasRequestDto.getNombre(),
                rutinasRequestDto.getDescripcion(),
                rutinasRequestDto.getCompleto(),
                rutinasRequestDto.getTipoEntrenamientoID() != null ?
                        tipoEntrenamientoMapper.toModelfromRequestDto(rutinasRequestDto.getTipoEntrenamientoID()) : null,
                null
        );
    }
    public Rutinas toModelfromRequestDto(Long rutinasID) {
        return new Rutinas(
                rutinasID,
                null,
                null,
                null,
                null,
                null

        );


    }
}
