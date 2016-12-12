package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lettercraze.view.BoardButton;

/**
 * This controller handles the Saving of a custom board in the builder app.
 * @see BuilderView
 */
public class PublishBoardController implements ActionListener
{
	JFrame frame;
	
	/**
	 * Initializer requires the frame that the builder window belongs to.
	 * @param frame
	 */
	public PublishBoardController(JFrame frame, BoardButton squares[][])
	{
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Publishing Board...");
		
		//Save all our stuff here given the gamepanel with all the squares

		showMessage(frame, "Board saved!");
		//Exit game
		//exitGame();
	}
	
	private void showMessage(JFrame frame, String message)
	{
		JOptionPane.showMessageDialog(frame, message);
	}

	private void exitGame()
	{
		System.out.println("Closing board");
		frame.dispose();
	}
}
