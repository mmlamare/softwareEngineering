package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.Model;
import lettercraze.view.LetterCraze;

public class ResetController implements ActionListener {
	Model m;
	LetterCraze app;

	public ResetController(Model m, LetterCraze app) {
		this.m = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (m.isInGame()) {
			m.getCurrentGame().initialize();
			app.update();
		}
	}

}
