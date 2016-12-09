package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * This controller handles the loading of board data for the game view.
 * @see GameView
 */
public class LoadBoardController implements ActionListener
{
	JFrame frame;
	
	/**
	 * Initializer requires the JFrame that the board belongs to.
	 * @param frame
	 */
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
