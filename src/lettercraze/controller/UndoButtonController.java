package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.Model;
import lettercraze.view.LetterCraze;

public class UndoButtonController implements ActionListener {
	Model m;
	LetterCraze app;
	
	public UndoButtonController(Model m, LetterCraze app) {
		this.m = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		m.getCurrentGame().undo();
		app.update();
	}
}
