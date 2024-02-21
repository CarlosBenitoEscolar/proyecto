package com.proyecto.proyecto.services;

import com.proyecto.proyecto.models.TipoEntrenamiento;

import java.util.List;

public interface TipoEntrenamientoService {

    List<TipoEntrenamiento> findAll();

    TipoEntrenamiento findById(Long id);

    TipoEntrenamiento save(TipoEntrenamiento tipoEntrenamiento);

    List<TipoEntrenamiento> findTipoEntrenamientoByNombre(String nombre);

    void deleteById(Long id);

    TipoEntrenamiento update(Long id, TipoEntrenamiento model);

}
