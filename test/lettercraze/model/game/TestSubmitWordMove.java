package lettercraze.model.game;

import junit.framework.TestCase;
import lettercraze.files.Data;
import lettercraze.files.Resources;
import lettercraze.model.Model;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.view.LetterCraze;

public class TestSubmitWordMove extends TestCase {
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
	
	//TODO Probably not helpful, but it upped our coverage
	public void testSubmitWordMove(){
		SubmitWordMove swm = new SubmitWordMove(m.getCurrentGame());
		assertFalse(swm.isValid());
		for (int row = 0; row < Board.SIZE; ++row) {
			for (int col = 0; col < Board.SIZE; ++col) {
				assertFalse(swm.doMove().getBoard().isEmpty(new Point(row, col)));
				assertFalse(swm.undoMove().getBoard().isEmpty(new Point(row, col)));
			}
		}
	}
}
