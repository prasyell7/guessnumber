package com.math.game.guessnumber.exception;

/**
 * Customized Exception class for this game.
 * TODO : Add ExceptionHandler in association with this exception class 
 * @author Prasad
 */
public class GuessNumberException extends Exception {

	private static final long serialVersionUID = -6836717027975893859L;

	/**
	 * Default
	 */
	public GuessNumberException() {
		super();
	}

	/**
	 * Exception with message and throwable
	 * @param message
	 * @param cause
	 */
	public GuessNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Just an exception message
	 * @param message
	 */
	public GuessNumberException(String message) {
		super(message);
	}
}