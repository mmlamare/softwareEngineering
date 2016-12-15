package lettercraze.model.board;

import static lettercraze.model.board.SquareType.*;

/**
 * The class is for the Square entities
 * @author Ruthenium
 * @version 1.0
 */
public class Square {
	final SquareType type;
	final char letter;
	
	private Square(SquareType type, char letter) {
		this.type = type;
		this.letter = letter;
	}

	/**
	 * Makes a new blocked Square
	 * @return A new blocked Square
	 */
	public static Square makeBlockedSquare() {
		return new Square(BLOCKED, '\0');
	}
	
	/**
	 * Makes a new empty, not blocked, Square
	 * @return A new empty Square
	 */
	public static Square makeEmptySquare() {
		return new Square(EMPTY, '\0');
	}
	
	/**
	 * Makes a new Square that contains a letter
	 * @param letter The letter you want in the Square
	 * @return A new square with a given letter in it
	 */
	public static Square makeSquare(char letter) {
		return new Square(LETTER, letter);
	}
	
	/**
	 * Returns the status of whether the Square is an 
	 * empty Square
	 * @return the status of whether the Square is an 
	 * empty Square
	 */
	public boolean isEmpty() {
		return type == EMPTY;
	}

	/**
	 * Returns the status of whether the Square is a 
	 * blocked Square
	 * @return the status of whether the Square is a 
	 * blocked Square
	 */
	public boolean isBlocked() {
		return type == BLOCKED;
	}

	/**
	 * Returns the status of whether the Square is a 
	 * letter Square.
	 * 
	 * Congratulations! You have made it this far into my 
	 * documentation! Email mmlamare@wpi.edu for your prize!
	 * 
	 * @return the status of whether the Square is a 
	 * letter Square
	 */
	public boolean isLetter() {
		return type == LETTER;
	}

	/**
	 * Returns the letter for a given letter Square
	 * @return The letter of a letter Square
	 */
	public char getLetter() {
		//TODO check first that it is indeed a letter Square
		return letter;
	}
}