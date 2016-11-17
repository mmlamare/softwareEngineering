package lettercraze.model.board;

public class Board {
	public static final int SIZE = 6;
	Square squares[][];
	
	// Default: initialize w/ all empty squares.
	public Board() {
		squares = new Square[6][6];
		for (int i=0; i<SIZE; ++i) {
			for (int j=0; j<SIZE; ++j) {
				squares[i][j] = Square.makeEmptySquare();
			}
		}
	}

	// float letters up (mutates the board)
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
	
	public String getString(Point p) {
		return "" + squares[p.row][p.col].getLetter();
	}

	public boolean isEmpty(Point p) {
		return squares[p.row][p.col].isEmpty();
	}

	public boolean isBlocked(Point p) {
		return squares[p.row][p.col].isBlocked();
	}
	
	public char getLetter(Point p) {
		return squares[p.row][p.col].getLetter();
	}

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

	public boolean isLetter(Point p) {
		return squares[p.row][p.col].isLetter();
	}
}
