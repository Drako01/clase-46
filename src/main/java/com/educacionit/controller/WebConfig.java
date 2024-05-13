package com.educacionit.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/*
	 * fetch -> net::ERR_FAILED 200 (OK) 
	 * 
	 * Configuración de CORS: 
	 * Configurar CORS (Cross-Origin Resource Sharing)
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://localhost:8080") // ORIGEN
		.allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*");
	}

}
