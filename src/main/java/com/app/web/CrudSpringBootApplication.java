package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.servicio.repositorio.EstudianteRepositorio;

@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootApplication.class, args);
	}

	@Autowired
	private EstudianteRepositorio repositorio;
	
	@Override
	public void run(String... args) throws Exception {
		/*Estudiante e1 = new Estudiante( "Davis", "Guerra", "dg@gmail.com");
		repositorio.save(e1);*/
		
	}

}
