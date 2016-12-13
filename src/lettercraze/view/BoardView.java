package lettercraze.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import lettercraze.model.Model;
import lettercraze.model.board.Board;
import lettercraze.model.board.Point;
import lettercraze.model.game.Game;

/**
 * This is the GUI boundary class for the board.
 * @authors Jack Pugmire, Matthew Lamare
 * @version 1.0
 */
@SuppressWarnings("serial")
public class BoardView extends JPanel {
	
	/**This static variable is the size of the buttons */
	public final static int BUTTON_SIZE = 32;
	
	Model m;
	BoardButton squares[][];
	
	/**
	 * This is the constructor for BoardView
	 * @param m The model object
	 */
	public BoardView(Model m) {
		super();
		this.setLayout(new GridLayout(6,6));
		this.m = m;
		squares = new BoardButton[6][6];
		for (int row = 0; row < Board.SIZE; ++row) {
			for (int col=0; col < Board.SIZE; ++col) {
				squares[row][col] = new BoardButton(new Point(row,col));
				squares[row][col].setOpaque(true);
				squares[row][col].setSize(BUTTON_SIZE, BUTTON_SIZE);
				squares[row][col].setFocusable(false);
				this.add(squares[row][col]);
			}
		}
		
		this.update();
	}
	
	/**
	 * This method ads an action listener to handle interaction
	 * @param l The actionListener object
	 */
	public void addActionListener(ActionListener l) {
		for (int row = 0; row < Board.SIZE; ++row) {
			for (int col=0; col < Board.SIZE; ++col) {
				squares[row][col].addActionListener(l);
			}
		}
	}
	
	/**
	 * This method updates the board part of the display.
	 */
	public void update() {
		for (int row = 0; row < Board.SIZE; ++row) {
			for (int col=0; col < Board.SIZE; ++col) {
				Point p = new Point(row, col);
				JButton b = squares[row][col];
				Game g = m.getCurrentGame();
				if (g.getBoard().isEmpty(p)) {
					b.setBackground(Color.WHITE);
					b.setText("");
				} else if (g.getBoard().isBlocked(p)) {
					b.setBackground(Color.BLACK);
					b.setText("");
				} else {
					if (g.isSelected(p))
						b.setBackground(Color.YELLOW);
					else
						b.setBackground(Color.WHITE);
					b.setFont(new Font("Arial", Font.BOLD, 22));
					char ch = g.getBoard().getLetter(p);
					if (ch == 'q')
						b.setText("qu");
					else
						b.setText("" + ch);
				}
			}
		}
	}
}
