package com.proyecto.proyecto.services;

import com.proyecto.proyecto.dtos.RutinasResponseDto;
import com.proyecto.proyecto.models.Rutinas;

import java.util.List;

public interface RutinasService {

    List<Rutinas> findAll();

    Rutinas findById(Long id);

    Rutinas save(Rutinas rutinas);

    List<Rutinas> findRutinasByNombre(String nombre);

    void deleteById(Long id);

    Rutinas update(Long id, Rutinas model);

    Rutinas eliminarEjercicio(Long idRutina, Long idEjercicio);

    List<RutinasResponseDto> findRutinasByTipoEntrenamiento(String tipo);
}

