package com.appgate.textanalysis.data.dto;

import java.io.Serializable;

import com.appgate.textanalysis.data.enumeration.StateEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlgorithmDTO implements Serializable {
	private static final long serialVersionUID = 3053829514537266018L;
	
	private String code;
	private String name;
	private StateEnum state;
}
