package lettercraze.controller.builder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import lettercraze.model.BuilderModel;
import lettercraze.model.LevelType;
import lettercraze.model.board.Point;
import lettercraze.model.board.Square;
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
	
	/**
	 * 
	 * @param m The builder entity
	 * @param app The Builder boundary
	 * @param l This is the point on the grid Boundary the the player selected
	 */
	public RightClickController(BuilderModel m, BuilderView app, Point l) {
		this.m = m;
		this.app = app;
		this.loc = l;
	}
	
	/**
	 * This takes in the mouse click and changed the square's
	 * status to having a hard coded letter. Then it prompts the 
	 * User to enter a character. Character is displayed
	 * Then it refreshes the display.
	 * @param e The action event object
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON3)
		{
			// Ensure we're in theme mode
			if (m.getLevel().type == LevelType.THEME) {
				String input = getUserCharacter("Enter a character:");
				while (input.length() != 1) {
					input = getUserCharacter("Enter exactly one character.");
				}

				m.getBoard().setSquare(loc, Square.makeSquare(input.charAt(0)));
				app.update();
			}
		}
	}

	/** Unused interface method */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	/** Unused interface method */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	/** Unused interface method */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	/** Unused interface method */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	/** Unused interface method */
	private String getUserCharacter(String prompt) {
		return JOptionPane.showInputDialog(prompt);
	}
}
