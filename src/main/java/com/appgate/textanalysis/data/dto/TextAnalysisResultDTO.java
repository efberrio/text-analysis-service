package com.appgate.textanalysis.data.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextAnalysisResultDTO implements Serializable {
	private static final long serialVersionUID = -8811666109263420626L;
	
	private Integer result;

}
