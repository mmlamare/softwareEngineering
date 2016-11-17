package lettercraze.model.board;

public class Point {
	public final int row;
	public final int col;
	
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public boolean isAdjacent(Point p) {
		boolean rValid = row == p.row || row + 1 == p.row || row - 1 == p.row;
		boolean cValid = col == p.col || col + 1 == p.col || col - 1 == p.col;
		return rValid && cValid && !(row == p.row && col == p.col);
	}
}
