package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.Model;
import lettercraze.model.game.LightningGame;
import lettercraze.view.LetterCraze;

public class LightningClockController implements ActionListener {
	Model m;
	LetterCraze app;
	
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
			}
		}
	}

}
