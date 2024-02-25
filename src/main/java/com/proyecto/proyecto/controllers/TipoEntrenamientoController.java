package com.proyecto.proyecto.controllers;

import com.proyecto.proyecto.dtos.TipoEntrenamientoRequestDto;
import com.proyecto.proyecto.dtos.TipoEntrenamientoResponseDto;
import com.proyecto.proyecto.mappers.TipoEntrenamientoMapper;
import com.proyecto.proyecto.models.TipoEntrenamiento;
import com.proyecto.proyecto.services.TipoEntrenamientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tipo-entrenamiento")
@CrossOrigin(origins = "http://localhost:4200/")
@Slf4j
@RequiredArgsConstructor
public class TipoEntrenamientoController {
    private final TipoEntrenamientoService tipoEntrenamientoService;
    private final TipoEntrenamientoMapper tipoEntrenamientoMapper;

    @GetMapping("")
    public ResponseEntity<List<TipoEntrenamientoResponseDto>> getAllTipoEntrenamiento(
            @RequestParam @Nullable String nombre
    ) {
        log.info("getAllTipoEntrenamiento");
        if (nombre != null && !nombre.isEmpty()) {
            return ResponseEntity.ok(
                    tipoEntrenamientoMapper.toResponse(tipoEntrenamientoService.findTipoEntrenamientoByNombre(nombre))
            );
        }
        return ResponseEntity.ok(
                tipoEntrenamientoMapper.toResponse(tipoEntrenamientoService.findAll())
        );
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<TipoEntrenamientoResponseDto> getTipoEntrenamientoByNombre(
            @PathVariable String nombre
    ) {
        log.info("getTipoEntrenamientoByNombre");
        return ResponseEntity.ok(
                (TipoEntrenamientoResponseDto) tipoEntrenamientoMapper.toResponse(tipoEntrenamientoService.findTipoEntrenamientoByNombre(nombre))
        );
    }

    @PostMapping
    public ResponseEntity<TipoEntrenamientoResponseDto> postTipoEntrenamiento(
            @RequestBody TipoEntrenamientoRequestDto tipoEntrenamientoRequestDto
    ) {
        log.info("addTipoEntrenamiento");
        TipoEntrenamiento tipoEntrenamientoSaved = tipoEntrenamientoService.save(tipoEntrenamientoMapper.toModel(tipoEntrenamientoRequestDto));
        return ResponseEntity.created(null).body(
                tipoEntrenamientoMapper.toResponse(tipoEntrenamientoSaved)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoEntrenamientoResponseDto> putTipoEntrenamiento(
            @PathVariable Long id,
            @RequestBody TipoEntrenamientoRequestDto tipoEntrenamientoRequestDto
    ) {
        log.info("putTipoEntrenamiento");
        TipoEntrenamiento tipoEntrenamientoUpdated = tipoEntrenamientoService.update(id, tipoEntrenamientoMapper.toModel(tipoEntrenamientoRequestDto));

        return ResponseEntity.ok(
                tipoEntrenamientoMapper.toResponse(tipoEntrenamientoUpdated)
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoEntrenamientoResponseDto> deleteTipoEntrenamiento(
            @PathVariable Long id
    ) {
        log.info("deleteTipoEntrenamiento");
        tipoEntrenamientoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

