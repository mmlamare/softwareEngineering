package lettercraze.view;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;

import junit.framework.TestCase;
import lettercraze.controller.ToggleController;
import lettercraze.model.board.ModelBuilder;
import lettercraze.view.BuilderView;

public class TestBuilder extends TestCase
{
	BuilderView builderView; 
	
	protected void setUp() throws Exception
	{
		super.setUp();
		
		builderView = new BuilderView(new ModelBuilder());
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testBuilderView()
	{
		//view
	}
	
	public void testBoardButtons()
	{
		Robot r = null;
		try
		{
			r = new Robot();
		}
		catch (Exception e)
		{
		}
		
		BoardButton aButton = builderView.squares[0][0];
		
		aButton.doClick();
		assertEquals(aButton.getBackground(), Color.GRAY);
		
		/*MouseEvent click = new MouseEvent((aButton), MouseEvent.BUTTON3, System.currentTimeMillis(), 0, 10, 10, 1, false);
		ActionEvent clickAction = new ActionEvent(click.getSource(), click.getID(), click.paramString());
		
		ToggleController toggle = new ToggleController(aButton);
		
		toggle.actionPerformed(clickAction);
		
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("Clicked it");*/
	}
}
