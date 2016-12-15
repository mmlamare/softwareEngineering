package lettercraze.model;

import java.util.Random;

/**
 * The Letter Model Class. 
 * Each Letter Object stores its score and frequency,
 * 
 * @author Ruthenium
 * @version 1.0
 */
public class Letter {
	/** An array of scores that correspond to the score of
	 *  each letter */
	public static final int SCORES[] = {
			2,4,3,3,1,4,4,2,2,7,5,3,3,2,2,4,8,2,2,1,3,5,3,7,4,8
	};
	
	/** An array of frequencies that corespond to each letter */
	public static final double FREQS[] = {
			8.17,1.49,2.78,4.25,12.70,2.23,2.02,6.09,
			6.97,0.15,0.77,4.03,2.41,6.75,7.51,1.93,0.10,
			5.99,6.33,9.06,2.76,0.98,2.36,0.15,1.97,0.07
	};

	/**
	 * A method for accessing the score of a given letter
	 * @param letter The letter object in question
	 * @return The numerical score value for inputed letter
	 */
	public static int getScore(char letter) {
		int index = (int) letter - (int) 'a';
		return SCORES[index];
	}
	
	/**
	 * Generates a random character
	 * @return a random character
	 */
	public static char genChar() {
		return genCharFromMass(100 * Math.random());
	}
	
	/**
	 * Generates a character using the provided random number generator
	 * @return the random character
	 */
	public static char genChar(Random rng) {
		return genCharFromMass(100 * rng.nextDouble());
	}
	
	private static char genCharFromMass(double mass) {
		float cumulative=0;
		for (int i=0; i<FREQS.length; ++i) {
			cumulative += FREQS[i];
			if (cumulative > mass) {
				return (char) (i + 'a');
			}
		}
		return 'a';
	}
}
