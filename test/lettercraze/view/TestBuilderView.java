package lettercraze.view;

import junit.framework.TestCase;
import lettercraze.model.ModelBuilder;

public class TestBuilderView extends TestCase {
	public void testBuilderView(){
		new BuilderView(new ModelBuilder());
	}
}
