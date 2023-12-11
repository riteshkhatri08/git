package com.beta.replyservice.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) // Disable security filters
public class ReplyControllerV2Test {
	private static final String REPLY_V2_URL = "/v2/reply/";
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
		assertNotNull(mockMvc);
	}

	@Test
	public void replyingTest_validRequest() throws Exception {
		String rule = "11-";
		String input = "Ritesh";
		String output = "{ \"data\" : \"Ritesh\"}";

		this.mockMvc
		.perform(get(REPLY_V2_URL + rule + input))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(content().json(output));

	}
	
	@Test
	public void replyingTest_invalidRequestRule() throws Exception {
		String rule = "33-";
		String input = "Ritesh";
		String output = "{ \"message\" : \"Invalid input\"}";

		this.mockMvc
		.perform(get(REPLY_V2_URL + rule + "-" + input))
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(content().json(output));

	}
	
	@Test
	public void replyingTest_invalidRequestFormat() throws Exception {
		String rule = "-";
		String input = "Ritesh";
		String output = "{ \"message\" : \"Invalid input\"}";

		this.mockMvc
		.perform(get(REPLY_V2_URL + rule + input))
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(content().json(output));

	}

	@Test
	public void replyingTest_invalidRequestMessage() throws Exception {
		String rule = "11-";
		String input = "";
		String output = "{ \"message\" : \"Invalid input\"}";

		this.mockMvc
		.perform(get(REPLY_V2_URL + rule + input))
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(content().json(output));

	}
	
	

}
