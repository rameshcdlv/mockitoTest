package com.test;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloWorldServiceApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLodas() throws JSONException {
		
		String response = restTemplate.getForObject("/product/all", String.class);
		System.out.println(response);
		JSONAssert.assertEquals("[{id:1},{id:2},{id:3},{id:4}]", response, false);
	}

	
	
}
