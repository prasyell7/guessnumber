package com.math.game.guessnumber.service;

import com.math.game.guessnumber.exception.GuessNumberException;
import com.math.game.guessnumber.model.GameNumber;

/**
 * @author Prasad
 */
public interface GuessNumberServiceIntf {

	/**
	 * This method calculates using binary search formula and guesses the next number.
	 * @param gameNumber
	 * @return
	 * @throws GuessNumberException
	 */
	GameNumber getNextGuessedNumber(GameNumber gameNumber) throws GuessNumberException;

	/**
	 * Calculates and sets new upper and lower limits for the next guess
	 * @param currentGameNumber
	 * 
	 * @return new game number with limits updated
	 * @throws GuessNumberException
	 */
	GameNumber prepareNextGameNumberLimits(GameNumber currentGameNumber)
			throws GuessNumberException;
}