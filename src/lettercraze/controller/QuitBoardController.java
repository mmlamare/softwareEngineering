package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class QuitBoardController implements ActionListener
{
	JFrame frame;
	
	public QuitBoardController(JFrame frame)
	{
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Quitting Board without saving...");
		
		frame.dispose();
	}
}
