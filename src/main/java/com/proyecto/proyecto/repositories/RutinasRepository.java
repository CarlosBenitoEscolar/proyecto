package com.proyecto.proyecto.repositories;


import com.proyecto.proyecto.models.Rutinas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutinasRepository extends JpaRepository<Rutinas, Long> {
    List<Rutinas> findRutinasByNombre(String Nombre);

    List<Rutinas> findByTipoEntrenamientoNombre(String tipo);
}


