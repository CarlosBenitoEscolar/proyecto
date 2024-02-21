package com.proyecto.proyecto.repositories;


import com.proyecto.proyecto.models.TipoEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoEntrenamientoRepository extends JpaRepository<TipoEntrenamiento, Long> {
    List<TipoEntrenamiento> findTipoEntrenamientoByNombre(String TipoEntrenamiento);
}

