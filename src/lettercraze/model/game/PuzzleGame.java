package lettercraze.model.game;

import lettercraze.model.Letter;
import lettercraze.model.Level;

/**
 * The PuzzleGame class for making puzzle levels. Since it is a
 * kind of game, it extends the Game abstract class. It overrides
 * all the necessary inherited methods from the superclass.
 * @author Jack Pugmire
 * @version 1.0
 */
public class PuzzleGame extends Game {
	/**
	 * The PuzzleGame constructor to make a a puzzle level.
	 * @param l The Level
	 * @param id The level number
	 */
	public PuzzleGame(Level l, int id) {
		super(l, id);
	}
	
	public boolean gameOver() {
		return level.wordLimit != 0 && pastWords.size() > level.wordLimit;
	}
	
	public int scoreWord(String w) {
		int result = 0;
		for (char c : w.toCharArray()) {
			result += Letter.getScore(c);
		}
		result *= (w.length() - 2);
		return result;
	}

	/**
	 * TODO Don't know what this does? Not fully implemented?
	 * @return "Puzzle"
	 */
	public String getInfoString() {
		if (level.wordLimit != 0 ) {
			return "Words left: " + (level.wordLimit - pastWords.size());
		}
		return "Unlimited words";
	}

	public Object clone() {
		PuzzleGame result = new PuzzleGame(level, levelID);
		result.score = this.score;
		result.selected = this.selected;
		result.board = this.board;
		result.pastWords = this.pastWords;
		result.pastMoves = this.pastMoves;
		return result;
	}
}
