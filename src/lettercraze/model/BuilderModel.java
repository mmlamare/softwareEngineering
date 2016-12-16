package lettercraze.model;

import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.model.board.Square;

public class BuilderModel {
	Level level;

	public BuilderModel() {
		this.newLevel();
	}
	
	public void loadLevel(Level l) {
		this.level = l;
	}
	
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
	
	public Level getLevel() {
		return this.level;
	}
	
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
	
	public void addWord(String w) {
		if (level.words == null) {
			level.words = new Dictionary();
		}
		level.words.addWord(w);
	}

	public void removeWord(String w) {
		level.words.removeWord(w);
	}
}
