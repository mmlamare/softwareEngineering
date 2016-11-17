package lettercraze.model;

import static lettercraze.model.LevelType.*;

import lettercraze.model.board.Board;
import lettercraze.model.game.Game;
import lettercraze.model.game.LightningGame;
import lettercraze.model.game.PuzzleGame;
import lettercraze.model.game.ThemeGame;

public class Level {
	// Level is mostly a dumb data class, so I'd rather have the fields be
	// public than filling up space with pointless accessors
	public Board initBoard;
	public int oneStar, twoStar, threeStar;
	public LevelType type;
	public int wordLimit = 0;
	public Dictionary words = null;
	public String name = "";

	public Game loadLevel(int id) {
		Game result = null;
		if (type == PUZZLE) {
			result = new PuzzleGame(this, id);
		} else if (type == LIGHTNING) {
			result = new LightningGame(this, id);
		} else if (type == THEME) {
			result = new ThemeGame(this, id);
		}
		return result;
	}

	public void saveToFile(String filename) {
		// TODO
	}
}
