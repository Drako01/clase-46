package com.educacionit.service;

import java.util.List;

import com.educacionit.model.Alumno;


public interface AlumnoService {

	List<Alumno> getAllAlumnos();
	Alumno getAlumnoById(int legajo);
	void addAlumno(Alumno alumno);
	void updateAlumno(int legajo, Alumno alumno);
	void deleteAlumno(int legajo);
	
	
}
