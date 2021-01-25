package com.products.items.boot.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.products.items.boot.models.Item;
import com.products.items.boot.models.controller.feign.IProductRestClientFeign;


@Service("serviceFeign")
//@Primary
public class ItemServiceFeignImp implements ItemService {

	@Autowired
	private IProductRestClientFeign restClientFeign;

	@Override
	public List<Item> findAll() {
		return restClientFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findByid(Long id, Integer quantity) {
		return new Item(restClientFeign.getProductDetail(id), quantity);
	}

}
