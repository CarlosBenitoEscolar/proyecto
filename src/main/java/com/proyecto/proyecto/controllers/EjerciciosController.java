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

    @GetMapping("/{nombre}")
    public ResponseEntity<EjerciciosResponseDto> getEjercicioByNombre(
            @PathVariable String nombre
    ) {
        log.info("getEjercicioByNombre");
        return ResponseEntity.ok(
                (EjerciciosResponseDto) ejercicioMapper.toResponse(ejercicioService.findEjerciciosByNombre(nombre))
        );
    }
    @GetMapping("/{nombreMusculo}/buscar-por-musculo/")
    public ResponseEntity<List<EjerciciosResponseDto>> buscarEjerciciosPorMusculo(
            @RequestParam String nombreMusculo
    ) {
        log.info("buscarEjerciciosPorMusculo");
        List<Ejercicios> ejercicios = ejercicioService.findEjerciciosByNombreMusculo(nombreMusculo);
        return ResponseEntity.ok(ejercicioMapper.toResponse(ejercicios));
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
    public ResponseEntity<EjerciciosResponseDto> updatePeso(
            @PathVariable Long id,
            @RequestParam double peso
    ) {
        log.info("updatePeso");
        Ejercicios ejercicioUpdated = ejercicioService.updatePeso(id, peso);
        return ResponseEntity.ok(
                ejercicioMapper.toResponse(ejercicioUpdated)
        );
    }

    @PutMapping("/{id}/repeticiones")
    public ResponseEntity<EjerciciosResponseDto> updateRepeticiones(
            @PathVariable Long id,
            @RequestParam int repeticiones
    ) {
        log.info("updateRepeticiones");
        Ejercicios ejercicioUpdated = ejercicioService.updateRepeticiones(id, repeticiones);
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
