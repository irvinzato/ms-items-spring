package com.rivera.app.item.service;

import java.util.List;

import com.rivera.app.item.models.Item;

public interface IServiceItem {
	
	public List<Item> encontrarTodos();
	
	public Item encontrarPorId(Long id, Integer cantidad);

}
