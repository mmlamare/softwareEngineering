package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.files.Resources;
import lettercraze.model.Model;
import lettercraze.model.game.Game;
import lettercraze.view.LetterCraze;

/**
 * This controller allows the user to exit a level when the exit button is clicked in GameView
 * @see GameView
 * @author Ruthenium
 * @version 1.0
 */
public class QuitLevelController implements ActionListener {
	Model m;
	LetterCraze app;
	
	/**
	 * This is the Constructor
	 * @param m Model
	 * @param app Application
	 */
	public QuitLevelController(Model m, LetterCraze app) {
		this.m = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Game g= m.getCurrentGame();
		int id = g.getLevelID();
		if (g.computeStars() > m.getHighScore(id))  {
			// first, update the new score:
			m.setHighScore(id, g.computeStars());
			// then, if there's a next level, make sure it's unlocked
			if (id < Resources.NUM_LEVELS - 1) {
				m.unlock(id + 1);
			}
		}
		m.exitLevel();
		app.update();
	}

}
