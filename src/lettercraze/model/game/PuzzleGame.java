package lettercraze.model.game;

import lettercraze.model.Letter;
import lettercraze.model.Level;

public class PuzzleGame extends Game {
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
