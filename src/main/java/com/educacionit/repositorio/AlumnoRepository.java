package com.educacionit.repositorio;

import java.util.List;

import com.educacionit.model.Alumno;

public interface AlumnoRepository {
	
	List<Alumno> findAll();

	Alumno findById(int legajo);

	void save(Alumno alumno);

	void delete(int legajo);
}
