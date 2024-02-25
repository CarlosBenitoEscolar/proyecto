package com.proyecto.proyecto.services;

import com.proyecto.proyecto.models.Ejercicios;
import com.proyecto.proyecto.repositories.EjerciciosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class EjerciciosServiceImpl implements EjerciciosService {
    private final EjerciciosRepository ejerciciosRepository;

    public List<Ejercicios> findAll(){
        return ejerciciosRepository.findAll();
    }

    @Override
    public Ejercicios findById(Long id) {
        return ejerciciosRepository.findById(id).orElseThrow();
    }

    @Override
    public Ejercicios save(Ejercicios musculos) {
        return ejerciciosRepository.save(musculos);
    }

    @Override
    public List<Ejercicios> findEjerciciosByNombre(String nombre) {
        return ejerciciosRepository.findEjerciciosByNombre(nombre);
    }

    @Override
    public void deleteById(Long id) {
        ejerciciosRepository.deleteById(id);
    }

    @Override
    public Ejercicios update(Long id, Ejercicios ejercicios) {
        Ejercicios updated = this.findById(id);

        updated.setNombre(ejercicios.getNombre());


        return ejerciciosRepository.save(updated);
    }

    @Override
    public Ejercicios updatePeso(Long id, double peso) {
        Ejercicios updated = this.findById(id);

        updated.setPeso(peso);


        return ejerciciosRepository.save(updated);
    }

    @Override
    public Ejercicios updateRepeticiones(Long id, int repeticiones) {
        Ejercicios updated = this.findById(id);

        updated.setRepeticiones(repeticiones);


        return ejerciciosRepository.save(updated);
    }
    @Override
    public List<Ejercicios> findEjerciciosByNombreMusculo(String nombreMusculo) {
        return ejerciciosRepository.findByMusculosNombre(nombreMusculo);
    }





}


