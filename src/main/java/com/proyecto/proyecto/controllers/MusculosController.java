package com.proyecto.proyecto.controllers;


import com.proyecto.proyecto.dtos.MusculosRequestDto;
import com.proyecto.proyecto.dtos.MusculosResponseDto;
import com.proyecto.proyecto.mappers.MusculosMapper;
import com.proyecto.proyecto.models.Musculos;
import com.proyecto.proyecto.services.MusculosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/musculos")
@CrossOrigin(origins = "http://localhost:4200/")
@Slf4j
@RequiredArgsConstructor
public class MusculosController {
    private final MusculosService musculosService;
    private final MusculosMapper musculosMapper;

    @GetMapping("")
    public ResponseEntity<List<MusculosResponseDto>> getAllMusculos(
            @RequestParam @Nullable String nombre
    ) {
        log.info("getAllMusculos");
        if (nombre != null && !nombre.isEmpty()) {
            return ResponseEntity.ok(
                    musculosMapper.toResponse(musculosService.findMusculosByNombre(nombre))
            );
        }
        return ResponseEntity.ok(
                musculosMapper.toResponse(musculosService.findAll())
        );
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<MusculosResponseDto> getMusculoById(
            @PathVariable String nombre
    ) {
        log.info("getMusculoByNombre");
        return ResponseEntity.ok(
                (MusculosResponseDto) musculosMapper.toResponse(musculosService.findMusculosByNombre(nombre))
        );
    }

    @PostMapping
    public ResponseEntity<MusculosResponseDto> postMusculo(
            @RequestBody MusculosRequestDto musculosRequestDto
    ) {
        log.info("addMusculo");
        Musculos musculosSaved = musculosService.save(musculosMapper.toModel(musculosRequestDto));
        return ResponseEntity.created(null).body(
                musculosMapper.toResponse(musculosSaved)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusculosResponseDto> putMusculo(
            @PathVariable Long id,
            @RequestBody MusculosRequestDto musculosRequestDto
    ) {
        log.info("putMusculo");
        Musculos musculosUpdated = musculosService.update(id, musculosMapper.toModel(musculosRequestDto));

        return ResponseEntity.ok(
                musculosMapper.toResponse(musculosUpdated)
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MusculosResponseDto> deleteMusculo(
            @PathVariable Long id
    ) {
        log.info("deleteMusculo");
        musculosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
