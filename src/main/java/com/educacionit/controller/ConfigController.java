package com.educacionit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educacionit.config.Configuracion;

@Controller
@RequestMapping("/configuracion")
public class ConfigController {

	@Autowired
	private Configuracion appConfig;
	
	@GetMapping("/propiedades")
	public String getConfig(Model model) {
		
		model.addAttribute("nombre1", appConfig.getNombre1());
		model.addAttribute("nombre2", appConfig.getNombre2());
		model.addAttribute("propiedad1", appConfig.getPropiedad1());
		model.addAttribute("propiedad2", appConfig.getPropiedad2());
		
		
		return "mostrar-propiedades";
	}
}
