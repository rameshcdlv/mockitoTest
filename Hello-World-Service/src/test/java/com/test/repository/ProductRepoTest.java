package com.test.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.controller.Product;
import com.test.controller.ProductRepo;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ProductRepoTest {
	
	@Autowired
	private ProductRepo repo;
	
	@Test
	public void testFindAll() {
		
		List<Product> findAll = repo.findAll();
		assertEquals(4, findAll.size());
	}

}
