package com.educacionit.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.educacionit.model.Alumno;
import com.educacionit.service.AlumnoService;

@ExtendWith(MockitoExtension.class)
class AlumnoControllerTest {

	private MockMvc mockMvc;

	@Mock
	private AlumnoService alumnoService;

	@InjectMocks
	private AlumnoController alumnoController;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(alumnoController).build();
	}

	@Test
	void testGetAllAlumnos()  throws Exception {
		List<Alumno> alumnos = new ArrayList<>();
		alumnos.add(new Alumno(1, "Nombre 1", 30));
		alumnos.add(new Alumno(2, "Nombre 2", 40));

		when(alumnoService.getAllAlumnos()).thenReturn(alumnos);
		
		mockMvc.perform(get("/alumnos/")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].legajo").value(1))
				.andExpect(jsonPath("$[0].nombre").value("Nombre 1"))
				.andExpect(jsonPath("$[0].edad").value(30))
				.andExpect(jsonPath("$[1].legajo").value(2))
				.andExpect(jsonPath("$[1].nombre").value("Nombre 2"))
				.andExpect(jsonPath("$[1].edad").value(40));
		
	}

	@Test
	void testGetAlumnoById() throws Exception {
		Alumno alumno = new Alumno(1000, "Nombre", 50);
		when(alumnoService.getAlumnoById(1000)).thenReturn(alumno);

		mockMvc.perform(get("/alumnos/1000")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.legajo").value(1000))
				.andExpect(jsonPath("$.nombre").value("Nombre"))
				.andExpect(jsonPath("$.edad").value(50));
	}

	@Test
	void testGetAlumnoById_Nok() throws Exception {
		when(alumnoService.getAlumnoById(999)).thenReturn(null);
		mockMvc.perform(get("/alumnos/999"))
				.andExpect(status().isNotFound());
	}

	@Test
	void testAddAlumno() throws Exception {
		mockMvc.perform(
				post("/alumnos/")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"legajo\":1,\"nombre\":\"Juan\",\"edad\":20}")
				)
		.andExpect(status().isCreated());
		
	}

	@Test
	void testUpdateAlumno() throws Exception {
		mockMvc.perform(
				put("/alumnos/123")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"legajo\":1,\"nombre\":\"Juan\",\"edad\":20}")					
				)
		.andExpect(status().isOk());
		
	}

	@Test
	void testDeleteAlumno() throws Exception {	
		mockMvc.perform(
				delete("/alumnos/123"))
		.andExpect(status().isOk());
	}

}
