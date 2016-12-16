package lettercraze.model;

import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.model.board.Square;

/**
 * The main entity class for the builder
 * @author Ruthenium
 *
 */
public class BuilderModel {
	Level level;

	/**
	 * Create a new Builder with an empty level
	 */
	public BuilderModel() {
		this.newLevel();
	}
	
	/**
	 * Load a level into the builder
	 * @param l The level to load
	 */
	public void loadLevel(Level l) {
		this.level = l;
	}
	
	/**
	 * Create a new level and load it
	 */
	public void newLevel() {
		// initialize a puzzle level
		this.level = new Level();

		// Set default level parameters
		level.initBoard = new Board();
		level.oneStar = 100;
		level.twoStar = 200;
		level.threeStar = 300;
		level.type = LevelType.PUZZLE;
		level.limit = 10;
		level.words = null;
		level.name = "";
	}
	
	/**
	 * Getter for the current level
	 * @return The level
	 */
	public Level getLevel() {
		return this.level;
	}
	
	/**
	 * Getter for the board
	 * @return The board
	 */
	public Board getBoard() {
		return this.level.initBoard;
	}

	/**
	 * Modifies the states of the square between whether it is 
	 * active and empty or blocked
	 * @param p The location of the square to modify
	 */
	public void toggleBlocked(Point p) {
		if (getBoard().isBlocked(p)) {
			getBoard().setSquare(p, Square.makeEmptySquare());
		} else {
			getBoard().setSquare(p, Square.makeBlockedSquare());
		}
	}

	/**
	 * Sets the letter of a square
	 * @param p The location of the square to have its letter set
	 * @param ch The letter to add to the square
	 */
	public void setLetter(Point p, char ch) {
		getBoard().setSquare(p, Square.makeSquare(ch));
	}
	
	/**
	 * Add a word to the level's dictionary
	 * @param w The word to add.
	 */
	public void addWord(String w) {
		if (level.words == null) {
			level.words = new Dictionary();
		}
		level.words.addWord(w);
	}

	/**
	 * Remove a word from the level's dictionary (if it's there)
	 * @param w The word to remove
	 */
	public void removeWord(String w) {
		level.words.removeWord(w);
	}
}
