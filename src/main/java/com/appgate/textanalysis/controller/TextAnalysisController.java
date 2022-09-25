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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.textanalysis.data.dto.TextAlgorithmDTO;
import com.appgate.textanalysis.data.dto.TextAnalysisResultDTO;
import com.appgate.textanalysis.data.dto.TextCriteriaDTO;
import com.appgate.textanalysis.service.TextAnalysisService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST API for text analysis.
 * @author Fabio Berrio
 */
@RestController
@RequestMapping("/api/textalgorithms")
@Tag(name = "Text Analysis API", description = "REST API for text analysis")
public class TextAnalysisController {
	
	@Autowired
	private TextAnalysisService textAnalysisService;
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get the active text algorithms")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Found the text algorithms")
	  })
	public List<TextAlgorithmDTO> getTextAlgorithms() {
		return textAnalysisService.getTextAlgorithms();
	}
	
	@PostMapping(value = "/{algorithmCode}/analyze", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Analyze the text using the specified algorithm")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Text analyzed"),
	  @ApiResponse(responseCode = "400", description = "Invalid algorithm code or input")
	  })
	public ResponseEntity<TextAnalysisResultDTO> analyzeText(@PathVariable("algorithmCode") String algorithmCode, @RequestBody TextCriteriaDTO textCriteriaDTO) {
		TextAnalysisResultDTO resultDTO = textAnalysisService.analyzeText(algorithmCode, textCriteriaDTO);
		if (resultDTO != null) {
			return new ResponseEntity<TextAnalysisResultDTO>(resultDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<TextAnalysisResultDTO>(HttpStatus.BAD_REQUEST);
		}
	}

}
