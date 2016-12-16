package lettercraze.model.game;

import java.util.Random;

import junit.framework.TestCase;
import lettercraze.files.Data;
import lettercraze.model.Level;
import lettercraze.model.Model;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.view.LetterCraze;

public class TestPuzzleGame extends TestCase {
	Model m;
	LetterCraze app;

	@Override
	public void setUp() {
		// Load static resources from within the JAR file
		//Resources.loadResources();
		// Ensure that we have access to the game's data directory
		if (!Data.dataPathExists()) {
			Data.createDataPath();
		}

		m = new Model(Data.readScores());
		app = new LetterCraze(m);

		m.loadLevelByID(0);
		app.update();
	}

	@Override
	public void tearDown() {
		app.dispose();
	}
	
	public void testInGame() {
		assertTrue(m.isInGame());
	}

	public void testBoardContents() {
		// Ensure that the board has no empty squares
		for (int row = 0; row < Board.SIZE; ++row) {
			for (int col = 0; col < Board.SIZE; ++col) {
				assertFalse(m.getCurrentGame().getBoard().isEmpty(new Point(row, col)));
			}
		}
	}
}
