package lettercraze.model.game;

import java.util.LinkedList;
import java.util.Random;

import lettercraze.model.Letter;
import lettercraze.model.Level;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.model.board.Square;

/**
 * This is the abstract game class. 
 * Puzzle, Lightning, and theme game level will be instanteated
 * from it.
 * @author Ruthenium
 * @version 1.0
 */
public abstract class Game implements Cloneable {
	Board board;
	int levelID;
	LinkedList<Point> selected;
	int score;
	LinkedList<Move> pastMoves;
	Level level;
	LinkedList<String> pastWords;
	/** the rng for repopulating the board. same as the rng in the model */
	Random rng;

	/**
	 * This is the Game constructor with the super parameters
	 * @param l The Level
	 * @param id The level ID number
	 */
	public Game(Level l, int id, Random rng) {
		this.level = l;
		this.levelID = id;
		this.rng = rng;
		this.initialize();
	}

	/**
	 * A getter for the level id number
	 * @return level id number
	 */
	public int getLevelID() {
		return levelID;
	}

	/**
	 * A getter for the board
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * The method for undoing moves on the board
	 */
	public void undo() {
		if (gameOver()) {
			return;
		}

		if (pastMoves.isEmpty()) {
			return;
		}
		Game endState = pastMoves.pop().undoMove();
		
		// do automagic undos
		while (!pastMoves.isEmpty() && pastMoves.peek().automagicUndo()) {
			endState = pastMoves.pop().undoMove();
		}
		
		this.board = endState.board;
		this.selected = endState.selected;
		this.score = endState.score;
		this.pastWords = endState.pastWords;
	}

	/**
	 * Abstract method of whether the game is over.
	 * Will be overridden by the three subclasses, as they all
	 * have different conditions for whether the game is over.
	 * @return T/F if the game is over
	 */
	public abstract boolean gameOver();

	/**
	 * Returns the score of a particular word. In lightning mode,
	 * all words are the same. In Puzzle and theme modes, the
	 * score of the word depends on the rarity of the letters
	 * and length of the word.
	 * @param w The word you want to score
	 * @return The score of inputed word
	 */
	public abstract int scoreWord(String w);

	public abstract Object clone();

	/**
	 * Floats existing letters up to fill in the gaps, and 
	 * re-populates the empty squares at the bottom.
	 */
	public void repopulateBoard() {
		board.floatLetters();
		fillEmptySquares();
	}

	/**
	 * Fills in the board's empty squares randomly
	 */
	public void fillEmptySquares() {
		for (int row=0; row<Board.SIZE; ++row) {
			for (int col=0; col < Board.SIZE; ++col) {
				if (board.isEmpty(new Point(row, col)))
				{
					board.setSquare(new Point(row, col),
							Square.makeSquare(Letter.genChar(this.rng)));
				}
			}
		}
	}

	/**
	 * Determines the number of stars the player has earned
	 * @return The number of stars the player has earned
	 */
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

	/**
	 * Gives the information string for the top corner of the view
	 * @return empty string by default, but should be overridden by child classes
	 */
	public String getInfoString() {
		return "";
	}

	/**
	 * Returns that status of if a square is selected
	 * @param p The point to control which square to consider
	 * @return T/F if the square is selected
	 */
	public boolean isSelected(Point p) {
		for (Point x : selected) {
			if (x.row == p.row && x.col == p.col) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Initialize a board at the beginning of a game.
	 */
	public void initialize() {
		board = level.initBoard.clone();
		selected = new LinkedList<Point>();
		pastMoves = new LinkedList<Move>();
		pastWords = new LinkedList<String>();
		this.score = 0;
		this.repopulateBoard();
	}

	/**
	 * Resets a board by re-initializing it.
	 */
	public void reset() {
		this.initialize();
	}

	/**
	 * A getter for the game's score
	 * @return The game's score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * A getter for the words that have been played
	 * @return The list of words that have been played
	 */
	public LinkedList<String> getPastWords() {
		return pastWords;
	}
}