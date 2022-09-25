package com.appgate.textanalysis.service;

import java.util.List;

import com.appgate.textanalysis.data.dto.TextAlgorithmDTO;
import com.appgate.textanalysis.data.dto.TextAnalysisResultDTO;
import com.appgate.textanalysis.data.dto.TextCriteriaDTO;

/**
 * Service interface for text analysis.
 * @author Fabio Berrio
 */
public interface TextAnalysisService {
	
	/**
	 * Get all active text algorithms.
	 * @return
	 */
	List<TextAlgorithmDTO> getTextAlgorithms();
	
	/**
	 * Add a text algorithm.
	 * @param textAlgorithmDTO
	 */
	void addTextAlgorithm(TextAlgorithmDTO textAlgorithmDTO);
	
	/**
	 * Analyze the text using the specified algorithm.
	 * @param algorithmCode
	 * @param textPairDTO
	 * @return
	 */
	TextAnalysisResultDTO analyzeText(String algorithmCode, TextCriteriaDTO textPairDTO);
}
