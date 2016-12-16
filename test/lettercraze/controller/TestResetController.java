package lettercraze.controller;

import java.awt.event.ActionEvent;

import junit.framework.TestCase;
import lettercraze.files.Data;
import lettercraze.files.Resources;
import lettercraze.model.Model;
import lettercraze.model.board.Board;
import lettercraze.model.game.PuzzleGame;
import lettercraze.view.GameView;
import lettercraze.view.LetterCraze;

public class TestResetController extends TestCase {
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
	}
	
	@Override
	protected void tearDown(){
		app.dispose();
	}
	
	//Tests the Puzzle level reset
	public void testResetGameNonL(){
		ResetController rC = new ResetController(m,app);
		
		m.loadLevelByID(0);
		assertTrue(m.isInGame());
		
		gView = new GameView(m);	
		assertTrue(m.getCurrentGame().getInfoString().contains("Puzzle"));
		
		PuzzleGame game= (PuzzleGame) m.getCurrentGame();
		
		Board bInitial = m.currentGame.getBoard();
		
		m.currentGame.scoreWord("hello");
		
		ActionEvent ae = new ActionEvent(gView.resetButton, java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");
	
		
		rC.actionPerformed(ae);
		Board bAfterReset = m.currentGame.getBoard();
		assertNotSame(bInitial, bAfterReset);
		assertTrue(m.isInGame());
	}
	
	
	
	public void testResetGameLightning(){
		ResetController rC = new ResetController(m, app);
	
		
		//Check if loaded lightning level		
		m.loadLevelByID(1);
		gView = new GameView(m);	
		assertTrue(m.isInGame());
		assertTrue(m.getCurrentGame().getInfoString().contains("120"));
		
		
		Board bInit = m.currentGame.getBoard();
		
		//Reset Board
		ActionEvent ae = new ActionEvent(gView.resetButton, java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");
		rC.actionPerformed(ae);
		Board bFinal = m.getCurrentGame().getBoard();
		
		//Let clock count down 2 seconds
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Check if it ends on 119 or 118 even after board resets
		//118 or 117 is to account for run time delays
		assertNotSame(bFinal, bInit	);
		assertTrue(m.getCurrentGame().getInfoString().contains("118")||m.getCurrentGame().getInfoString().contains("119"));
	}
	
}
