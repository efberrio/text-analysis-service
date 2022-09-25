package com.appgate.textanalysis.data.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.appgate.textanalysis.data.enumeration.StateEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="TextAlgorithm", description="Text algorithm definition")
public class TextAlgorithmDTO implements Serializable {
	private static final long serialVersionUID = 3053829514537266018L;
	
	@NotBlank
	@Size(min = 0, max = 20)
	private String code;
	@NotBlank
	@Size(min = 0, max = 30)
	private String name;
	@NotNull
	private StateEnum state;
}
