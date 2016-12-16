package lettercraze.view;

import javax.swing.JFrame;

import junit.framework.TestCase;
import lettercraze.model.BuilderModel;

public class TestBuilderView extends TestCase {
	BuilderView app = new BuilderView(new BuilderModel());
	
	protected void setup(){
		
	}
	
	protected void teardown(){
		
	}
	public void testBuilderView(){
		assertTrue(app.getFrame() instanceof JFrame);
	}
}
