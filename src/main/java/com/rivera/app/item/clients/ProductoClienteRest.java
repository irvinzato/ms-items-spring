package com.rivera.app.item.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rivera.app.item.models.Producto;

@FeignClient(name = "servicio-productos", url = "localhost:8001")
public interface ProductoClienteRest {
	
	@GetMapping("/listar-productos")
	public List<Producto> listarProductos();
	
	@GetMapping("/producto/{id}")
	public Producto encontrarProducto(@PathVariable Long id);
	
	/* V.-18
	 * Puedo utilizar balanceo de carga con "Ribbon" para desacoplar aplicación y utilizar mas el .properties
	 * Importante para añadir Ribbon:
	 * 		- La versión de spring es importante junto con "spring-cloud.version" para usar Ribbon
	 * 		- Dependencia utilizada "spring-cloud-starter-netflix-ribbon"
	 * 		- Se elimina de esta clase la "url" y se utiliza el "name" del servicio en el .properties con la lista de servidores:
	 * 			"servicio-productos.ribbon.listOfServers=localhost:8001,localhost:9001"
	 * 		- Anotacion @RibbonClient(name = "servicio-productos") en clase de arranque aplicación Spring
	 * */

}
