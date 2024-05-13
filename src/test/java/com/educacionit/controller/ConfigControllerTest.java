package com.educacionit.controller;

import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ConfigControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetConfig() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/configuracion/propiedades"))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.view().name("mostrar-propiedades"))
					.andExpect(MockMvcResultMatchers.model().attribute("nombre1", "Nombre config1.nombre1"))
					.andExpect(MockMvcResultMatchers.model().attribute("nombre2", "Nombre config1.nombre2"))
					.andExpect(MockMvcResultMatchers.model().attribute("propiedad1", "Nombre propiedad1"))
					.andExpect(MockMvcResultMatchers.model().attribute("propiedad2", "Nombre propiedad2"));
		} catch (Exception e) {
			fail("Falla del Controlador", e.getMessage());
		}
	}

}
