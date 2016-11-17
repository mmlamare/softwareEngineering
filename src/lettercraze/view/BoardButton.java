package lettercraze.view;

import javax.swing.JButton;

import lettercraze.model.board.Point;

@SuppressWarnings("serial")
public class BoardButton extends JButton {
	Point loc;
	
	public BoardButton(Point loc) {
		super();
		this.loc = loc;
	}
	
	public Point getPoint() {
		return loc;
	}
}
