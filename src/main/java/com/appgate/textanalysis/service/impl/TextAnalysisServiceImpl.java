package com.appgate.textanalysis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.appgate.textanalysis.data.dto.AlgorithmDTO;
import com.appgate.textanalysis.data.dto.TextAnalysisResultDTO;
import com.appgate.textanalysis.data.dto.TextPairDTO;
import com.appgate.textanalysis.data.enumeration.StateEnum;
import com.appgate.textanalysis.service.TextAnalysisService;

@Service
public class TextAnalysisServiceImpl implements TextAnalysisService {
	
	public List<AlgorithmDTO> getAlgorithms() {
		List<AlgorithmDTO> algorithms = new ArrayList<>();
		algorithms.add(new AlgorithmDTO("distinct-subsequences", "Distinct SubSequences", StateEnum.ACTIVE));
		return algorithms;
	}
	
	public TextAnalysisResultDTO analyzeText(String algorithmCode, TextPairDTO textPairDTO) {
		return new TextAnalysisResultDTO(3);
	}
}
