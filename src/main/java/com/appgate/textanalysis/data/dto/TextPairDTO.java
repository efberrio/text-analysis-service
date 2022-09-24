package com.appgate.textanalysis.data.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextPairDTO implements Serializable {
	private static final long serialVersionUID = 7135238342033822203L;
	
	private String source;
	private String textToSearch;
}
