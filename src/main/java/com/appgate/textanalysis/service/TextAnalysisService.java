package com.appgate.textanalysis.service;

import java.util.List;

import com.appgate.textanalysis.data.dto.AlgorithmDTO;
import com.appgate.textanalysis.data.dto.TextAnalysisResultDTO;
import com.appgate.textanalysis.data.dto.TextPairDTO;

public interface TextAnalysisService {
	
	List<AlgorithmDTO> getAlgorithms();
	
	TextAnalysisResultDTO analyzeText(String algorithmCode, TextPairDTO textPairDTO);
}
