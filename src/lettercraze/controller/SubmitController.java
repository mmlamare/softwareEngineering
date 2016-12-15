package lettercraze.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import lettercraze.model.Model;
import lettercraze.model.game.SubmitWordMove;
import lettercraze.view.LetterCraze;

/**
 * This class handles when the user has selected a word on the GameView and wants to submit it
 * @author Ruthenium
 * @see GameView
 */
public class SubmitController implements KeyListener {
	Model m;
	LetterCraze app;
	
	/**
	 * Initializer requires Model and App that the GameView contains
	 * @param m
	 * @param app
	 */
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
			SubmitWordMove move = new SubmitWordMove(m.currentGame);
			
			if (move.isValid()) {
				m.currentGame = move.doMove();
				app.update();
				// If the user has run out of words, let them know
				if (m.getCurrentGame().getPastWords().size() >=
						m.getCurrentGame().getLevel().wordLimit) {
					JOptionPane.showMessageDialog(app, "You've played all your words",
							"Word Limit Reached", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
	}

}
