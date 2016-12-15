package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.Model;
import lettercraze.view.LetterCraze;
import lettercraze.view.LevelButton;

/**
 * This controller is used to handle the user selection of a level from the main menu 
 * @author Ruthenium
 * @see MenuView
 */
public class LevelSelectionController implements ActionListener {
	Model m;
	LetterCraze app;

	/**
	 * Initializer requires the model we are using and a reference to the root app.
	 * 
	 * @param m
	 * @param app
	 */
	public LevelSelectionController(Model m, LetterCraze app) {
		this.m = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() instanceof LevelButton) {
			LevelButton b = (LevelButton) ae.getSource();
			if (m.isUnlocked(b.getLevelID())) {
				m.loadLevelByID(b.getLevelID());
				app.update();
			}
			// do nothing if the level is locked
		}
	}
}
