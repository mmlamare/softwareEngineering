package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import lettercraze.model.Model;
import lettercraze.model.game.LightningGame;
import lettercraze.view.LetterCraze;

/**
 * This is the controller class for the lightning level's 
 * count down clock
 * 
 * @authors Jack Pugmire, Matthew Lamare
 * @version 1.0
 */
public class LightningClockController implements ActionListener {
	/** Holds the model object*/
	Model m;
	/** Holds the application object*/
	LetterCraze app;
	
	/**
	 * This is the Constructor
	 * @param m Model
	 * @param app LetterCraze Application
	 * 
	 */
	public LightningClockController(Model m, LetterCraze app) {
		this.m = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (m.isInGame() && m.getCurrentGame() instanceof LightningGame) {
			LightningGame g = (LightningGame) m.getCurrentGame();
			if (!g.gameOver()) {
				g.decrementTime();
				app.update();
			} else {
				((javax.swing.Timer) (e.getSource())).stop();
				JOptionPane.showMessageDialog(app, "Time has run out",
				        "Time's up!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

}
