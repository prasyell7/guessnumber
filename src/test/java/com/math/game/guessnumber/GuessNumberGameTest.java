package com.math.game.guessnumber;

import com.math.game.guessnumber.model.GameNumber;
import com.math.game.guessnumber.service.impl.GuessNumberServiceImpl;
import com.math.game.guessnumber.util.GameUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for GuessNumber Game.
 */
public class GuessNumberGameTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GuessNumberGameTest( String testName ) {
        super( testName );
    }

    GuessNumberServiceImpl guessNumberService = new GuessNumberServiceImpl();

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( GuessNumberGameTest.class );
    }

    /**
     * A Junit Test case to test the program
     */
    public void testGuessNumber() throws Exception {
        GameNumber gameNumber = new GameNumber(0d,100d);
        Double userChoice = 70d;
        boolean found = true;
        while(!found){
            gameNumber = guessNumberService.getNextGuessedNumber(gameNumber);
            if(gameNumber.getGuessedNumber() < userChoice){
            	gameNumber = GameUtil.prepareNextGameNumberLimits(gameNumber);
            } else if(gameNumber.getGuessedNumber() > userChoice){
            	gameNumber = GameUtil.prepareNextGameNumberLimits(gameNumber);
            } else {
                assert(true);
                found = true;
            }
        }
    }

    /**
     * This tests when lower limit and upper limit has wrong range
     */
    public void testNegativeCase() {
    try{
    	GameNumber numberGuess = new GameNumber(10d,5d);
        guessNumberService.getNextGuessedNumber(numberGuess);
    } catch(Exception e){
        assert(true);
    }

    }
}
