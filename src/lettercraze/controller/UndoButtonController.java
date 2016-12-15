package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.Model;
import lettercraze.view.LetterCraze;

/**
 * This is the controller for the game's Undo Button. 
 * @author Jack
 * @version 1.0
 */
public class UndoButtonController implements ActionListener {
	Model m;
	LetterCraze app;
	
	/**
	 * @param m
	 * @param app
	 */
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
