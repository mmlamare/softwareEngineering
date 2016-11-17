package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.Resources;
import lettercraze.model.Model;
import lettercraze.model.game.Game;
import lettercraze.view.LetterCraze;

public class QuitLevelController implements ActionListener {
	Model m;
	LetterCraze app;
	
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
