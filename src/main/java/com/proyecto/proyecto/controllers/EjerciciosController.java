package com.proyecto.proyecto.controllers;

import com.proyecto.proyecto.dtos.EjerciciosRequestDto;
import com.proyecto.proyecto.dtos.EjerciciosResponseDto;
import com.proyecto.proyecto.mappers.EjerciciosMapper;
import com.proyecto.proyecto.models.Ejercicios;
import com.proyecto.proyecto.services.EjerciciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicios")
@CrossOrigin(origins = "http://localhost:4200/")
@Slf4j
@RequiredArgsConstructor
public class EjerciciosController {
    private final EjerciciosService ejercicioService;
    private final EjerciciosMapper ejercicioMapper;

    @GetMapping("")
    public ResponseEntity<List<EjerciciosResponseDto>> getAllEjercicios(
            @RequestParam @Nullable String nombre
    ) {
        log.info("getAllEjercicios");
        if (nombre != null && !nombre.isEmpty()) {
            return ResponseEntity.ok(
                    ejercicioMapper.toResponse(ejercicioService.findEjerciciosByNombre(nombre))
            );
        }
        return ResponseEntity.ok(
                ejercicioMapper.toResponse(ejercicioService.findAll())
        );
    }

    @PostMapping
    public ResponseEntity<EjerciciosResponseDto> postEjercicio(
            @RequestBody EjerciciosRequestDto ejercicioRequestDto
    ) {
        log.info("addEjercicio");
        Ejercicios ejercicioSaved = ejercicioService.save(ejercicioMapper.toModel(ejercicioRequestDto));
        return ResponseEntity.created(null).body(
                ejercicioMapper.toResponse(ejercicioSaved)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EjerciciosResponseDto> putEjercicio(
            @PathVariable Long id,
            @RequestBody EjerciciosRequestDto ejercicioRequestDto
    ) {
        log.info("putEjercicio");
        Ejercicios ejercicioUpdated = ejercicioService.update(id, ejercicioMapper.toModel(ejercicioRequestDto));
        return ResponseEntity.ok(
                ejercicioMapper.toResponse(ejercicioUpdated)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEjercicio(
            @PathVariable Long id
    ) {
        log.info("deleteEjercicio");
        ejercicioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
