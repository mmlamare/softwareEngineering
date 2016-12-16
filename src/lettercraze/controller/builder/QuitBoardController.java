package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lettercraze.view.BuilderView;

/**
 * This controller handles the Exiting of a custom board in the builder app.
 * @author Ruthenium
 * @see BuilderView
 */
public class QuitBoardController implements ActionListener
{
	BuilderView app;
	
	/**
	 * Initializer requires the frame that the builder window belongs to.
	 * @param frame
	 */
	public QuitBoardController(BuilderView app)
	{
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Quitting Board without saving...");
		
		boolean shouldExit = promptUser("Are you sure you want to quit?\nYour game may not be saved", "Do you really want to quit?");
		
		if (shouldExit)
		{
			app.getFrame().dispose();
			System.exit(0);
		}
	}
	
	private boolean promptUser(String message, String title)
	{
		int n = JOptionPane.showConfirmDialog(
			    app.getFrame(),
			    message,
			    title,
			    JOptionPane.YES_NO_OPTION);
		
		return n == 0;
	}
}
