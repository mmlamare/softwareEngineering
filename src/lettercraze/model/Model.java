package lettercraze.model;

import java.util.Random;

import lettercraze.files.Resources;
import lettercraze.model.game.Game;

/**
 * The main Entity class for the LetterCraze game
 * @author Ruthenium
 * @version 1.0
 */
public class Model {
	static final int NUM_LEVELS = Resources.NUM_LEVELS;

	boolean inGame = false;
	/** The game */
	public Game currentGame = null;
	int highScores[];
	boolean unlocked[];
	
	/** The random number generator is maintained by the model in order to allow
	 * consistent letter generation for testing. */
	Random rng;

	/**
	 * Constructor which uses the current time in milliseconds as the seed
	 * @param highScores The previous high scores
	 */
	public Model(int highScores[]) {
		this(highScores, (int)System.currentTimeMillis());
	}

	/**
	 * Constructor
	 * @param highScores High scores retrieved
	 * @param seed The seed for the random number generator
	 */
	public Model(int highScores[], int seed) {
		inGame = false;
		this.highScores = highScores;

		rng = new Random(seed);
		// since the game is sometimes run in preview mode with no high scores,
		// check if highScores is null and return if it is.
		if (highScores == null) return;

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

	/**
	 * Getter for all the highScores field
	 * @return The all the stored high scores
	 */
	public int[] getHighScores() {
		return highScores;
	}

	/**
	 * Returns a specific rank high score
	 * @param id Specifies which high score to return
	 * @return The an element of the highScores array
	 */
	public int getHighScore(int id) {
		return highScores[id];
	}

	/**
	 * Sets a new high score
	 * @param id Array ID
	 * @param val New high score
	 */
	public void setHighScore(int id, int val) {
		highScores[id] = val;
	}

	/**
	 * Returns the unlocked/locked status of a level as T/F
	 * @param id The Level ID
	 * @return Boolean T/F if the level is unlocked
	 */
	public boolean isUnlocked(int id) {
		return unlocked[id];
	}

	/**
	 * Unlocks a level from inputed level id
	 * @param id Level identification number
	 */
	public void unlock(int id) {
		unlocked[id] = true;
	}

	/**
	 * Returns the status of if the level is currently 
	 * being played
	 * @return T/F if the level is available to play this 
	 * current game
	 */
	public boolean isInGame() {
		return inGame;
	}

	/**
	 * Returns the currently being played game object
	 * @return Currently being played game object
	 */
	public Game getCurrentGame() {
		return currentGame;
	}

	/**
	 * Sets the necessary fields for signaling that the level
	 * has been exited.
	 */
	public void exitLevel() {
		inGame = false;
		currentGame = null;
	}

	/**
	 * Load's a level by a given number
	 * @param id The level number
	 */
	public void loadLevelByID(int id) {
		Level l = null;
		l = Resources.LEVELS[id];
		if (l == null) {
			System.err.println("No level for ID: " + id);
		} else {
			this.inGame = true;
			this.currentGame = l.loadLevel(id, rng);
			this.currentGame.initialize();
		}
	}
	
	/**
	 * Load a given Level
	 * @param l The level to load
	 */
	public void loadLevel(Level l) {
		this.inGame = true;
		this.currentGame = l.loadLevel(0, rng);
		this.currentGame.initialize();
	}
}
