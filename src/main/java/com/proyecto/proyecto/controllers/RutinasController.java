package com.proyecto.proyecto.controllers;

import com.proyecto.proyecto.dtos.RutinasRequestDto;
import com.proyecto.proyecto.dtos.RutinasResponseDto;
import com.proyecto.proyecto.mappers.RutinasMapper;
import com.proyecto.proyecto.models.Rutinas;
import com.proyecto.proyecto.services.RutinasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutinas")
@CrossOrigin(origins = "http://localhost:4200/")
@Slf4j
@RequiredArgsConstructor
public class RutinasController {
    private final RutinasService rutinasService;
    private final RutinasMapper rutinasMapper;

    @GetMapping("")
    public ResponseEntity<List<RutinasResponseDto>> getAllRutinas(
            @RequestParam @Nullable String nombre
    ) {
        log.info("getAllRutinas");
        if (nombre != null && !nombre.isEmpty()) {
            return ResponseEntity.ok(
                    rutinasMapper.toResponse(rutinasService.findRutinasByNombre(nombre))
            );
        }
        return ResponseEntity.ok(
                rutinasMapper.toResponse(rutinasService.findAll())
        );
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<RutinasResponseDto> getRutinaById(
            @PathVariable String nombre
    ) {
        log.info("getRutinaByNombre");
        return ResponseEntity.ok(
                (RutinasResponseDto) rutinasMapper.toResponse(rutinasService.findRutinasByNombre(nombre))
        );
    }

    @GetMapping("/tipo-entrenamiento/{tipo}")
    public ResponseEntity<List<RutinasResponseDto>> getRutinasByTipoEntrenamiento(@PathVariable String tipo) {
        List<RutinasResponseDto> rutinas = rutinasService.findRutinasByTipoEntrenamiento(tipo);
        return ResponseEntity.ok(rutinas);
    }


    @PostMapping
    public ResponseEntity<RutinasResponseDto> postRutina(
            @RequestBody RutinasRequestDto rutinasRequestDto
    ) {
        log.info("addRutina");
        Rutinas rutinaSaved = rutinasService.save(rutinasMapper.toModel(rutinasRequestDto));
        return ResponseEntity.created(null).body(
                rutinasMapper.toResponse(rutinaSaved)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutinasResponseDto> putRutina(
            @PathVariable Long id,
            @RequestBody RutinasRequestDto rutinasRequestDto
    ) {
        log.info("putRutina");
        Rutinas rutinaUpdated = rutinasService.update(id, rutinasMapper.toModel(rutinasRequestDto));

        return ResponseEntity.ok(
                rutinasMapper.toResponse(rutinaUpdated)
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RutinasResponseDto> deleteRutina(
            @PathVariable Long id
    ) {
        log.info("deleteRutina");
        rutinasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idRutina}/ejercicios/{idEjercicio}")
    public ResponseEntity<RutinasResponseDto> eliminarEjercicio(
            @PathVariable Long idRutina,
            @PathVariable Long idEjercicio
    ) {
        log.info("eliminarEjercicio");
        Rutinas rutina = rutinasService.eliminarEjercicio(idRutina, idEjercicio);
        return ResponseEntity.ok(rutinasMapper.toResponse(rutina));
    }
}
