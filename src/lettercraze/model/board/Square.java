package lettercraze.model.board;

import static lettercraze.model.board.SquareType.*;

public class Square {
	final SquareType type;
	final char letter;
	
	private Square(SquareType type, char letter) {
		this.type = type;
		this.letter = letter;
	}

	public static Square makeBlockedSquare() {
		return new Square(BLOCKED, '\0');
	}
	
	public static Square makeEmptySquare() {
		return new Square(EMPTY, '\0');
	}
	
	public static Square makeSquare(char letter) {
		return new Square(LETTER, letter);
	}
	
	public boolean isEmpty() {
		return type == EMPTY;
	}

	public boolean isBlocked() {
		return type == BLOCKED;
	}

	public boolean isLetter() {
		return type == LETTER;
	}

	public char getLetter() {
		return letter;
	}
}
