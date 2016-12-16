package lettercraze.controller.builder;

import java.awt.event.ActionEvent;

import junit.framework.TestCase;

import lettercraze.model.BuilderModel;
import lettercraze.view.BuilderView;

public class TestPublishBoardController extends TestCase {
	protected BuilderModel m = new BuilderModel();
	protected BuilderView app = new BuilderView(m);

	public void testPublishBoardController(){
		PublishBoardController cont = new PublishBoardController(m, app);
		ActionEvent e = new ActionEvent(app.getBtnSave(), java.awt.event.ActionEvent.ACTION_PERFORMED, "Some TExt");
		cont.actionPerformed(e);
		//still need to emulate the clicking
	}
}
