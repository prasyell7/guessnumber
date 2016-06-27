package com.math.game.guessnumber.common;

/**
 * Enum for number value instructions, lower and higher
 * @author Prasad
 */
public enum NumberValueEnum {
	HIGHER("higher"), LOWER("lower");

	String value;

	NumberValueEnum(String numberValue) {
		this.value = numberValue;
	}

	public static NumberValueEnum fromNumberValue(String numberValue) {
    	for (NumberValueEnum terminationType: NumberValueEnum.values()) {
    		if (terminationType.value.equalsIgnoreCase(numberValue)) {
    			return terminationType;
    		}
    	}
    	return null;
    }
}
