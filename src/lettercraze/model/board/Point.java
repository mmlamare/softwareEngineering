package lettercraze.model.board;

/**
 * This is the point class, that is an abstraction of the 
 * geometric location of square on the board
 * @author Ruthenium
 * @version 1.0
 */
public class Point {
	/** The point's row */
	public final int row;
	/** The point's column */
	public final int col;
	
	/**
	 * Constructor for making a point given a row and column
	 * @param row The row for the Point
	 * @param col The column for the Point
	 */
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * Determines whether another point is adjacent to this Point
	 * @param p The other Point to compare adjacency
	 * @return T/F if the point is adjacent to this point
	 */
	public boolean isAdjacent(Point p) {
		boolean rValid = row == p.row || row + 1 == p.row || row - 1 == p.row;
		boolean cValid = col == p.col || col + 1 == p.col || col - 1 == p.col;
		return rValid && cValid && !(row == p.row && col == p.col);
	}
}