package com.proyecto.proyecto.services;

import com.proyecto.proyecto.models.TipoEntrenamiento;
import com.proyecto.proyecto.repositories.TipoEntrenamientoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class TipoEntrenamientoServiceImpl implements TipoEntrenamientoService{
    private final TipoEntrenamientoRepository tipoEntrenamientoRepository;

    public List<TipoEntrenamiento> findAll(){
        return tipoEntrenamientoRepository.findAll();
    }

    @Override
    public TipoEntrenamiento findById(Long id) {
        return tipoEntrenamientoRepository.findById(id).orElseThrow();
    }

    @Override
    public TipoEntrenamiento save(TipoEntrenamiento tipoEntrenamiento) {
        return tipoEntrenamientoRepository.save(tipoEntrenamiento);
    }

    @Override
    public List<TipoEntrenamiento> findTipoEntrenamientoByNombre(String nombre) {
        return tipoEntrenamientoRepository.findTipoEntrenamientoByNombre(nombre);
    }

    @Override
    public void deleteById(Long id) {
        tipoEntrenamientoRepository.deleteById(id);
    }

    @Override
    public TipoEntrenamiento update(Long id, TipoEntrenamiento tipoEntrenamiento) {
        TipoEntrenamiento updated = this.findById(id);

        updated.setNombre(tipoEntrenamiento.getNombre());


        return tipoEntrenamientoRepository.save(updated);
    }

}
