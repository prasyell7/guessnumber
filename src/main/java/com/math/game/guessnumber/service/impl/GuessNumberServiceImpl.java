package com.math.game.guessnumber.service.impl;

import org.apache.log4j.Logger;

import com.math.game.guessnumber.exception.GuessNumberException;
import com.math.game.guessnumber.model.GameNumber;
import com.math.game.guessnumber.service.GuessNumberServiceIntf;
import com.math.game.guessnumber.util.GameUtil;

/**
 * Guess number service to perform various operations, like guessing next number
 * calculate and update new limits etc.
 * @author Prasad
 *
 */
public class GuessNumberServiceImpl implements GuessNumberServiceIntf {

	//Logger to log messages
	private static final Logger LOGGER = Logger.getLogger(GuessNumberServiceImpl.class);

	/**
	 * This method calculates using binary search formula and guesses the next number.
	 */
	public GameNumber getNextGuessedNumber(GameNumber gameNumber) throws GuessNumberException {
		LOGGER.debug("Entered getNextGuessedNumber method with values : " + gameNumber.toString());
		return GameUtil.getGuessedNumber(gameNumber);
	}

	/**
	 * Calculates and sets new upper and lower limits for the next guess
	 * 
	 * This method seems to be a duplicate, but when there is a separation between UI and service layers
	 * util methods are not exposed out of the service layer. So the only way is to call service.
	 * @param currentGameNumber
	 * 
	 * @return new game number with limits updated
	 * @throws GuessNumberException
	 */
	public GameNumber prepareNextGameNumberLimits(GameNumber currentGameNumber) throws GuessNumberException {
		LOGGER.debug("Entered prepareNextGameNumberLimits method with values : " + currentGameNumber.toString());
		return GameUtil.prepareNextGameNumberLimits(currentGameNumber);
	}
}