package lettercraze.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import lettercraze.model.Model;
import lettercraze.model.game.SubmitWordMove;
import lettercraze.view.LetterCraze;

public class SubmitController implements KeyListener {
	Model m;
	LetterCraze app;
	
	public SubmitController(Model m, LetterCraze app) {
		this.m = m;
		this.app = app;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (! m.isInGame()) return;
		// This is a submit word move
		if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) {
			SubmitWordMove move = new SubmitWordMove();

			if (move.isValid(m.getCurrentGame())) {
				m.getCurrentGame().applyMove(move);
				app.update();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
