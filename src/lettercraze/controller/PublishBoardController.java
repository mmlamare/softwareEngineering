package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class PublishBoardController implements ActionListener
{
	JFrame frame;
	
	public PublishBoardController(JFrame frame)
	{
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Publishing Board...");
		
		//Save all our stuff here given the gamepanel with all the squares
		
		//Exit game
		exitGame();
	}

	private void exitGame()
	{
		System.out.println("Closing board");
		frame.dispose();
	}
}
