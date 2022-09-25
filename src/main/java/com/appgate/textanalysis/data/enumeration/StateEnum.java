package com.appgate.textanalysis.data.enumeration;

import java.util.Arrays;

/**
 * Represent the state of an object.
 * @author Fabio Berrio
 */
public enum StateEnum {
	ACTIVE("A"),
	INACTIVE("I");
	
	private final String value;
	
	private StateEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static StateEnum get(final String value) {
		return Arrays.stream(StateEnum.values()).filter(s -> s.getValue().equals(value)).findFirst().orElse(null);
	}
	
}
