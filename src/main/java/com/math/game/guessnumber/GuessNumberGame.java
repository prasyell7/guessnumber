package com.math.game.guessnumber;

import java.util.Scanner;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;

import com.math.game.guessnumber.common.GameConstants;
import com.math.game.guessnumber.common.GameInstructionEnum;
import com.math.game.guessnumber.common.GameProperties;
import com.math.game.guessnumber.common.NumberValueEnum;
import com.math.game.guessnumber.exception.GuessNumberException;
import com.math.game.guessnumber.model.GameNumber;
import com.math.game.guessnumber.service.GuessNumberServiceIntf;
import com.math.game.guessnumber.service.impl.GuessNumberServiceImpl;
import com.math.game.guessnumber.util.GameUtil;

/**
 * The game of number guessing starts here.
 * @author Prasad
 */
public class GuessNumberGame { 

	//Logger to log messages
	private static final Logger LOGGER = Logger.getLogger(GuessNumberGame.class);

	//Configuration for property loading
	public static Configuration gameProperites = null;

	//Load game properties
	static {
		try {
			GuessNumberGame.gameProperites = GameProperties.loadGameProperties();
		} catch (ConfigurationException exception) {
			LOGGER.debug("Exception occured while loading properties. ", exception);
		}
	}

	public static void main(String[] args) throws Exception {
        GuessNumberGame numberGame = new GuessNumberGame();
        numberGame.startGuessNumberGame();
    }
	
	/**
     * This method to start the game 
     * Game will be started by prompting the user with instructions
     * When user types and enters ready/READY, the game begins
     */
    public void startGuessNumberGame() {
    	Scanner scanner = null;
    	try {
    		LOGGER.debug("In method : startGame() : The Game has begun ... ");
    		System.out.println(GuessNumberGame.gameProperites.getString(GameConstants.WELCOME_NOTE));
    		System.out.println(GuessNumberGame.gameProperites.getString(GameConstants.GAME_INSTRUCTIONS));
    		scanner = new Scanner(System.in);
    		GameInstructionEnum userInput = GameInstructionEnum.valueOf(scanner.next().toUpperCase());
    		LOGGER.debug("User 1st input  : " + userInput);

    		switch (userInput) {
			case READY:
				continueGame(scanner, 
						new GameNumber(GuessNumberGame.gameProperites.getDouble(GameConstants.GAME_LOWER_LIMIT),
								GuessNumberGame.gameProperites.getDouble(GameConstants.GAME_UPPER_LIMIT)));
				break;
			case END:
				followGameRestart(scanner);
				break;

			default:
				System.out.println("\n" + GuessNumberGame.gameProperites.getString(
						GameConstants.GAME_STARTER_INSTRUCTION) + "\t OR \t");
				System.out.println(GuessNumberGame.gameProperites.getString(
						GameConstants.GAME_FINISH_INSTRUCTION + "\n"));
				break;
			}
        } catch (Exception exception) {
        	LOGGER.debug("Unexpected exception occurred " + exception.getLocalizedMessage(), exception);
            System.out.println(GuessNumberGame.gameProperites.getString(GameConstants.ERROR_INSTRUCTIONS));
    	} finally {
    		GameUtil.closeScanner(scanner);
    	}
    }

	/**
	 * Method to continue the game with the user's input
	 * @param gameNumber
	 */
    private void continueGame(Scanner scanner, GameNumber gameNumber) {
		LOGGER.debug("In method : continueGame() : The Game is continuing ... ");

		//Call the guess number service to perform necessary operations
        GuessNumberServiceIntf guessService = new GuessNumberServiceImpl();
        String userInput = GameConstants.STRING_EMPTY;
        try {
            do {
            	//Get the next guess number
                GameNumber gameNumberResult = guessService.getNextGuessedNumber(gameNumber);
                System.out.println("Is the Number " + gameNumberResult.getGuessedNumber().intValue() 
                				+ " ? Please type HIGHER, LOWER, YES: ");
                userInput = scanner.next();

                //If the input is Yes, then do not proceed further
                if(null != NumberValueEnum.fromNumberValue(userInput)) {
                	gameNumber = new GameNumber(gameNumberResult.getLowerLimit(), gameNumberResult.getUpperLimit(),
                			gameNumberResult.getGuessedNumber(), userInput.toUpperCase());
        			gameNumber = guessService.prepareNextGameNumberLimits(gameNumber);
        		}

            } while (!GameConstants.STRING_YES.equalsIgnoreCase(userInput));
        } catch (GuessNumberException exception) {
        	LOGGER.debug("Some exception occurred " + exception.getLocalizedMessage(), exception);
            System.out.println(GuessNumberGame.gameProperites.getString(GameConstants.ERROR_INSTRUCTIONS));
        } catch (Exception exception) {
        	LOGGER.debug("Unexpected exception occurred " + exception.getLocalizedMessage(), exception);
            System.out.println(GuessNumberGame.gameProperites.getString(GameConstants.ERROR_INSTRUCTIONS));
        } finally {
            System.out.println(GuessNumberGame.gameProperites.getString(GameConstants.THANK_YOU));
        	this.followGameRestart(scanner);
        }
    }

    /** 
     * Instructions to restart the game
     * @param scanner
     */
    private void followGameRestart(Scanner scanner) {
    	LOGGER.debug("Printing game restarting instructions");
        System.out.println(GuessNumberGame.gameProperites.getString(GameConstants.RESTART_NOTE));
        String restartIndicator = scanner.next();
        if (GameConstants.STRING_YES.equalsIgnoreCase(restartIndicator)) {
            startGuessNumberGame();
        } else {
            System.out.println(GuessNumberGame.gameProperites.getString(GameConstants.THANK_YOU));
			System.exit(0);
        }
    }
}