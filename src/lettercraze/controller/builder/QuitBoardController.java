package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	 * @param app The builder boundary GUI
	 */
	public QuitBoardController(BuilderView app)
	{
		this.app = app;
	}
	
	/**
	 * Quits the board without saving any unsaved changes
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{	
		boolean shouldExit = promptUser("Are you sure you want to quit?\nYour game may not be saved", "Do you really want to quit?");
		
		if (shouldExit)
		{
			app.getFrame().dispose();
			System.exit(0);
		}
	}
	
	/**
	 * Prompts the user to confirm quitting
	 * @param message The message to show the user
	 * @param title The title of the pop-up window
	 * @return True if the user said yes
	 */
	private boolean promptUser(String message, String title)
	{
		int n = JOptionPane.showConfirmDialog(
			    app.getFrame(),
			    message,
			    title,
			    JOptionPane.YES_NO_OPTION);
		
		return n == JOptionPane.YES_OPTION;
	}
}
