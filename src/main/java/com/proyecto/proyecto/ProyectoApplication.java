package com.proyecto.proyecto;

import com.proyecto.proyecto.services.InitialDataCreationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		System.out.println("Starteando...");
		SpringApplication.run(ProyectoApplication.class, args);
	}
	@Bean
	public CommandLineRunner init(InitialDataCreationService service) {
		return args -> {
			service.createDefaultAdminUser();
			service.createFakeMusculos(10);
			service.createFakeRutinas(10);
			service.createFakeTipoEntrenamiento(10);
			service.createFakeEjercicios(10);


		};
	}
}