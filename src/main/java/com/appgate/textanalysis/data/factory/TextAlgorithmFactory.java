package com.appgate.textanalysis.data.factory;

import com.appgate.textanalysis.data.dto.TextAlgorithmDTO;
import com.appgate.textanalysis.data.entity.TextAlgorithm;
import com.appgate.textanalysis.data.enumeration.StateEnum;

public class TextAlgorithmFactory {
	
	public static TextAlgorithmDTO convertEntityToDTO(TextAlgorithm textAlgorithm) {
		TextAlgorithmDTO textAlgorithmDTO = new TextAlgorithmDTO();
		if (textAlgorithm == null) {
			return textAlgorithmDTO;
		}
		textAlgorithmDTO.setCode(textAlgorithm.getCode());
		textAlgorithmDTO.setName(textAlgorithm.getName());
		textAlgorithmDTO.setState(StateEnum.get(textAlgorithm.getState()));
		return textAlgorithmDTO;
	}

	public static TextAlgorithm convertDTOToEntity(TextAlgorithmDTO textAlgorithmDTO) {
		TextAlgorithm textAlgorithm = new TextAlgorithm();
		if (textAlgorithmDTO == null) {
			return textAlgorithm;
		}
		textAlgorithm.setCode(textAlgorithmDTO.getCode());
		textAlgorithm.setName(textAlgorithmDTO.getName());
		textAlgorithm.setState(textAlgorithmDTO.getState().getValue());
		return textAlgorithm;
	}
}
