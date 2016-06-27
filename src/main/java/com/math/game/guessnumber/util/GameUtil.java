package com.math.game.guessnumber.util;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.math.game.guessnumber.GuessNumberGame;
import com.math.game.guessnumber.common.GameConstants;
import com.math.game.guessnumber.common.NumberValueEnum;
import com.math.game.guessnumber.exception.GuessNumberException;
import com.math.game.guessnumber.model.GameNumber;

/**
 * This is a util class holds utility methods.
 * @author Prasad
 *
 */
public class GameUtil {

	//Logger to log messages
	private static final Logger LOGGER = Logger.getLogger(GameUtil.class);

	/**
	 * This method closes the opened scanner.
	 * @param scanner
	 */
	public static void closeScanner(Scanner scanner) {
		LOGGER.debug("Closing scanner");
		if(null != scanner) {
			scanner.close();
		}
	}

	/**
	 * This method calculates using binary search formula and guesses the next number.
	 */
	public static GameNumber getGuessedNumber(GameNumber currentGameNumber) throws GuessNumberException {
        Double nextGuessedNumber = Math.floor(currentGameNumber.getLowerLimit() 
        		+ ((currentGameNumber.getUpperLimit() - currentGameNumber.getLowerLimit()))/2);
        LOGGER.debug("Calculating next number " + nextGuessedNumber);
		return new GameNumber(currentGameNumber.getLowerLimit(),
				currentGameNumber.getUpperLimit(), nextGuessedNumber);
	}

	/**
	 * Calculates and sets new upper and lower limits for the next guess
	 * @param userInput
	 * @param currentGameNumber
	 * @return new game number with limits updated
	 * @throws GuessNumberException
	 */
    public static GameNumber prepareNextGameNumberLimits(
    		GameNumber currentGameNumber) throws GuessNumberException {
    	Double upperLimit = currentGameNumber.getUpperLimit();
    	Double lowerLimit = currentGameNumber.getLowerLimit();

    	LOGGER.debug("Prepare new number limits for input : " + currentGameNumber.getUserInput());
    	switch (NumberValueEnum.valueOf(currentGameNumber.getUserInput())) {
		case HIGHER:
			lowerLimit = currentGameNumber.getGuessedNumber();
			break;

		case LOWER:
			upperLimit = currentGameNumber.getGuessedNumber();
			break;

		default:
			System.out.println(GuessNumberGame.gameProperites.getString(GameConstants.ERROR_INCORRECT_OPTION));
			throw new GuessNumberException("Incorrect option was entered, so the game was aborted.");
		}
    	GameNumber nextGameNumber = new GameNumber(lowerLimit, upperLimit); 
    	LOGGER.debug("Returning new GameNumber Bean : " + nextGameNumber.toString());
    	return nextGameNumber;
    }
}
