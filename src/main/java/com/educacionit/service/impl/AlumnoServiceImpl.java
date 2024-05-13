package com.educacionit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.educacionit.model.Alumno;
import com.educacionit.repositorio.AlumnoRepository;
import com.educacionit.service.AlumnoService;

@Service("alumnoService")
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	@Qualifier("alumnoRepository")
	private AlumnoRepository alumnoRepository;

	@Override
	public List<Alumno> getAllAlumnos() {

		return alumnoRepository.findAll();
	}

	@Override
	public Alumno getAlumnoById(int legajo) {

		return alumnoRepository.findById(legajo);
	}

	@Override
	public void addAlumno(Alumno alumno) {
		alumnoRepository.save(alumno);
	}

	@Override
	public void updateAlumno(int legajo, Alumno alumno) {
		Alumno existeAlumno = alumnoRepository.findById(legajo);
		if (existeAlumno != null) {
			existeAlumno.setNombre(alumno.getNombre());
			existeAlumno.setEdad(alumno.getEdad());
			alumnoRepository.save(alumno);
		}
	}

	@Override
	public void deleteAlumno(int legajo) {
		alumnoRepository.delete(legajo);

	}

}
