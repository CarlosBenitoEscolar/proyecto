package com.proyecto.proyecto.services;


import com.proyecto.proyecto.models.Musculos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InitialDataCreationService {
//    private final EjerciciosService ejerciciosService;
    private final MusculosService musculosService;
//    private final RutinasService rutinasService;
//    private final TipoEntrenamientoService tipoEntrenamientoService;

    public void createFakeMusculos(int number) {
        if (number <= 0) return;
        for (int i = 0; i < number; i++) {
            Musculos musculos = new Musculos();
            musculos.setNombre("Musculo " + i);
            musculosService.save(musculos);
        }
    }

 /*   public void createFakeTipoEntrenamiento(int number) {
        if (number <= 0) return;
        for (int i = 0; i < number; i++) {
            TipoEntrenamiento tipoEntrenamiento = new TipoEntrenamiento();
            tipoEntrenamiento.setNombre("TipoEntrenamiento " + i);
            tipoEntrenamiento.setDescripcion("Descripción del tipo de entrenamiento " + i);

            tipoEntrenamientoService.save(tipoEntrenamiento);
        }
    }

    public void createFakeEjercicios(int number) {
        if (number <= 0) return;
        List<Musculos> musculosList = musculosService.findAll();
        List<TipoEntrenamiento> tipoEntrenamientoList = tipoEntrenamientoService.findAll();

        for (int i = 0; i < number; i++) {
            Ejercicios ejercicio = new Ejercicios();
            ejercicio.setNombre("Ejercicio " + i);
            ejercicio.setDescripcion("Descripción del ejercicio " + i);
            ejercicio.setPeso(Math.random() * 50); // Ejemplo de asignación de peso aleatorio
            ejercicio.setRepeticiones((int) (Math.random() * 20)); // Ejemplo de asignación de repeticiones aleatorias

            int musculoIndex = (int) (Math.random() * musculosList.size());
            ejercicio.setMusculos(musculosList.get(musculoIndex));

            int tipoEntrenamientoIndex = (int) (Math.random() * tipoEntrenamientoList.size());
            ejercicio.setTipoEntrenamiento(tipoEntrenamientoList.get(tipoEntrenamientoIndex));

            ejerciciosService.save(ejercicio);
        }
    }

    public void createFakeRutinas(int number) {
        if (number <= 0) return;
        List<Ejercicios> ejerciciosList = ejerciciosService.findAll();

        for (int i = 0; i < number; i++) {
            Rutinas rutina = new Rutinas();
            rutina.setNombre("Rutina " + i);
            rutina.setDescripcion("Descripción de la rutina " + i);
            rutina.setCompleto(Math.random() < 0.5); // Ejemplo de asignación aleatoria de booleano

            for (int j = 0; j < Math.random() * 5; j++) {
                int ejercicioIndex = (int) (Math.random() * ejerciciosList.size());
                rutina.getEjercicios().add(ejerciciosList.get(ejercicioIndex));
            }

            rutinasService.save(rutina);
        }
    }*/
}
