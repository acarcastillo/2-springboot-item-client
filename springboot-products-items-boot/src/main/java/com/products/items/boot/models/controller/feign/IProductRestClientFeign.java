package com.products.items.boot.models.controller.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.products.items.boot.models.Product;


@FeignClient(name="products-service")
//@FeignClient(name="products-service", url ="localhost:8001")
public interface IProductRestClientFeign {
	
	@GetMapping("/listar")
	public List<Product> listar();

	@GetMapping("/detail/{id}")
	public Product getProductDetail(@PathVariable Long id) ;
}
