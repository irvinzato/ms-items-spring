package com.rivera.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	//RestTemplate es un cliente para trabajar con API-REST
	//Es un cliente HTTP para poder acceder a recursos de otros microservicios
	@Bean("clienteRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
	
}
