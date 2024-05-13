package com.educacionit.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.model.Alumno;
import com.educacionit.service.AlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	
	@Autowired
	@Qualifier("alumnoService")
	private AlumnoService alumnoService;

	@GetMapping("/")
	public ResponseEntity<List<Alumno>> getAllAlumnos() {
		List<Alumno> alumnos = alumnoService.getAllAlumnos();
		return new ResponseEntity<>(alumnos, HttpStatus.OK);
	}

	@GetMapping("/{legajo}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable("legajo") int legajo) {
		Alumno alumno = alumnoService.getAlumnoById(legajo);
		if (alumno == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		//Distintos niveles de Logger
		
		logger.trace("Consulta por ID del Alumno: {}. Respuesta: {} {}", legajo, alumno, 
				". Fin Log");
		logger.debug("Consulta por ID del Alumno: {}. Respuesta: {} {}", legajo, alumno, 
				". Fin Log");
		logger.info("Consulta por ID del Alumno: {}. Respuesta: {} {}", legajo, alumno, 
				". Fin Log");
		logger.info(alumno.toString());
		
		logger.warn("Se produjo un Error. ", new Exception());
		logger.error("Se produjo un Error. ", new Exception());
		
		return new ResponseEntity<>(alumno, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Void> addAlumno(@RequestBody Alumno alunmo) {
		alumnoService.addAlumno(alunmo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{legajo}")
	public ResponseEntity<Void> updateAlumno(@PathVariable("legajo") int legajo, @RequestBody Alumno alumno) {
		alumnoService.updateAlumno(legajo, alumno);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{legajo}")
	public ResponseEntity<Void> deleteAlumno(@PathVariable("legajo") int legajo) {
		alumnoService.deleteAlumno(legajo);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
