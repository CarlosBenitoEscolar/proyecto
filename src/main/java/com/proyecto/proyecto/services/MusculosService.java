package com.proyecto.proyecto.services;

import com.proyecto.proyecto.models.Musculos;

import java.util.List;

public interface MusculosService {

    List<Musculos> findAll();

    Musculos findById(Long id);

    Musculos save(Musculos musculos);

    List<Musculos> findMusculosByNombre(String nombre);

    void deleteById(Long id);

    Musculos update(Long id, Musculos model);

}
