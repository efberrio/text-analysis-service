package com.appgate.textanalysis.service.algorithm;

import com.appgate.textanalysis.data.dto.TextCriteriaDTO;

public interface TextAnalyzer {

	int analyze(TextCriteriaDTO textCriteriaDTO);
	
}
