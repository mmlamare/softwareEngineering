package lettercraze.model.game;

import junit.framework.TestCase;

import lettercraze.files.Data;
import lettercraze.files.Resources;
import lettercraze.model.Model;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.view.LetterCraze;

public class TestSelectSquareMove extends TestCase {
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

		m.loadLevelByID(0);
		app.update();
	}

	@Override
	public void tearDown() {
		app.dispose();
	}
	
	//a 5x5 board
	public void testSelectSquareMove(){
		for (int row = 0; row < 5; ++row) {
			for (int col = 0; col < 5; ++col) {
				SelectSquareMove ssm = new SelectSquareMove(m.getCurrentGame(), new Point(row, col));
				ssm.doMove();
				ssm.undoMove();
				assertTrue(ssm.isValid());
			}
		}
	}
}
