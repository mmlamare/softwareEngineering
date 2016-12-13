package lettercraze.model.game;

import junit.framework.TestCase;
import lettercraze.files.Data;
import lettercraze.files.Resources;
import lettercraze.model.Model;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.view.LetterCraze;

public class TestLightningGame extends TestCase {
	Model m;
	LetterCraze app;

	@Override
	public void setUp() {
		// Load static resources from within the JAR file
		Resources.loadResources();
		// Ensure that we have access to the game's data directory
		if (!Data.dataPathExists()) {
			Data.createDataPath();
		}

		m = new Model(Data.readScores());
		app = new LetterCraze(m);

		//Make sure that level ID corresponds to the correct type of game
		m.loadLevelByID(1);
		app.update();
	}

	@Override
	public void tearDown() {
		app.dispose();
	}
	
	public void testInGame() {
		assertTrue(m.isInGame());
		//TODO statement below doesn't really work
		assertTrue(((LightningGame) m.getCurrentGame()).timeRemaining <= 120);
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
