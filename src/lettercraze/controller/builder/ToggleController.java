package lettercraze.controller.builder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.UIManager;

import lettercraze.model.BuilderModel;
import lettercraze.model.board.Point;
import lettercraze.view.BoardButton;
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
	 * Initializer requires the source button
	 * @param button
	 */
	public ToggleController(BuilderModel m, BuilderView app, Point loc) {
		this.m = m;
		this.app = app;
		this.loc = loc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		m.toggleBlocked(loc);
		app.update();
	}

}
