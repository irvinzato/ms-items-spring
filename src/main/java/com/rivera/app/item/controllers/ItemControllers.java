package com.rivera.app.item.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import com.rivera.app.item.service.IServiceItem;
import com.rivera.app.item.models.Item;

@RestController
public class ItemControllers {
	
	//Cuando se tiene mas de un servicio implementado con la misma interface ocupa identificar cual implementara
	@Autowired
	@Qualifier("servicio-feign")	//opciones: "servicio-rest-template", "servicio-feign"
	private IServiceItem servicioItem;
	
	@GetMapping("/listar-items")
	public List<Item> listarItems(){
		return servicioItem.encontrarTodos();
	}
	
	@GetMapping("/item/{id}/cantidad/{cantidad}")
	public Item encontrarItem(@PathVariable Long id,
							  @PathVariable Integer cantidad) {
		return servicioItem.encontrarPorId(id, cantidad);
	}

}
