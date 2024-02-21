package com.proyecto.proyecto.services;

import com.proyecto.proyecto.models.Ejercicios;
import com.proyecto.proyecto.models.Rutinas;
import com.proyecto.proyecto.repositories.RutinasRepository;

import com.proyecto.proyecto.repositories.EjerciciosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class RutinasServiceImpl implements RutinasService {
    private final RutinasRepository rutinasRepository;

    public List<Rutinas> findAll(){
        return rutinasRepository.findAll();
    }

    @Override
    public Rutinas findById(Long id) {
        return rutinasRepository.findById(id).orElseThrow();
    }

    @Override
    public Rutinas save(Rutinas rutinas) {
        return rutinasRepository.save(rutinas);
    }

    @Override
    public List<Rutinas> findRutinasByNombre(String nombre) {
        return rutinasRepository.findRutinasByNombre(nombre);
    }

    @Override
    public void deleteById(Long id) {
        rutinasRepository.deleteById(id);
    }

    @Override
    public Rutinas update(Long id, Rutinas rutinas) {
        Rutinas updated = this.findById(id);

        updated.setNombre(rutinas.getNombre());


        return rutinasRepository.save(updated);
    }
}
