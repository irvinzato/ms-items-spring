package com.rivera.app.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rivera.app.item.models.Item;
import com.rivera.app.item.models.Producto;

@Service
public class ServiceItemImpl implements IServiceItem {

	//Utiliza la clase "AppConfig" para poder usar RestTemplate
	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> encontrarTodos() {
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar-productos", Producto[].class));
		//Utilizo streams para poder transformar lista de productos a lista de items
		return productos.stream()
						.map(product -> new Item(product, 1))
						.collect(Collectors.toList());
	}

	@Override
	public Item encontrarPorId(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		
		Producto producto = clienteRest.getForObject("http://localhost:8001/producto/{id}", Producto.class, pathVariables);
		Item item = new Item(producto, cantidad);
		return item;
	}

}
