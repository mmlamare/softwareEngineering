package lettercraze.view;

import javax.swing.JButton;

import lettercraze.model.board.Point;

/**
 * This is the Board Buttons' boundary GUI object
 * @author Jack Pugmire
 * @version 1.0
 */
@SuppressWarnings("serial") //TODO Jack, is this OK?
public class BoardButton extends JButton {
	Point loc;
	
	/**
	 * This is the constructor for a Board Button
	 * @param loc The location of the board
	 */
	public BoardButton(Point loc) {
		super();
		this.loc = loc;
	}
	
	/**
	 * This getter returns the position of the board button
	 * @return the position of the board button
	 */
	public Point getPoint() {
		return loc;
	}
}
