package lettercraze.model.game;

import java.util.LinkedList;

import lettercraze.model.board.Point;

/**
 * This class handles selection and de-selection of square at
 * the entity level. 
 * @author Ruthenium
 * @version 1.0
 */
public class SelectSquareMove extends Move {
	Point loc;
	boolean isDeselection;

	/**
	 * The constructor for creating a SelectSquareMove Object
	 * @param initial The initial state of the game
	 * @param p The point that references the location of the
	 * square that is to be selected.
	 */
	public SelectSquareMove(Game initial, Point p) {
		this.initialState = initial;
		this.loc = p;
		this.isDeselection = initial.isSelected(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Game doMove() {
		Game result = (Game) initialState.clone();

		// Copy everything we might change (in this case, only the selected
		// squares and the moves history)
		result.selected = (LinkedList<Point>) (initialState.selected.clone());
		result.pastMoves = (LinkedList<Move>) (initialState.pastMoves.clone());

		if (isDeselection) {
			result.selected.pop();
			result.pastMoves.push(this);
		} else {
			result.selected.push(loc);
			result.pastMoves.push(this);
		}
		return result;
	}

	@Override
	public Game undoMove() {
		return this.initialState;
	}

	@Override
	public boolean isValid() {
		if (initialState.gameOver()) return false;
		if (isDeselection) {
			// check that it's the last square
			return initialState.selected.element().equals(loc);
		}
		return !initialState.board.isBlocked(loc) &&
				(initialState.selected.isEmpty() || 
						initialState.selected.element().isAdjacent(loc));
	}
}
