package com.educacionit.repositorio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.educacionit.model.Alumno;
import com.educacionit.repositorio.AlumnoRepository;

@Repository("alumnoRepository")
public class AlumnoRepositoryImpl implements AlumnoRepository {

	private List<Alumno> alumnos = new ArrayList<>();

	@Override
	public List<Alumno> findAll() {
		return alumnos;
	}

	@Override
	public Alumno findById(int legajo) {
		return alumnos.stream()
				.filter(a -> a.getLegajo() == legajo)
				.findFirst().orElse(null);
	}

	@Override
	public void save(Alumno alumno) {
		alumnos.add(alumno);
	}

	@Override
	public void delete(int legajo) {
		alumnos.removeIf(a -> a.getLegajo() == legajo);
	}

}
