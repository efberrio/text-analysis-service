package com.appgate.textanalysis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.textanalysis.data.dto.AlgorithmDTO;
import com.appgate.textanalysis.data.dto.TextAnalysisResultDTO;
import com.appgate.textanalysis.data.dto.TextPairDTO;
import com.appgate.textanalysis.service.TextAnalysisService;

@RestController
public class TextAnalysisController {
	
	@Autowired
	private TextAnalysisService textAnalysisService;
	
	@GetMapping(value = "/algorithms", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AlgorithmDTO> getAlgorithms() {
		return textAnalysisService.getAlgorithms();
	}
	
	@PostMapping(value = "/algorithms/{algorithmCode}/analyze", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TextAnalysisResultDTO> analyzeText(@PathVariable("algorithmCode") String algorithmCode, @RequestBody TextPairDTO textPairDTO) {
		TextAnalysisResultDTO resultDTO = textAnalysisService.analyzeText(algorithmCode, textPairDTO);
		if (resultDTO != null) {
			return new ResponseEntity<TextAnalysisResultDTO>(resultDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<TextAnalysisResultDTO>(HttpStatus.BAD_REQUEST);
		}
	}

}
