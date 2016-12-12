package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import lettercraze.view.BoardButton;
import lettercraze.view.BuilderView;

/**
 * This controller handles the Saving of a custom board in the builder app.
 * @see BuilderView
 */
public class PublishBoardController implements ActionListener
{
	JFrame frame;
	//File currentDir;
	String saveName;
	BoardButton squares[][];
	JRadioButton buttons[];
	
	/**
	 * Initializer requires the frame that the builder window belongs to.
	 * @param frame
	 */
	public PublishBoardController(JFrame frame, BoardButton squares[][], JRadioButton buttons[])
	{
		this.frame = frame;
		File currentDir = new File(System.getProperty("user.dir"));
		this.squares = squares;
		this.buttons = buttons;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		saveName = "board_state_" + getDate() + ".lcs";
		System.out.println("Publishing Board...");
		
		//Save all our stuff here given the gamepanel with all the squares
		ArrayList<String> saveData = new ArrayList<String>();
		for (int row=0; row<squares.length; row++)
		{
			String line = "";
			for (int col = 0; col < squares[row].length; col++)
			{
				
			}
			saveData.add(line);
		}

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
	
	private String getDate()
	{
		Date d = new Date();
		return d.getMonth() + "-" + d.getDate() + "-" + (d.getYear() - 100);
	}
}
