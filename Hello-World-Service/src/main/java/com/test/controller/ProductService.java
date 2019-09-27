package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;

	public Product getHardCodedProduct() {
		
		return new Product(1,"TestProduct","description");
	}
	
	public List<Product> listProducts(){
		return repo.findAll();
	}
}
