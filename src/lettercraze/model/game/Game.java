package lettercraze.model.game;

import java.util.LinkedList;

import lettercraze.model.Letter;
import lettercraze.model.Level;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.model.board.Square;

public abstract class Game implements Cloneable {
	Board board;
	int levelID;
	LinkedList<Point> selected;
	int score;
	LinkedList<Move> pastMoves;
	Level level;
	LinkedList<String> pastWords;

	public Game(Level l, int id) {
		this.level = l;
		this.levelID = id;
		this.initialize();
	}
	
	public int getLevelID() {
		return levelID;
	}
	
	public Board getBoard() {
		return board;
	}

	public void undo() {
		if (pastMoves.isEmpty()) {
			return;
		}
		Game endState = pastMoves.pop().undoMove();
		this.board = endState.board;
		this.selected = endState.selected;
		this.score = endState.score;
		this.pastWords = endState.pastWords;
	}

	public abstract boolean gameOver();
	public abstract int scoreWord(String w);
	public abstract Object clone();

	public void repopulateBoard() {
		board.floatLetters();
		fillEmptySquares();
	}
	
	public void fillEmptySquares() {
		// fill in the board randomly
		for (int row=0; row<Board.SIZE; ++row) {
			for (int col=0; col < Board.SIZE; ++col) {
				if (board.isEmpty(new Point(row, col)))
				{
					board.setSquare(new Point(row, col),
							Square.makeSquare(Letter.genChar()));
				}
			}
		}
	}

	public int computeStars() {
		if (score >= level.threeStar) {
			return 3;
		} else if (score >= level.twoStar) {
			return 2;
		} else if (score >= level.oneStar) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public String getInfoString() {
		return "Puzzle";
	}

	public boolean isSelected(Point p) {
		for (Point x : selected) {
			if (x.row == p.row && x.col == p.col) {
				return true;
			}
		}
		return false;
	}
	
	public void initialize() {
		board = level.initBoard.clone();
		selected = new LinkedList<Point>();
		pastMoves = new LinkedList<Move>();
		pastWords = new LinkedList<String>();
		this.score = 0;
		this.repopulateBoard();
	}
	
	public void reset() {
		this.initialize();
	}

	public int getScore() {
		return score;
	}

	public LinkedList<String> getPastWords() {
		return pastWords;
	}
	
}
