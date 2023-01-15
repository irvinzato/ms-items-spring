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

}
