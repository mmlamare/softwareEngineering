package lettercraze.controller.builder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import lettercraze.model.BuilderModel;
import lettercraze.model.board.Point;
import lettercraze.model.board.Square;
import lettercraze.view.BoardButton;
import lettercraze.view.BuilderView;

/**
 * This is the controller for right clicking to set a letter for building theme levels
 * @author Ruthenium
 *
 */
public class RightClickController implements MouseListener
{
	BuilderView app;
	Point loc;
	BuilderModel m;
	
	public RightClickController(BuilderModel m, BuilderView app, Point l) {
		this.m = m;
		this.app = app;
		this.loc = l;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON3)
		{
			String input = getUserCharacter("Enter a character:");
			while (input.length() != 1) {
				input = getUserCharacter("Enter exactly one character.");
			}
			
			m.getBoard().setSquare(loc, Square.makeSquare(input.charAt(0)));
			app.update();
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
	
	private String getUserCharacter(String prompt) {
		return JOptionPane.showInputDialog(prompt);
	}
}
