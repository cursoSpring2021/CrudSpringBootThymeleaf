package com.app.web.controlador;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Estudiante;
import com.app.web.servicio.EstudianteServicio;

@Controller

public class EstudianteControlador {
	private final Logger LOGGER = LoggerFactory.getLogger(EstudianteControlador.class);

	@Autowired
	private EstudianteServicio servicio;

	@GetMapping({ "/estudiantes", "/" })
	public String mostrarTodosLosEmpleados(Model modelo) {
		modelo.addAttribute("estudiantes", servicio.listarTodosLosEstudiantes());

		return "estudiantes";
	}

	@GetMapping("/estudiantes/nuevo")
	public String formularioEstudiante(Model modelo) {
		Estudiante estudiante = new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		return "crear_estudiante";
	}

	@PostMapping("/estudiantes")
	public String guardarEstudiante(Model modelo, Estudiante estudiante) {
		modelo.addAttribute("estudiante", estudiante);
		servicio.guardarEstudiante(estudiante);
		return "redirect:/estudiantes";

	}

	@GetMapping("/estudiantes/edit/{id}")
	public String editarEstudiante(@PathVariable Long id, Model modelo) {
		Estudiante estudiante = new Estudiante();
		Optional<Estudiante> optionalEstudiante = servicio.get(id);
		estudiante = optionalEstudiante.get();

		LOGGER.info("Estudiante Modificado: {}", estudiante);
		modelo.addAttribute("estudiante", estudiante);

		return "edit_estudiante";

	}

	@PostMapping("/estudiantes/{id}")

	public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante) {
		Estudiante e = new Estudiante();
		e = servicio.get(id).get();
		e.setId(id);
		e.setNombre(estudiante.getNombre());
		e.setApellido(estudiante.getApellido());
		e.setEmail(estudiante.getEmail());
		//LOGGER.info("Estudiante *********: {}", e);

		servicio.modificarEstudinate(e);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/{id}")
	public String eliminarEstudiantes(@PathVariable Long id) {

		servicio.eliminarEstudiante(id);
		return "redirect:/estudiantes";

	}

}
