package lettercraze.controller.builder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import lettercraze.view.BoardButton;

/**
 * This is the controller for right clicking to set a letter for building theme levels
 * @author Ruthenium
 *
 */
public class RightClickController implements MouseListener
{
	BoardButton source;
	
	public RightClickController(BoardButton source)
	{
		this.source = source;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON3)
		{
			String input = getUserCharacter(source);
			
			//Point loc;
			source.setText(input);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	private String getUserCharacter(BoardButton source)
	{
		String message = "Please enter the character this button should have\n";
		message += "Please note only the first character will be used";
		String input = JOptionPane.showInputDialog(message);
		
		return input.substring(0, 1);
	}
}
