package com.tw.apistackbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.bind.annotation.PostMapping;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;






@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class ApiStackBaseApplicationTests {
@Autowired
private MockMvc mockMvc;

	@Test
	public void contextLoads() {
		
	}

	@Test
	public void shoud_return_201_when_pust() throws Exception
	{

		
			//Given
			MockHttpServletRequestBuilder input = MockMvcRequestBuilders.post("/employ").content("{\r\n" + 
					"    \"id\": \"2\",\r\n" + 
					"    \"name\": \"li\",\r\n" + 
					"    \"age\": 19,\r\n" + 
					"    \"gender\": \"nu\"\r\n" + 
					"}").contentType(MediaType.APPLICATION_JSON);
			//When
			ResultActions result = mockMvc.perform(input);
			//Then
			result
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isCreated());
		
	}
	
	
	
	
}
