package com.math.game.guessnumber.common;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Customizable/externalizable properties are loaded into the game with this class.
 * @author Prasad
 */
public class GameProperties {

	/**
	 * Load the game properties, limits, messages etc.
	 * @return
	 * @throws ConfigurationException
	 */
	public static Configuration loadGameProperties() throws ConfigurationException {
		return new PropertiesConfiguration("guessNumber.properties");
	}
}