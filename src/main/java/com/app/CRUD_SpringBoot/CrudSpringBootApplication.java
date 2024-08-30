package com.app.CRUD_SpringBoot;


import com.app.CRUD_SpringBoot.entity.Estudiante;
import com.app.CRUD_SpringBoot.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner {

	@Autowired
	private EstudianteRepository estudianteRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Agregar estudiantes de prueba
		estudianteRepository.save(new Estudiante("Diego", "BP", "diego@gmail.com"));
		estudianteRepository.save(new Estudiante("Mary", "Sol", "marysol@gmail.com"));
		estudianteRepository.save(new Estudiante("Salo", "BZ", "salo@gmail.com"));
	}
}
