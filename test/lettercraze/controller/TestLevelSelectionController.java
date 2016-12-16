package lettercraze.controller;

import java.awt.event.ActionEvent;

import junit.framework.TestCase;
import lettercraze.files.Data;
import lettercraze.files.Resources;
import lettercraze.model.Model;
import lettercraze.view.LetterCraze;
import lettercraze.view.MenuView;

public class TestLevelSelectionController extends TestCase {
	
	Model m;
	LetterCraze app;
	MenuView mView;
	
	@Override
	protected void setUp() {
		Resources.loadResources();
		// Ensure that we have access to the game's data directory
		if (!Data.dataPathExists()) {
			Data.createDataPath();
		}
		
		m = new Model(Data.readScores());
		app = new  LetterCraze(m);
		mView = new MenuView(m, app);
				
	}
	
	@Override
	protected void tearDown() {
		app.dispose();
	}
	
	//Because all levels are unlocked, the first assert must be true
	public void testLockedLevel() {
		setUp();
		//LevelSelectionController lscon = new LevelSelectionController(m,app);
		assertTrue(m.isUnlocked(mView.getButton(8).getLevelID()));
		//ActionEvent ae = new ActionEvent(mView.getButton(8), java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");
		assertFalse(m.isInGame());
		tearDown();
	}
	
	public void testUnlockedLevel(){
		setUp();
		LevelSelectionController lscon = new LevelSelectionController(m,app);
		assertTrue(m.isUnlocked(mView.getButton(0).getLevelID()));
		ActionEvent ae = new ActionEvent(mView.getButton(0), java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");
		lscon.actionPerformed(ae);
		assertTrue(m.isInGame());
		assertEquals(0,m.currentGame.getLevelID());
	}
	
	public void testBadLevelSource(){
		setUp();
		LevelSelectionController lscon = new LevelSelectionController(m,app);
		assertTrue(m.isUnlocked(mView.getButton(0).getLevelID()));
		ActionEvent ae = new ActionEvent(mView.getButton(14), java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");
		lscon.actionPerformed(ae);
		assertTrue(m.isInGame());	
	}

	
}
