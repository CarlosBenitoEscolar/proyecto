package com.proyecto.proyecto.services;

import com.proyecto.proyecto.models.*;
import com.proyecto.proyecto.models.user.User;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class InitialDataCreationService {
    private final EjerciciosService ejerciciosService;
    private final MusculosService musculosService;
    private final RutinasService rutinasService;
    private final TipoEntrenamientoService tipoEntrenamientoService;
    private final UserDetailsServiceImpl userDetailsService;
    private final Faker faker = new Faker(new Locale("en-US"));

    public void createDefaultAdminUser() {
        User user = new User("user", "$2a$12$K4tojeaYWMK55KzWzDWtLOuuUjRTkycWhSGHYWA2LXMZqmZUtuXPO");
        userDetailsService.save(user);
    }

    public void createFakeMusculos(int number) {
        if (number <= 0) return;
        for (int i = 0; i < number; i++) {
            Musculos musculos = new Musculos();
            musculos.setNombre(faker.animal().name());
            musculosService.save(musculos);
        }
    }

    public void createFakeTipoEntrenamiento(int number) {
        if (number <= 0) return;
        for (int i = 0; i < number; i++) {
            TipoEntrenamiento tipoEntrenamiento = new TipoEntrenamiento();
            tipoEntrenamiento.setNombre(faker.name().name());
            tipoEntrenamiento.setDescripcion(faker.lorem().sentence());
            tipoEntrenamientoService.save(tipoEntrenamiento);
        }
    }

    public void createFakeEjercicios(int number) {
        if (number <= 0) return;
        List<Musculos> musculoList = musculosService.findAll();
        for (int i = 0; i < number; i++) {
            Ejercicios ejercicio = new Ejercicios();
            ejercicio.setNombre(faker.book().title());
            ejercicio.setDescripcion(faker.lorem().sentence());
            ejercicio.setPeso(faker.number().randomDouble(2, 1, 100));
            ejercicio.setRepeticiones(faker.number().numberBetween(1, 15));
            if (!musculoList.isEmpty()) {
                ejercicio.setMusculos(musculoList.get(faker.number().numberBetween(0, musculoList.size())));
            }
            ejerciciosService.save(ejercicio);
        }
    }

    public void createFakeRutinas(int number) {
        if (number <= 0) return;
        List<TipoEntrenamiento> tipoEntrenamientoList = tipoEntrenamientoService.findAll();
        for (int i = 0; i < number; i++) {
            Rutinas rutina = new Rutinas();
            rutina.setNombre(faker.music().genre());
            rutina.setDescripcion(faker.lorem().sentence());
            rutina.setCompleto(faker.bool().bool());
            if (!tipoEntrenamientoList.isEmpty()) {
                rutina.setTipoEntrenamiento(tipoEntrenamientoList.get(faker.number().numberBetween(0, tipoEntrenamientoList.size())));
            }
            rutinasService.save(rutina);
        }
    }
}
