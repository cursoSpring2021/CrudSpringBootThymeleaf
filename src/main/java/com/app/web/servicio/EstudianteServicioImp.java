package com.app.web.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Estudiante;
import com.app.web.servicio.repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicioImp implements EstudianteServicio {
	@Autowired
	private EstudianteRepositorio repositorio;

	@Override
	public List<Estudiante> listarTodosLosEstudiantes() {

		return repositorio.findAll();
	}

	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return repositorio.save(estudiante);
	}

	@Override
	public Estudiante modificarEstudinate(Estudiante estudiante) {
		// TODO Auto-generated method stub

		return repositorio.save(estudiante);
	}

	@Override
	public Estudiante obtenerEstudiantePorId(Long id) {
		// TODO Auto-generated method stub.
		return repositorio.findById(id).get();
	}

	@Override
	public void eliminarEstudiante(Long id) {
		repositorio.deleteById(id);

	}

	@Override
	public Optional<Estudiante> get(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

}
