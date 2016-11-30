package lettercraze.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import lettercraze.files.Data;
import lettercraze.model.Model;
import lettercraze.view.LetterCraze;

public class SaveStateController extends WindowAdapter {
	Model m;
	LetterCraze app;
	
	public SaveStateController(Model m, LetterCraze app) {
		this.m = m;
		this.app = app;
	}

	public void windowClosing (WindowEvent w) {
		// Save the scores and exit
		Data.writeScores(m.getHighScores());

		System.exit(0);
	}
}
