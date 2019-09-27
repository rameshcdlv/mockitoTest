package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	@GetMapping("/product")
	public Product getProduct() {
		
		return new Product(1,"TestProduct","description");
	}
	
	@GetMapping("/product-from-service")
	public Product getProductFromService() {
		return productService.getHardCodedProduct();
	}
	
	@GetMapping("/product/all")
	public List<Product> listAllProducts(){
		
		return productService.listProducts();
	}
}
