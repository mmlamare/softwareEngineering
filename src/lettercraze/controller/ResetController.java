package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.Model;
import lettercraze.view.LetterCraze;

/**
 * This controller is used to handle when the reset button is pressed in GameView.
 * @author Ruthenium
 * @see GameView
 */
public class ResetController implements ActionListener {
	Model m;
	LetterCraze app;

	/**
	 * Initializer requires the Model and app that the GameView contains.
	 * @param m
	 * @param app
	 */
	public ResetController(Model m, LetterCraze app) {
		this.m = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (m.isInGame()) {
			m.getCurrentGame().reset();
			app.update();
		}
	}

}
