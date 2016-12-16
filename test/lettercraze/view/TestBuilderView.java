package lettercraze.view;

import javax.swing.JFrame;

import junit.framework.TestCase;
import lettercraze.model.BuilderModel;

public class TestBuilderView extends TestCase {
	BuilderView app;
	
	protected void setup(){
		app = new BuilderView(new BuilderModel());
	}
	
	protected void teardown(){
		
	}
	public void testBuilderView(){
		assertTrue(app.getFrame() instanceof JFrame);
	}
}
