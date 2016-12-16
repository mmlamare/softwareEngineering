package lettercraze.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import lettercraze.files.Data;
import lettercraze.model.Model;
import lettercraze.view.LetterCraze;

/**
 * This class handles when the save/exit button is pressed in GameView
 * @author Ruthenium
 * @see GameView
 */
public class SaveStateController extends WindowAdapter {
	Model m;
	LetterCraze app;
	
	/**
	 * Initializer requires Model and app that the GameView contains
	 * @param m
	 * @param app
	 */
	public SaveStateController(Model m, LetterCraze app) {
		this.m = m;
		this.app = app;
	}

	@Override
	/**
	 * Save user scores on exit
	 */
	public void windowClosing (WindowEvent w) {
		// Save the scores and exit
		Data.writeScores(m.getHighScores());

		System.exit(0);
	}
}
