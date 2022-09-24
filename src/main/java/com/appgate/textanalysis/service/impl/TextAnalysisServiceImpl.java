package com.appgate.textanalysis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appgate.textanalysis.data.dto.AlgorithmDTO;
import com.appgate.textanalysis.data.dto.TextAnalysisResultDTO;
import com.appgate.textanalysis.data.dto.TextPairDTO;
import com.appgate.textanalysis.data.enumeration.StateEnum;
import com.appgate.textanalysis.service.TextAnalysisService;
import com.appgate.textanalysis.service.algorithm.TextAnalyzer;
import com.appgate.textanalysis.service.algorithm.TextAnalyzerFactory;

@Service
public class TextAnalysisServiceImpl implements TextAnalysisService {
	
	@Autowired
	private TextAnalyzerFactory factory;
	
	public List<AlgorithmDTO> getAlgorithms() {
		List<AlgorithmDTO> algorithms = new ArrayList<>();
		algorithms.add(new AlgorithmDTO("distinctSubsequences", "Distinct SubSequences", StateEnum.ACTIVE));
		return algorithms;
	}
	
	public TextAnalysisResultDTO analyzeText(String algorithmCode, TextPairDTO textPairDTO) {
		TextAnalyzer textAnalyzer = factory.getTextAnalyzer(algorithmCode);
		if (textAnalyzer != null) {
			int result = textAnalyzer.analyze(textPairDTO.getSource(), textPairDTO.getTextToSearch());
			TextAnalysisResultDTO resultDTO = new TextAnalysisResultDTO(result);
			return resultDTO;
		}
		return null;
	}
}
