package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class LoadBoardController implements ActionListener
{
	JFrame frame;
	
	public LoadBoardController(JFrame frame)
	{
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Loading Board...");
		
		//Load board somehow here
	}
}
