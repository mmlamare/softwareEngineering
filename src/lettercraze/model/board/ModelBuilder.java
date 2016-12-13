package lettercraze.model.board;

import lettercraze.model.Level;
import lettercraze.model.LevelType;

/**
 * The is the class for building the models.
 * @author Jack Pugmire
 * @version 1.0
 */
public class ModelBuilder {
	Level l;
	boolean levelLoaded;
	Point currentPoint;
	
	/**
	 * Sets level loaded as false to start things off.
	 */
	public ModelBuilder() {
		levelLoaded = false;
	}
	
	/**
	 * Sets the type of the level being build
	 * @param t The level type from the enumerated list
	 */
	public void setType(LevelType t) {
		this.l.type = t;
	}
	
	/**
	 * Modifies the states of the square between whether it is 
	 * active and empty or blocked
	 * @param p The location of the square to modify
	 */
	public void clickSquare(Point p) {
		if (l.initBoard.isBlocked(p)) {
			l.initBoard.setSquare(p, Square.makeEmptySquare());
		} else {
			l.initBoard.setSquare(p, Square.makeBlockedSquare());
		}
	}
	
	/**
	 * Sets the letter of a square
	 * @param p The location of the square to have its letter set
	 * @param ch The letter to add to the square
	 */
	public void setLetter(Point p, char ch) {
		l.initBoard.setSquare(p, Square.makeSquare(ch));
	}

	boolean createNewLevel() {
		return true;
	}

	boolean loadLevel(String name) {
		return true;
	}
}
