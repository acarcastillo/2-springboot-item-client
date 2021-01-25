package com.products.items.boot.models.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.products.items.boot.models.Item;
import com.products.items.boot.models.Product;
import com.products.items.boot.models.service.ItemService;


@RestController
public class ItemController {

	@Autowired
	//@Qualifier("serviceFeign")
	@Qualifier("serviceRestTemplate")
	private ItemService itemService;
	
	@HystrixCommand
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "alternativeMethod")
	@GetMapping("/detail/{id}/quantity/{quantity}")
	public Item getDetail(@PathVariable Long id, @PathVariable Integer quantity) {
		return itemService.findByid(id, quantity); 
	}
	
	public Item alternativeMethod(Long id, Integer quantity) {
		Item item = new Item(); 
		Product product = new Product(); 
		
		item.setQuantity(quantity);
		product.setId(id);
		product.setName("Name of ..");
		product.setProvider("provider of ...");
		product.setAmmount(500.00);
		
		item.setProduct(product);
		
		return item;
	}

}
