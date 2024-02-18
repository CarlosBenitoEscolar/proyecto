package com.proyecto.proyecto.services;

import com.proyecto.proyecto.models.Musculos;
import com.proyecto.proyecto.repositories.MusculosRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class MusculosServiceImpl implements MusculosService {
    private final MusculosRepository musculosRepository;

    public List<Musculos> findAll(){
        return musculosRepository.findAll();
    }

    @Override
    public Musculos findById(Long id) {
        return musculosRepository.findById(id).orElseThrow();
    }

    @Override
    public Musculos save(Musculos musculos) {
        return musculosRepository.save(musculos);
    }

    @Override
    public List<Musculos> findMusculosByNombre(String nombre) {
        return musculosRepository.findMusculosByNombre(nombre);
    }

    @Override
    public void deleteById(Long id) {
        musculosRepository.deleteById(id);
    }

    @Override
    public Musculos update(Long id, Musculos musculos) {
        Musculos updated = this.findById(id);

        updated.setNombre(musculos.getNombre());


        return musculosRepository.save(updated);
    }




}
