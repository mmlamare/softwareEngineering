package lettercraze.model;

import java.util.Random;

import static lettercraze.model.LevelType.*;

import lettercraze.model.board.Board;
import lettercraze.model.game.Game;
import lettercraze.model.game.LightningGame;
import lettercraze.model.game.PuzzleGame;
import lettercraze.model.game.ThemeGame;

/**
 * Level is mostly a dumb data class, so I'd rather have the 
 * fields be public than filling up space with pointless accessors
 * @author Ruthenium
 * @version 1.0
 */
public class Level {
	/**The initial board for the level */
	public Board initBoard;
	/**The score threshold to achieve 1 star */
	public int oneStar;
	/**The score threshold to achieve 2 stars */
	public int twoStar;
	/**The score threshold to achieve 3 stars */
	public int threeStar;
	/**The level's level type*/
	public LevelType type;
	/**The word limit. 0 for non puzzle levels. */
	public int wordLimit = 0;
	/**The loaded dictionary for the level */
	public Dictionary words = null;
	/**The name of the level */
	public String name = "";

	/**
	 * This is the method for loading a level
	 * @param id The identifier for what type of level it is
	 * @param rng The random number generator for the game objects
	 * @return The game to be played
	 */
	public Game loadLevel(int id, Random rng) {
		Game result = null;
		if (type == PUZZLE) {
			result = new PuzzleGame(this, id, rng);
		} else if (type == LIGHTNING) {
			result = new LightningGame(this, id, rng);
		} else if (type == THEME) {
			result = new ThemeGame(this, id, rng);
		}
		return result;
	}

	/**
	 * TODO
	 * @param filename
	 */
	public void saveToFile(String filename) {
		// TODO
	}
}
