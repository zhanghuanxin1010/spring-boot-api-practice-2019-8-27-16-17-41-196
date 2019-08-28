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

import com.fasterxml.jackson.databind.ObjectMapper;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
	public void shoud_return_201_when_pust() throws Exception {

		// Given
		MockHttpServletRequestBuilder input = MockMvcRequestBuilders
				.post("/employ").content("{\r\n" + "    \"id\": \"3\",\r\n" + "    \"name\": \"li\",\r\n"
						+ "    \"age\": 19,\r\n" + "    \"gender\": \"nu\"\r\n" + "}")
				.contentType(MediaType.APPLICATION_JSON);
		// When
		ResultActions result = mockMvc.perform(input);
		// Then
		result.andDo(MockMvcResultHandlers.print()).andExpect(status().isCreated());

	}

	@Test
	public void should_return_204_when_delete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/employ/2"))
				.andExpect(MockMvcResultMatchers.status().isNoContent()).andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void should_return_200_when_put() throws Exception {
		Employee employee = new Employee(1, "xiaohong", 15, "女");
		ObjectMapper objectMapper = new ObjectMapper();
		String example = objectMapper.writeValueAsString(employee);
		mockMvc.perform(
				MockMvcRequestBuilders.put("/employ").contentType(MediaType.APPLICATION_JSON_UTF8).content(example))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void should_return_200_when_get() throws Exception {

		this.mockMvc.perform(get("/employ")).andDo(print()).andExpect(status().isOk()).andReturn();

	}

}
