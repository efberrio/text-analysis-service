package com.appgate.textanalysis.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.appgate.textanalysis.data.dto.TextAnalysisResultDTO;
import com.appgate.textanalysis.data.dto.TextCriteriaDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class TextAnalysisServiceTest {

	@Autowired
	private TextAnalysisService textAnalysisService;
	
	
	@ParameterizedTest
	@CsvSource({"this is an input sample,sam,5", "rabbbit,rabit,3", "babgbag,bag,5", "ABCDE,ACE,1"})
	public void givenDistinctSubsequencesAlgorithm_whenAnalyze_thenReturnResult(String source, String textToSearch, Integer expectedResult) throws Exception {
		TextCriteriaDTO textCriteriaDTO = new TextCriteriaDTO();
		textCriteriaDTO.setSource(source);
		textCriteriaDTO.setTextToSearch(textToSearch);
		
		TextAnalysisResultDTO resultDTO = textAnalysisService.analyzeText("distinctSubsequences", textCriteriaDTO);
		assertNotNull(resultDTO);
		assertEquals(expectedResult, resultDTO.getResult());
	}

}
