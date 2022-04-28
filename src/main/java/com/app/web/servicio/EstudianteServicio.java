package com.app.web.servicio;

import java.util.List;
import java.util.Optional;

import com.app.web.entidad.Estudiante;

public interface EstudianteServicio {
	public List<Estudiante> listarTodosLosEstudiantes();

	public Estudiante guardarEstudiante(Estudiante estudiante);

	public Estudiante modificarEstudinate(Estudiante estudiante);

	public Estudiante obtenerEstudiantePorId(Long id);

	public void eliminarEstudiante(Long id);
	public Optional<Estudiante> get(Long id);

}
