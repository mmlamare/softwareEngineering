package lettercraze.model.game;

import java.util.LinkedList;

import lettercraze.files.Resources;
import lettercraze.model.Dictionary;
import lettercraze.model.board.Point;
import lettercraze.model.board.Square;

/**
 * This is the class for handling the submitting of a word at 
 * the entity level.
 * @author Ruthenium
 * @version 1.0
 */
public class SubmitWordMove extends Move {
	String word;

	/**
	 * This is the constructor for SubmitWordMove
	 * @param initial The initial Game object
	 */
	public SubmitWordMove(Game initial) {
		this.initialState = initial;
		word = "";
		for (Point p : initial.selected) {
			char ch = initial.getBoard().getLetter(p);
			if (ch == 'q') {
				word = "qu" + word;
			} else {
				word = ch + word;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Game doMove() {
		Game result = (Game) initialState.clone();

		// save the things we'll modify
		result.board = (initialState.getBoard().clone());
		result.pastWords= (LinkedList<String>) (initialState.pastWords.clone());
		result.pastMoves = (LinkedList<Move>) (initialState.pastMoves.clone());

		result.score += initialState.scoreWord(word);

		for (Point p : result.selected) {
			result.board.setSquare(p, Square.makeEmptySquare());
		}
		result.repopulateBoard();

		result.pastWords.push(word);
		result.selected = new LinkedList<Point>();
		result.pastMoves.push(this);

		return result;
	}

	@Override
	public Game undoMove() {
		return initialState;
	}

	@Override
	public boolean isValid() {
		if (initialState.gameOver()) return false;
		if (word.length() < 3) return false;

		Dictionary d = initialState.level.words;
		if (d == null) {
			d = Resources.DICT;
		}
		return d.isWord(word);
	}
	
	@Override
	public boolean automagicUndo() {
		return false;
	}
}
