package com.appgate.textanalysis.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appgate.textanalysis.data.dto.TextAlgorithmDTO;
import com.appgate.textanalysis.data.dto.TextAnalysisResultDTO;
import com.appgate.textanalysis.data.dto.TextCriteriaDTO;
import com.appgate.textanalysis.data.entity.TextAlgorithm;
import com.appgate.textanalysis.data.enumeration.StateEnum;
import com.appgate.textanalysis.data.factory.TextAlgorithmFactory;
import com.appgate.textanalysis.repository.TextAlgorithmRepository;
import com.appgate.textanalysis.service.CacheTextAlgorithmService;
import com.appgate.textanalysis.service.TextAnalysisService;
import com.appgate.textanalysis.service.algorithm.TextAnalyzer;
import com.appgate.textanalysis.service.algorithm.TextAnalyzerFactory;

/**
 * Service implementation for text analysis.
 * @author Fabio Berrio
 */
@Service
public class TextAnalysisServiceImpl implements TextAnalysisService {
	
	@Autowired
	TextAlgorithmRepository textAlgorithmRepository;
	
	@Autowired
	private TextAnalyzerFactory factory;
	
	@Autowired
	private CacheTextAlgorithmService cacheTextAlgorithmService;
	
	@Override
	public List<TextAlgorithmDTO> getTextAlgorithms() {
		List<TextAlgorithm> textAlgorithms = textAlgorithmRepository.findByState(StateEnum.ACTIVE.getValue());
		return textAlgorithms.stream().map(TextAlgorithmFactory::convertEntityToDTO).collect(Collectors.toList());
	}
	
	@Override
	public TextAlgorithmDTO getTextAlgorithmByCode(String code) {
		TextAlgorithm textAlgorithm = textAlgorithmRepository.findByCode(code);
		return TextAlgorithmFactory.convertEntityToDTO(textAlgorithm);
	}

	@Override
	public void addTextAlgorithm(TextAlgorithmDTO textAlgorithmDTO) {
		textAlgorithmRepository.save(TextAlgorithmFactory.convertDTOToEntity(textAlgorithmDTO));
	}
	
	@Override
	public TextAnalysisResultDTO analyzeText(String algorithmCode, TextCriteriaDTO textCriteriaDTO) {
		// Verify if the algorithm exists and is active
		// Use cache service for optimization
		TextAlgorithmDTO textAlgorithmDTO = cacheTextAlgorithmService.getTextAlgorithmByCode(algorithmCode);
		if (textAlgorithmDTO != null && StateEnum.ACTIVE.equals(textAlgorithmDTO.getState())) {
			// Get the algorithm and execute it
			TextAnalyzer textAnalyzer = factory.getTextAnalyzer(algorithmCode);
			if (textAnalyzer != null) {
				TextAnalysisResultDTO resultDTO = textAnalyzer.analyze(textCriteriaDTO);
				return resultDTO;
			}
		}
		return null;
	}

}
