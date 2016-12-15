package lettercraze.model.game;

import lettercraze.model.Level;

/**
 * The is the lightning game subclass. It is a kind of game,
 * so it extends the abstract Game class. It overrides the 
 * necessary methods for the specific implementation that 
 * lightning has. 
 * @author Ruthenium
 * @version 1.0
 */
public class LightningGame extends Game {
	int timeRemaining;
	static final int TOTAL_TIME = 120;

	/**
	 * Construct for a lightning level
	 * @param l The level object
	 * @param id The level number
	 */
	public LightningGame(Level l, int id) {
		super(l, id);
	}
	
	@Override
	public void initialize() {
		super.initialize();
		timeRemaining = TOTAL_TIME;
	}
	
	@Override
	public void reset() {
		super.initialize();
	}

	@Override
	public boolean gameOver() {
		return timeRemaining <= 0 || (level.wordLimit != 0 && pastWords.size() > level.wordLimit);
	}
	
	/**
	 * Decrements the time counter variable
	 */
	public void decrementTime() {
		timeRemaining -= 1;
	}

	@Override
	public int scoreWord(String w) {
		return 1;
	}

	public void undo() {
		// do nothing
		return;
	}

	@Override
	public String getInfoString() {
		return "Lightning | " + timeRemaining + " s";
	}

	public Object clone() {
		LightningGame result = new LightningGame(level, levelID);
		result.score = this.score;
		result.selected = this.selected;
		result.board = this.board;
		result.pastWords = this.pastWords;
		result.pastMoves = this.pastMoves;
		result.timeRemaining = this.timeRemaining;
		return result;
	}
}
