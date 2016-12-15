package lettercraze.model.game;

import java.util.Random;

import lettercraze.model.Level;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;

/**
 * The ThemeGame class for making Theme levels. Since it is a
 * kind of game, it extends the Game abstract class. It overrides
 * all the necessary inherited methods from the superclass.
 * @author Ruthenium
 * @version 1.0
 */
public class ThemeGame extends Game {

	/**
	 * This is the constructor for ThemeGame
	 * @param l The Level object
	 * @param id The level number
	 */
	public ThemeGame(Level l, int id, Random rng) {
		super(l,id,rng);
	}

	@Override
	public boolean gameOver() {
		// check if the whole board is empty
		for (int row=0; row < Board.SIZE; ++row) {
			for (int col=0; col < Board.SIZE; ++col) {
				if (board.isLetter(new Point(row,col)))
					return false;
			}
		}
		return true;
	}

	@Override
	public int scoreWord(String w) {
		return 1;
	}

	@Override
	public void repopulateBoard() {
		board.floatLetters();
		// don't fill in empty spaces
	}
	
	@Override
	public String getInfoString() {
		return "Theme | " + level.name;
	}

	public Object clone() {
		ThemeGame result = new ThemeGame(level, levelID, rng);
		result.score = this.score;
		result.selected = this.selected;
		result.board = this.board;
		result.pastWords = this.pastWords;
		result.pastMoves = this.pastMoves;
		return result;
	}
}
