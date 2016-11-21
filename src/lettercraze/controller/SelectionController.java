package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.Model;
import lettercraze.model.game.SelectSquareMove;
import lettercraze.view.BoardButton;
import lettercraze.view.LetterCraze;

public class SelectionController implements ActionListener {
	Model m;
	LetterCraze app;

	public SelectionController(Model m, LetterCraze app) {
		this.m = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() instanceof BoardButton) {
			BoardButton b = (BoardButton) ae.getSource();
			SelectSquareMove move = new SelectSquareMove(b.getPoint());
			if (move.isValid(m.getCurrentGame())) {
				//m.currentGame = move.doMove();
				m.getCurrentGame().applyMove(move);
			}
			app.update();
		}
		else {
			// do nothing
		}
	}
}
