package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.Model;
import lettercraze.model.game.SelectSquareMove;
import lettercraze.view.BoardButton;
import lettercraze.view.LetterCraze;

/**
 * This Controller handles when a square is pressed on the Game Board
 * @author Ruthenium
 * @see GameView
 */
public class SelectionController implements ActionListener {
	Model m;
	LetterCraze app;

	/**
	 * Initializer requires Model and App that the GameView contains
	 * @param m
	 * @param app
	 */
	public SelectionController(Model m, LetterCraze app) {
		this.m = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() instanceof BoardButton) {
			BoardButton b = (BoardButton) ae.getSource();
			SelectSquareMove move = new SelectSquareMove(m.getCurrentGame(),
					b.getPoint());
			if (move.isValid()) {
				m.currentGame = move.doMove();
			}
			app.update();
		}
		else {
			// do nothing
		}
	}
}
