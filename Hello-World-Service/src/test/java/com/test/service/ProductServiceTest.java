package com.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.test.controller.Product;
import com.test.controller.ProductRepo;
import com.test.controller.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService service;
	
	@Mock
	private ProductRepo repo;
	
	
	@Test
	public void testRetreiveAll() {
		
		when(repo.findAll()).thenReturn(Arrays.asList(
				new Product(1, "Test1", "Test1"),new Product(2, "Test2", "Test2")
				));
		
		List<Product> products=service.listProducts();
		assertEquals("Test1", products.get(0).getProductName());
		assertEquals("Test2", products.get(1).getProductName());
		
	}
}
