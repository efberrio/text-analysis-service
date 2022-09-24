package com.appgate.textanalysis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.appgate.textanalysis.data.dto.AlgorithmDTO;
import com.appgate.textanalysis.data.dto.TextAnalysisResultDTO;
import com.appgate.textanalysis.data.dto.TextPairDTO;
import com.appgate.textanalysis.data.enumeration.StateEnum;

@Service
public class TextAnalysisService {
	
	public List<AlgorithmDTO> getAlgorithms() {
		List<AlgorithmDTO> algorithms = new ArrayList<>();
		algorithms.add(new AlgorithmDTO("distinct-subsequences", "Distinct SubSequences", StateEnum.ACTIVE));
		return algorithms;
	}
	
	public TextAnalysisResultDTO analyzeText(String algorithmCode, TextPairDTO textPairDTO) {
		return new TextAnalysisResultDTO(3);
	}
}
