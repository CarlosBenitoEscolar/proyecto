package com.proyecto.proyecto.services;

import com.proyecto.proyecto.models.Ejercicios;


import java.util.List;

public interface EjerciciosService {

    List<Ejercicios> findAll();

    Ejercicios findById(Long id);

    Ejercicios save(Ejercicios ejercicios);

    List<Ejercicios> findEjerciciosByNombre(String nombre);

    void deleteById(Long id);

    Ejercicios update(Long id, Ejercicios model);

}
