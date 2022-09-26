package com.appgate.textanalysis.service.algorithm.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.appgate.textanalysis.data.dto.TextAnalysisResultDTO;
import com.appgate.textanalysis.data.dto.TextCriteriaDTO;
import com.appgate.textanalysis.service.algorithm.TextAnalyzer;
import com.appgate.textanalysis.service.algorithm.TextAnalyzerFactory;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("integrationtest")
public class DistinctSubsequencesAnalyzerTest {
	
	@Autowired
	private TextAnalyzerFactory textAnalyzerFactory;
	
	@ParameterizedTest
	@CsvSource({"this is an input sample,sam,5", "rabbbit,rabit,3", "babgbag,bag,5", "ABCDE,ACE,1"})
	public void givenTextToAnalyze_whenAnalyze_thenReturnResult(String source, String textToSearch, Integer expectedResult) throws Exception {
		TextCriteriaDTO textCriteriaDTO = new TextCriteriaDTO();
		textCriteriaDTO.setSource(source);
		textCriteriaDTO.setTextToSearch(textToSearch);
		
		TextAnalyzer textAnalyzer = textAnalyzerFactory.getTextAnalyzer("distinctSubsequences");
		assertNotNull(textAnalyzer);
		textAnalyzer.analyze(textCriteriaDTO);
		
		TextAnalysisResultDTO resultDTO = textAnalyzer.analyze(textCriteriaDTO);
		assertNotNull(resultDTO);
		assertEquals(expectedResult, resultDTO.getResult());
	}

}
