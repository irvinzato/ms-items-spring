package com.rivera.app.item.service;

import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivera.app.item.clients.ProductoClienteRest;
import com.rivera.app.item.models.Item;

@Service("servicio-feign")
public class ServiceItemFeignImp implements IServiceItem{
	
	@Autowired
	private ProductoClienteRest clienteFeign;
	
	@Override
	public List<Item> encontrarTodos(){
		return clienteFeign.listarProductos().stream()
				.map(product -> new Item(product, 2))
				.collect(Collectors.toList());
	}

	@Override
	public Item encontrarPorId(Long id, Integer cantidad) {
		return new Item(clienteFeign.encontrarProducto(id), cantidad);
	}

}
