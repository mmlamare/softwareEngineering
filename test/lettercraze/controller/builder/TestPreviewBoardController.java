package lettercraze.controller.builder;

import java.awt.event.ActionEvent;

import junit.framework.TestCase;
import lettercraze.files.Resources;
import lettercraze.model.BuilderModel;
import lettercraze.view.BuilderView;

public class TestPreviewBoardController extends TestCase {
	BuilderModel m;
	BuilderView app;
	PreviewBoardController pbc;
	public void setUp() {
		Resources.loadResources();
		m = new BuilderModel();
		app = new BuilderView(m);
		pbc = new PreviewBoardController(m, app);
	}
	
	public void testLaunchPreview() {
		assertNull(pbc.lastInstance);
		pbc.actionPerformed(new ActionEvent(this, 0, ""));
		assertNotNull(pbc.lastInstance);
		pbc.lastInstance.dispose();
		pbc.lastInstance = null;
	}
	
	public void tearDown() {
		app.getFrame().dispose();
		m = null;
		app = null;
		pbc = null;
	}
}
