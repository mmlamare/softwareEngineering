package lettercraze.model.game;

import java.util.LinkedList;

import lettercraze.model.board.Point;

public class SelectSquareMove extends Move {
	Point loc;
	boolean isDeselection;

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
		return initialState.selected.isEmpty() || 
				initialState.selected.element().isAdjacent(loc);
	}
}
