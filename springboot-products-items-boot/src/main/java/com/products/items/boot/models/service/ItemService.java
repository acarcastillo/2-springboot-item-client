package com.products.items.boot.models.service;

import java.util.List;

import com.products.items.boot.models.Item;



public interface ItemService {

	public List<Item> findAll();

	public Item findByid(Long id, Integer quantity);

}
