package com.proyecto.proyecto.repositories;

import com.proyecto.proyecto.models.Ejercicios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EjerciciosRepository extends JpaRepository<Ejercicios, Long> {
    List<Ejercicios> findEjerciciosByNombre(String Nombre);
}

