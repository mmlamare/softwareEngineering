package lettercraze.controller.builder;

import junit.framework.TestCase;
import lettercraze.model.board.ModelBuilder;
import lettercraze.view.BuilderView;

public class TestBuilder extends TestCase
{
	BuilderView view; 
	
	protected void setUp() throws Exception
	{
		super.setUp();
		
		view = new BuilderView(new ModelBuilder());
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	//public void test
}
