package lettercraze.model;

import lettercraze.model.board.Point;
import lettercraze.model.board.Square;

public class ModelBuilder {
	Level l;
	boolean levelLoaded;
	Point currentPoint;
	
	public ModelBuilder() {
		levelLoaded = false;
	}
	
	public void setType(LevelType t) {
		this.l.type = t;
	}
	
	public void clickSquare(Point p) {
		if (l.initBoard.isBlocked(p)) {
			l.initBoard.setSquare(p, Square.makeEmptySquare());
		} else {
			l.initBoard.setSquare(p, Square.makeBlockedSquare());
		}
	}
	
	public void setLetter(Point p, char ch) {
		l.initBoard.setSquare(p, Square.makeSquare(ch));
	}

	boolean createNewLevel() {
		return true;
	}

	boolean loadLevel(String name) {
		return true;
	}
}
