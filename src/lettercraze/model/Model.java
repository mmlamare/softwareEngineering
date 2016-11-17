package lettercraze.model;

import lettercraze.Resources;
import lettercraze.model.game.Game;

public class Model {
	static final int NUM_LEVELS = Resources.NUM_LEVELS;

	boolean inGame = false;
	public Game currentGame = null;
	int highScores[];
	boolean unlocked[];

	public Model(int highScores[]) {
		inGame = false;
		this.highScores = highScores;
		// to determine which levels are unlocked, we go up to the first one
		// with no stars and unlock that and everything before it, then lock
		// everything after
		this.unlocked = new boolean[NUM_LEVELS];
		int i = 0;
		for (; i < NUM_LEVELS; ++i) {
			unlocked[i] = true;
			if (highScores[i] == 0)
				break;
		}
		++i;
		for (; i < NUM_LEVELS; ++i) {
			unlocked[i] = false;
		}
	}
	
	public int[] getHighScores() {
		return highScores;
	}
	
	public int getHighScore(int id) {
		return highScores[id];
	}
	
	public void setHighScore(int id, int val) {
		highScores[id] = val;
	}
	
	public boolean isUnlocked(int id) {
		return unlocked[id];
	}
	
	public void unlock(int id) {
		unlocked[id] = true;
	}
	
	public boolean isInGame() {
		return inGame;
	}
	
	public Game getCurrentGame() {
		return currentGame;
	}
	
	//public void startGame() {
	//	inGame = true;
	//}
	
	public void exitLevel() {
		inGame = false;
		currentGame = null;
	}

	public void loadLevelByID(int id) {
		Level l = null;
		l = Resources.LEVELS[id];
		this.inGame = true;
		this.currentGame = l.loadLevel(id);
		this.currentGame.initialize();
	}
}
