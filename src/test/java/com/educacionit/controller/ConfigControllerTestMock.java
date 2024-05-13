package com.educacionit.controller;

import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.educacionit.config.Configuracion;

@ExtendWith(MockitoExtension.class)
class ConfigControllerTestMock {

	@Mock
	private Configuracion mockConfig;

	@InjectMocks
	private ConfigController configController;

	@Test
	void testGetConfig() {
		when(mockConfig.getNombre1()).thenReturn("Variable1");
		when(mockConfig.getNombre2()).thenReturn("Variable2");
		when(mockConfig.getPropiedad1()).thenReturn("Propiedad1");
		when(mockConfig.getPropiedad2()).thenReturn("Propiedad2");

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(configController).build();
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/configuracion/propiedades"))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.view().name("mostrar-propiedades"))
					.andExpect(MockMvcResultMatchers.model().attribute("nombre1", "Variable1"))
					.andExpect(MockMvcResultMatchers.model().attribute("nombre2", "Variable2"))
					.andExpect(MockMvcResultMatchers.model().attribute("propiedad1", "Propiedad1"))
					.andExpect(MockMvcResultMatchers.model().attribute("propiedad2", "Propiedad2"));
		} catch (Exception e) {
			fail("Falla del Controlador", e.getMessage());
		}
	}

}
