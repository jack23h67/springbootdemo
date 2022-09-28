package com.example.demo.controller;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetById() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/students/{studentId}", 3)
				.header("headerName", "headerValue")
				.queryParam("graduate", "true");
		
		MvcResult mvcResult = mockMvc.perform((org.springframework.test.web.servlet.RequestBuilder) requestBuilder)
				.andDo(print())
		        .andExpect(status().is(200))
				.andExpect(jsonPath("$.id", equalTo(3)))
				.andExpect(jsonPath("$.name", notNullValue()))
				.andReturn();
		
		String body = mvcResult.getResponse().getContentAsString();
		
		System.out.println(body);
	}

	@Test
	public void testCreate() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/students")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Hank\",\"score\":14.6,\"graduate\":false}");
		
		mockMvc.perform(requestBuilder)
		       .andExpect(status().is(201)); 
	}
}
