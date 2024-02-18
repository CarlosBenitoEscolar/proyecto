package com.proyecto.proyecto.repositories;

import com.proyecto.proyecto.models.Musculos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MusculosRepository extends JpaRepository<Musculos, Long> {
    List<Musculos> findMusculosByNombre(String Nombre);
}
