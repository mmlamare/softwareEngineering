package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * This controller handles the Exiting of a custom board in the builder app.
 * @see BuilderView
 */
public class QuitBoardController implements ActionListener
{
	JFrame frame;
	
	/**
	 * Initializer requires the frame that the builder window belongs to.
	 * @param frame
	 */
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
