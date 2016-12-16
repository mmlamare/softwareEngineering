package lettercraze.controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import junit.framework.TestCase;
import lettercraze.files.Data;
import lettercraze.files.Resources;
import lettercraze.model.Model;
import lettercraze.model.board.Point;
import lettercraze.model.board.Square;
import lettercraze.view.GameView;
import lettercraze.view.LetterCraze;

public class TestSubmitController extends TestCase {
	Model m;
	LetterCraze app;
	GameView gView;
	Robot r;
	
	@Override
	protected void setUp() {
		Resources.loadResources();
		// Ensure that we have access to the game's data directory
		if (!Data.dataPathExists()) {
			Data.createDataPath();
		}
		
		m = new Model(Data.readScores());
		app = new  LetterCraze(m);	
		
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void tearDown(){
		app.dispose();
	}
	
	//Tests the Puzzle level reset
	public void testSubmitNothing(){
		
		m.loadLevelByID(0);
		assertTrue(m.isInGame());
		
		gView = new GameView(m);	
		assertTrue(m.getCurrentGame().getInfoString().contains("Puzzle"));
		r.keyPress(KeyEvent.VK_ENTER);
		assertEquals(m.getCurrentGame().getScore(), 0);
		r.keyRelease(KeyEvent.VK_ENTER);
		assertEquals(m.getCurrentGame().getScore(),0);
	}
	
	public void testSubmitJustOne(){
		
		Point p0 = new Point(0,0);


		
		m.loadLevelByID(0);
		assertTrue(m.isInGame());
		gView = new GameView(m);
			
		
		//Select first square
		ActionEvent ae = new ActionEvent(gView.boardView.getComponent(0), java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");

		SelectionController selecC = new SelectionController(m, app);		
		selecC.actionPerformed(ae);
		
		
		assertTrue(m.getCurrentGame().isSelected(p0));
		

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		assertEquals(m.currentGame.getScore(), 0);
		
	}
	
	
	public void testSubmitJustAnd(){
		m.loadLevelByID(0);
		assertTrue(m.isInGame());
		gView = new GameView(m);
		
		
		
		//Set
		Square sq0 = Square.makeSquare('h');
		Square sq1 = Square.makeSquare('e');

		Point p0 = new Point(0,0);
		Point p1 = new Point(0,1);
		Point p2 = new Point(0,2);
				
				
		m.currentGame.getBoard().setSquare(p0, sq0);
		m.currentGame.getBoard().setSquare(p1, sq1);
		m.currentGame.getBoard().setSquare(p2, sq0);
				
				
		
		
		
		//Select first square
		ActionEvent ae = new ActionEvent(gView.boardView.getComponent(0), java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");

		SelectionController selecC = new SelectionController(m, app);		
		selecC.actionPerformed(ae);
		
		//Select Second Square
		ae = new ActionEvent(gView.boardView.getComponent(1), java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");
			
		selecC.actionPerformed(ae);
			
		//Select third square
		ae = new ActionEvent(gView.boardView.getComponent(2), java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");

					
		selecC.actionPerformed(ae);
			
		assertTrue(m.getCurrentGame().isSelected(p0));
		assertTrue(m.getCurrentGame().isSelected(p1));
		assertTrue(m.getCurrentGame().isSelected(p2));
		
		assertEquals(m.getCurrentGame().getScore(), 0);
		
		
		
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		/*The thread that's scoring it updated after The assertEquals ran so
		 *this is just to slow the test down until that happens
		 */
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(m.currentGame.getScore(), 5);
		
	}

	
	
	
}