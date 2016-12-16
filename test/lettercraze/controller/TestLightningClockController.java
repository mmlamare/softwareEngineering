package lettercraze.controller;

import java.awt.event.ActionEvent;

import junit.framework.TestCase;
import lettercraze.files.Data;
import lettercraze.files.Resources;
import lettercraze.model.Model;
import lettercraze.view.LetterCraze;
import lettercraze.view.MenuView;

public class TestLightningClockController extends TestCase {

	
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
	
	public void testLightningClockinNonLightning(){
		LightningClockController lCC = new LightningClockController(m, app);
		m.loadLevelByID(0);
		ActionEvent ae = new ActionEvent(mView.getButton(0), java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");
		lCC.actionPerformed(ae);
		assertNotSame("120", m.getCurrentGame().getInfoString());
	}
	
	public void testRealLightningClock(){
		LightningClockController lCC = new LightningClockController(m, app);
		m.loadLevelByID(1);
		ActionEvent ae = new ActionEvent(mView.getButton(0), java.awt.event.ActionEvent.ACTION_PERFORMED, "HOWDY PARTNER");
		lCC.actionPerformed(ae);
		assertEquals(m.getCurrentGame().getInfoString(), "Lightning | 120 s");
	}
	
}
