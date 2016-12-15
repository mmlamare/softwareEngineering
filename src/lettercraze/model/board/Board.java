package lettercraze.model.board;

/**
 * This is the board entity class.
 * @authors Jack Pugmire, Matthew Lamare
 * @version 1.0
 */
public class Board {
	/**
	 * The maximum size of the board, in either dimension,
	 *  is 6 
	 */
	public static final int SIZE = 6;
	Square squares[][];
	
	/** Default: initialize w/ all empty squares. */
	public Board() {
		squares = new Square[6][6];
		for (int i=0; i<SIZE; ++i) {
			for (int j=0; j<SIZE; ++j) {
				squares[i][j] = Square.makeEmptySquare();
			}
		}
	}

	/**
	 * float letters up (mutates the board)
	 */
	public void floatLetters() {
		// Go one column at a time, from top to bottom. If an empty square is 
		// found, then swap it with the next highest square containing a
		// letter.
		for (int col=0; col<SIZE; ++col) {
			for(int row=0; row<SIZE-1; ++row) {
				if (squares[row][col].isEmpty()) {
					// found an empty square: search all squares below it
					for(int row2= row+1; row2 < SIZE; ++row2) {
						if (squares[row2][col].isLetter()) {
							// swap the empty square with the first 
							squares[row][col] = squares[row2][col];
							squares[row2][col] = Square.makeEmptySquare();
							break;
						}
					}
				}
			}
		}
	}
	
	/**
	 * Creates a string name from a selected point
	 * @param p A specific point on the board grid
	 * @return A string name for the selected point
	 */
	public String getString(Point p) {
		return "" + squares[p.row][p.col].getLetter();
	}

	/**
	 * Determines whether the square is empty
	 * @param p A specific point on the board grid
	 * @return T/F if the square is empty
	 */
	public boolean isEmpty(Point p) {
		return squares[p.row][p.col].isEmpty();
	}

	/**
	 * Determines whether the square is not actually a part of 
	 * this game.
	 * @param p The point to indicate what square to look at
	 * @return T/F if the square is blocked
	 */
	public boolean isBlocked(Point p) {
		return squares[p.row][p.col].isBlocked();
	}
	
	/**
	 * Returns the letter as a char that is inside a given
	 * square.
	 * @param p The point to indicate what square to look at 
	 * @return The char that that square contains
	 */
	public char getLetter(Point p) {
		return squares[p.row][p.col].getLetter();
	}

	/**
	 * Adds a square to the board entity
	 * @param p The point where the square should go
	 * @param sq The square object to be added
	 */
	public void setSquare(Point p, Square sq) {
		squares[p.row][p.col] = sq;
	}

	public Board clone() {
		Board result = new Board();
		for (int col=0; col<SIZE; ++col) {
			for (int row=0; row<SIZE; ++row) {
				result.squares[row][col] = squares[row][col];
			}
		}
		return result;
	}

	/**
	 * Determines if it is a letter in a square
	 * @param p The location of the square that should be 
	 * looked at
	 * @return T/F if there is a letter in that square
	 */
	public boolean isLetter(Point p) {
		return squares[p.row][p.col].isLetter();
	}
}
