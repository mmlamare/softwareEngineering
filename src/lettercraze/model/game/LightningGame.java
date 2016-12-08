package lettercraze.model.game;

import lettercraze.model.Level;

public class LightningGame extends Game {
	int timeRemaining;
	static final int TOTAL_TIME = 120;

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
		return "" + timeRemaining;
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
