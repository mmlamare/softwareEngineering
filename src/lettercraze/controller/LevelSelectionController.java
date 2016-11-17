package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.Model;
import lettercraze.view.LetterCraze;
import lettercraze.view.LevelButton;

public class LevelSelectionController implements ActionListener {
	Model m;
	LetterCraze app;

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
