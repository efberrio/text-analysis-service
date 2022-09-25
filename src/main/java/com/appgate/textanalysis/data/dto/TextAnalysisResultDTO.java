package com.appgate.textanalysis.data.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="TextAnalysisResult", description="Text analysis result")
public class TextAnalysisResultDTO implements Serializable {
	private static final long serialVersionUID = -8811666109263420626L;
	
	@NotNull
	private Integer result;

}
