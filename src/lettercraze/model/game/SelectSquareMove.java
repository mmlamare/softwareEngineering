package lettercraze.model.game;

import java.util.LinkedList;

import lettercraze.model.board.Point;

public class SelectSquareMove extends Move {
	Point loc;
	LinkedList<Point> initialSelected;

	public SelectSquareMove(Point p) {
		this.loc = p;
	}

	@SuppressWarnings("unchecked")
	public void apply(Game g) {
		initialSelected = g.selected;
		g.selected = (LinkedList<Point>) g.selected.clone();

		if (!g.selected.isEmpty() && g.selected.peek().equals(loc)) {
			g.selected.pop();
		} else {
			g.selected.push(loc);
		}
	}

	public void restore(Game g) {
		g.selected = initialSelected;
	}

	@Override
	public boolean isValid(Game g) {
		if (g.gameOver()) return false;
		if (g.isSelected(loc)) {
			// check that it's the last square
			return g.selected.peek().equals(loc);
		}
		return g.selected.isEmpty() || 
				g.selected.element().isAdjacent(loc);
	}
}
