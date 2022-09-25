package com.appgate.textanalysis.data.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="TextCriteria", description="Text criteria for analysis")
public class TextCriteriaDTO implements Serializable {
	private static final long serialVersionUID = 7135238342033822203L;
	
	@NotBlank
	private String source;
	@NotBlank
	private String textToSearch;
}
