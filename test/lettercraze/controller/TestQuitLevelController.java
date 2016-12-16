package lettercraze.controller;

import java.awt.event.ActionEvent;

import junit.framework.TestCase;

import lettercraze.files.Data;
import lettercraze.files.Resources;
import lettercraze.model.Model;
import lettercraze.view.GameView;
import lettercraze.view.LetterCraze;

public class TestQuitLevelController extends TestCase {
	Model m;
	LetterCraze app;
	GameView gView;
	
	@Override
	protected void setUp() {
		Resources.loadResources();
		// Ensure that we have access to the game's data directory
		if (!Data.dataPathExists()) {
			Data.createDataPath();
		}
		
		m = new Model(Data.readScores());
		app = new  LetterCraze(m);
		m.loadLevelByID(0);
		gView = new GameView(m);				
	}
	
	public void testQuitGame(){
		setUp();
		QuitLevelController qLC = new QuitLevelController(m,app);
		assertTrue(m.isInGame());
		ActionEvent ae = new ActionEvent(gView.quitButton, java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");
		for(int i=0; i<100;i++){
			m.currentGame.scoreWord("test");
		}
		System.out.print("Here's our score hehexd");
		System.out.println(m.currentGame.getScore());
		
		qLC.actionPerformed(ae);
		assertFalse(m.isInGame());
		
	}
}

