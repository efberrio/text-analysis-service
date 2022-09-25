package com.appgate.textanalysis.service;

import java.util.List;

import com.appgate.textanalysis.data.dto.TextAlgorithmDTO;
import com.appgate.textanalysis.data.dto.TextAnalysisResultDTO;
import com.appgate.textanalysis.data.dto.TextCriteriaDTO;

public interface TextAnalysisService {
	
	List<TextAlgorithmDTO> getTextAlgorithms();
	
	void addTextAlgorithm(TextAlgorithmDTO textAlgorithmDTO);
	
	TextAnalysisResultDTO analyzeText(String algorithmCode, TextCriteriaDTO textPairDTO);
}
