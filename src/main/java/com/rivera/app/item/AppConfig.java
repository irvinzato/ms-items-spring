package com.rivera.app.item;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	//RestTemplate es un cliente para trabajar con API-REST
	//Es un cliente HTTP para poder acceder a recursos de otros microservicios
	@Bean("clienteRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
	
	/*V.-20
	 * Puedo implementar balanceo de cargas con RestTemplate utilizando la anotación @LoadBalanced
	 * Y desacoplar, en su servicio implementado en lugar de indicar la ruta, utilizar las variables del properties.
	 * Utiliza libreria Ribbon para poder funcionar(Importante la version de Spring y cloud)
	 * */
	
	
	/*
	 * Hay mas maneras de realizar comunicación con otros microservicios, por ejemplo:
	 * Usando API Feign V17 - Tengo ambas maneras implementandas en proyecto. Con Qualifier o Primary indicando al controlador que servicio utilizar
	 * Componentes necesarias para implementar FEIGN:
	 * 		- Añadir libreria en POM "feign"
	 * 		- En arranque de aplicacion "MicroservicioItemApplication" utilizar anotacion "@EnableFeignClients"
	 * 		- Crear interface que contiene configuracion del microservicio a consumir "ProductoClienteRest"
	 * 		- Implementar Servicio "ServiceItemFeignImp" con inyeccion de interface anteriormente creada 
	 * 		- Utilizar mediante controlador 
	 * */
	
}
