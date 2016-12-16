package lettercraze.controller.builder;

import java.awt.event.MouseEvent;

import junit.framework.TestCase;
import lettercraze.model.BuilderModel;
import lettercraze.model.board.Point;
import lettercraze.view.BuilderView;

public class TestRightClickController extends TestCase {
	BuilderModel m;
	BuilderView app;
	RightClickController rcc;
	public void setUp() {
		m = new BuilderModel();
		app = new BuilderView(m);
		rcc = new RightClickController(m, app, new Point(0,0));
	}
	
	public void testInvalidClick() {
		rcc.mouseClicked(new MouseEvent(app.getBtnSave(), 0, System.currentTimeMillis(),
				0, 0, 0, 1, false, MouseEvent.BUTTON3));
		assertTrue(m.getBoard().isEmpty(new Point(0,0)));
	}
	
	public void tearDown() {
		app.getFrame().dispose();
		m = null;
		app = null;
		rcc = null;
	}
}
