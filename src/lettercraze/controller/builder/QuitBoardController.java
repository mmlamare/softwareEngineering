package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This controller handles the Exiting of a custom board in the builder app.
 * @author Ruthenium
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
		
		boolean shouldExit = promptUser(frame, "Are you sure you want to quit?\nYour game may not be saved", "Do you really want to quit?");
		
		if (shouldExit)
		{
			exitGame();
		}
	}
	
	private boolean promptUser(JFrame frame, String message, String title)
	{
		int n = JOptionPane.showConfirmDialog(
			    frame,
			    message,
			    title,
			    JOptionPane.YES_NO_OPTION);
		
		return n == 0;
	}
	
	private void exitGame()
	{
		System.out.println("Closing board");
		frame.dispose();
	}
}
