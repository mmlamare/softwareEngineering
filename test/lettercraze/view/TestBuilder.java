package lettercraze.view;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;

import junit.framework.TestCase;
import lettercraze.model.board.ModelBuilder;

public class TestBuilder extends TestCase
{
	BuilderView builderView;
	Robot r;
	
	Runnable enterThread;
	Runnable letterThread;
	Runnable downArrowThread;
	Runnable slowEnterThread;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		
		r = null;
		try
		{
			r = new Robot();
		}
		catch (Exception e)
		{
		}
		
		builderView = new BuilderView(new ModelBuilder());
		
		enterThread = new Runnable(){
			public void run()
			{
				try
				{
					Thread.sleep(1500);
				} catch (Exception e){}
				System.out.println("Made it");
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			}
		};
		
		slowEnterThread = new Runnable(){
			public void run()
			{
				try
				{
					Thread.sleep(2000);
				} catch (Exception e){}
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			}
		};
		
		letterThread = new Runnable(){
			public void run()
			{
				try
				{
					Thread.sleep(1000);
				} catch (Exception e){}
				r.keyPress(KeyEvent.VK_A);
				r.keyRelease(KeyEvent.VK_A);
			}
		};
		
		downArrowThread = new Runnable(){
			public void run()
			{
				try
				{
					Thread.sleep(1000);
				} catch (Exception e){}
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}
		};
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
		BoardButton aButton = builderView.squares[0][0];
		
		aButton.doClick();
		assertEquals(aButton.getBackground(), Color.GRAY);
		
		JRadioButton themeButton = builderView.buttons[2];
		
		assertFalse(themeButton.isSelected());
		themeButton.doClick();
		assertTrue(themeButton.isSelected());
		
		JButton saveButton = builderView.btnSave;
		new Thread(letterThread).start();
		new Thread(enterThread).start();
		new Thread(slowEnterThread).start();
		saveButton.doClick();
		
		JButton loadButton = builderView.btnLoad;

		new Thread(downArrowThread).start();
		new Thread(enterThread).start();
		loadButton.doClick();
		
		JButton addWord = builderView.btnAddWord;
		new Thread(letterThread).start();
		new Thread(enterThread).start();
		addWord.doClick();
		
		JList list = builderView.list;
		list.setSelectedIndex(0);
		
		JButton removeWord = builderView.btnDelete;
		removeWord.doClick();
		
		JButton quitButton = builderView.btnQuit;
		
		new Thread(enterThread).start();
		quitButton.doClick();
	}
}
