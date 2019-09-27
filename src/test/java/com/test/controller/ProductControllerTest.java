package com.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = ProductController.class)
@RunWith(SpringRunner.class)
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;
	
	@Test
	public void testProduct() throws Exception {
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.get("/product")
				.accept(MediaType.APPLICATION_JSON_VALUE);
		
		mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())
		.andExpect(content().json("{id:1,productName:TestProduct,desc:description}"))
		.andReturn();
		
	}
	
	@Test
	public void testProductFromService() throws Exception {
		
		when(productService.getHardCodedProduct()).thenReturn(new Product(1,"TestProduct","description"));
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.get("/product-from-service")
				.accept(MediaType.APPLICATION_JSON_VALUE);
		mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())
		.andExpect(content().json("{id:1,productName:TestProduct,desc:description}"))
		.andReturn();
	}
	
	@Test
	public void testListProducts() throws Exception {
		
		when(productService.listProducts()).thenReturn(Arrays.asList(
				new Product(1, "Test1", "Test1"),new Product(2, "Test2", "Test2")
				));
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/product/all")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).
		andExpect(status().isOk())
		.andExpect(content().json("[{id:1,productName:Test1,desc:Test1},{id:2,productName:Test2,desc:Test2}]")).
		andReturn();
		
	}

}
