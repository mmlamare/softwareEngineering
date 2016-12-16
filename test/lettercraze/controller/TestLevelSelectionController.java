package lettercraze.controller;

import java.awt.event.ActionEvent;

import junit.framework.TestCase;
import lettercraze.files.Data;
import lettercraze.files.Resources;
import lettercraze.model.Model;
import lettercraze.view.LetterCraze;
import lettercraze.view.LevelButton;

public class TestLevelSelectionController extends TestCase {
	
	Model m;
	LetterCraze app;
	
	@Override
	protected void setUp() {
		Resources.loadResources();
		// Ensure that we have access to the game's data directory
		if (!Data.dataPathExists()) {
			Data.createDataPath();
		}
		
		m = new Model(Data.readScores());
		app = new  LetterCraze(m);
	}
	
	@Override
	protected void tearDown() {
		app.dispose();
	}
	
	public void testUnlockedLevel(){
		assertTrue(m.isUnlocked(0));
		assertFalse(m.isInGame());
		LevelSelectionController lscon = new LevelSelectionController(m,app);
		assertTrue(m.isUnlocked(0));
		ActionEvent ae = new ActionEvent(new LevelButton(0,0,true), java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");
		lscon.actionPerformed(ae);
		assertTrue(m.isInGame());
		assertEquals(0,m.currentGame.getLevelID());
	}
}
