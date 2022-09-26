package com.appgate.textanalysis.service.algorithm;

import com.appgate.textanalysis.data.dto.TextAnalysisResultDTO;
import com.appgate.textanalysis.data.dto.TextCriteriaDTO;

/**
 * Definition of a text analyzer.
 * @author Fabio Berrio
 */
public interface TextAnalyzer {

	/**
	 * Analyze a text and return a result.
	 * @param textCriteriaDTO
	 * @return
	 */
	TextAnalysisResultDTO analyze(TextCriteriaDTO textCriteriaDTO);
	
}
