package com.appgate.textanalysis.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.appgate.textanalysis.data.dto.TextCriteriaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("integrationtest")
class TextAnalysisControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void givenNoParameters_whenGetTextAlgorithms_thenReturnTextAlgorithms() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/textalgorithms").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void givenDistinctSubsequencesAlgorithm_whenAnalyze_thenReturnResult() throws Exception {
		TextCriteriaDTO textCriteriaDTO = new TextCriteriaDTO();
		textCriteriaDTO.setSource("this is an input sample");
		textCriteriaDTO.setTextToSearch("sam");
		ObjectMapper objectMapper = new ObjectMapper();
		String input = objectMapper.writeValueAsString(textCriteriaDTO);
		Integer expectedResult = 5;
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/textalgorithms/distinctSubsequences/analyze").contentType(MediaType.APPLICATION_JSON)
				.content(input).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.result", is(expectedResult)));
	}

	@Test
	public void givenInvalidAlgorithm_whenAnalyze_thenReturnBadRequest() throws Exception {
		TextCriteriaDTO textCriteriaDTO = new TextCriteriaDTO();
		textCriteriaDTO.setSource("this is an input sample");
		textCriteriaDTO.setTextToSearch("sam");
		ObjectMapper objectMapper = new ObjectMapper();
		String input = objectMapper.writeValueAsString(textCriteriaDTO);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/textalgorithms/invalid/analyze").contentType(MediaType.APPLICATION_JSON)
				.content(input).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	public void givenNoParameters_whenResetCache_thenReturnOK() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.patch("/api/textalgorithms/resetCache").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

}
