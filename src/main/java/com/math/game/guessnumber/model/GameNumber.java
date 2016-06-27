package com.math.game.guessnumber.model;

import java.io.Serializable;

/**
 * GameNumber bean class. This is made immutable to make sure 
 * no changes are made to the constructed object.
 * @author Prasad
 */
public class GameNumber implements Serializable{

	private static final long serialVersionUID = 9119909796839962408L;
	private final Double lowerLimit;
	private final Double upperLimit;
	private final Double guessedNumber;
	private final String userInput;

	/**
	 * 
	 * @param lowerLimit
	 * @param upperLimit
	 */
	public GameNumber(Double lowerLimit, Double upperLimit) {
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.guessedNumber = null;
		this.userInput = null;
	}
	
	/**
	 * 
	 * @param lowerLimit
	 * @param upperLimit
	 * @param guessedNumber
	 */
	public GameNumber(Double lowerLimit, Double upperLimit, Double guessedNumber) {
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.guessedNumber = guessedNumber;
		this.userInput = null;
	}

	/**
	 * @param upperLimit
	 * @param lowerLimit
	 * @param guessedNumber
	 * @param userInput
	 */
	public GameNumber(Double lowerLimit, Double upperLimit, Double guessedNumber, String userInput) {
		super();
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.guessedNumber = guessedNumber;
		this.userInput = userInput;
	}

	/**
	 * @return the lowerLimit
	 */
	public Double getLowerLimit() {
		return lowerLimit;
	}
	
	/**
	 * @return the upperLimit
	 */
	public Double getUpperLimit() {
		return upperLimit;
	}

	/**
	 * @return the guessedNumber
	 */
	public Double getGuessedNumber() {
		return guessedNumber;
	}

	/**
	 * @return the userInput
	 */
	public String getUserInput() {
		return userInput;
	}

	/**
	 * Overridden toString()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guessedNumber == null) ? 0 : guessedNumber.hashCode());
		result = prime * result + ((lowerLimit == null) ? 0 : lowerLimit.hashCode());
		result = prime * result + ((upperLimit == null) ? 0 : upperLimit.hashCode());
		result = prime * result + ((userInput == null) ? 0 : userInput.hashCode());
		return result;
	}

	/**
	 * Overridden toString()
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GameNumber)) {
			return false;
		}
		GameNumber other = (GameNumber) obj;
		if (guessedNumber == null) {
			if (other.guessedNumber != null) {
				return false;
			}
		} else if (!guessedNumber.equals(other.guessedNumber)) {
			return false;
		}
		if (lowerLimit == null) {
			if (other.lowerLimit != null) {
				return false;
			}
		} else if (!lowerLimit.equals(other.lowerLimit)) {
			return false;
		}
		if (upperLimit == null) {
			if (other.upperLimit != null) {
				return false;
			}
		} else if (!upperLimit.equals(other.upperLimit)) {
			return false;
		}
		if (userInput == null) {
			if (other.userInput != null) {
				return false;
			}
		} else if (!userInput.equals(other.userInput)) {
			return false;
		}
		return true;
	}

	/**
	 * Overridden toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GameNumber [lowerLimit=");
		builder.append(lowerLimit);
		builder.append("\t, upperLimit=");
		builder.append(upperLimit);
		builder.append("\t, guessedNumber=");
		builder.append(guessedNumber);
		builder.append("\t, userInput=");
		builder.append(userInput);
		builder.append("]");
		return builder.toString();
	}
}