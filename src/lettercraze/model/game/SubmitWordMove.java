package lettercraze.model.game;

import java.util.LinkedList;

import lettercraze.Resources;
import lettercraze.model.Dictionary;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.model.board.Square;

public class SubmitWordMove extends Move {
	String word;
	LinkedList<Point> initialSelection;
	LinkedList<String> initialWords;
	Board initialBoard;
	int initialScore;

	public SubmitWordMove() {}

	@SuppressWarnings("unchecked")
	public void apply(Game g) {
		// Save restoreable values
		initialSelection = g.selected;
		initialWords = (LinkedList<String>) g.pastWords.clone();
		initialBoard = (Board) g.getBoard().clone();
		initialScore = g.getScore();

		// Compute the selected word and clear out the selected squares
		String word = "";
		for (Point p : g.selected) {
			char ch = g.getBoard().getLetter(p);
			if (ch == 'q') {
				word = "qu" + word;
			} else {
				word = ch + word;
			}

			g.getBoard().setSquare(p, Square.makeEmptySquare());
		}
		g.repopulateBoard();

		// update the Game
		g.score += g.scoreWord(word);
		g.selected = new LinkedList<Point>();
		g.pastWords.push(word);
	}

	public void restore(Game g) {
		g.selected = initialSelection;
		g.pastWords = initialWords;
		g.board = initialBoard;
		g.score = initialScore;
	}

	@Override
	public boolean isValid(Game g) {
		if (g.gameOver()) return false;

		String word = "";
		for (Point p : g.selected) {
			char ch = g.getBoard().getLetter(p);
			if (ch == 'q') {
				word = "qu" + word;
			} else {
				word = ch + word;
			}
		}

		if (word.length() < 3) return false;

		Dictionary d = g.level.words;
		if (d == null) {
			d = Resources.DICT;
		}
		return d.isWord(word);
	}
}
