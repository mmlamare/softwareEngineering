package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.BuilderModel;
import lettercraze.model.board.Point;
import lettercraze.view.BuilderView;

/**
 * This controller handles the toggling of a blocks state in the builder View
 * @author Ruthenium
 * @see BuilderView
 */
public class ToggleController implements ActionListener {
	BuilderModel m;
	BuilderView app;
	Point loc;

	/**
	 * @param m The builder entity
	 * @param app The Builder boundary
	 * @param l This is the point on the grid Boundary the the player selected
	 */
	public ToggleController(BuilderModel m, BuilderView app, Point loc) {
		this.m = m;
		this.app = app;
		this.loc = loc;
	}
	
	/**
	 * This takes in the mouse click and changed the square's
	 * status between selected/unselected
	 * Then it refreshes the display.
	 * @param e The action event object
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		m.toggleBlocked(loc);
		app.update();
	}

}
