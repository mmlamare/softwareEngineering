package lettercraze.model.game;

import lettercraze.model.Level;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;

public class ThemeGame extends Game {

	public ThemeGame(Level l, int id) {
		super(l,id);
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
		return level.name;
	}

	public Object clone() {
		ThemeGame result = new ThemeGame(level, levelID);
		result.score = this.score;
		result.selected = this.selected;
		result.board = this.board;
		result.pastWords = this.pastWords;
		result.pastMoves = this.pastMoves;
		return result;
	}
}
