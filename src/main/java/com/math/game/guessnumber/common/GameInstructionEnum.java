package com.math.game.guessnumber.common;

/**
 * Enum for game instructions, ready or end
 * @author Prasad
 */
public enum GameInstructionEnum {
	READY("ready"), END("end");

	String instruction;

	GameInstructionEnum(String gameInstruction) {
		this.instruction = gameInstruction;
	}

	public static GameInstructionEnum fromgameInstruction(String gameInstruction) {
    	for (GameInstructionEnum terminationType: GameInstructionEnum.values()) {
    		if (terminationType.instruction.equalsIgnoreCase(gameInstruction)) {
    			return terminationType;
    		}
    	}
    	return null;
    }
}