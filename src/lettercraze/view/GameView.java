package lettercraze.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import lettercraze.files.Resources;
import lettercraze.model.Model;
import lettercraze.model.game.Game;

/**
 * This is the high level GUI object for a Lettercraze game
 * @author Ruthenium
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GameView extends JPanel {
	Model m;

	
	// The Game View is a convenient container, but only one will ever exist at
	// a time and it will always be owned by LetterCraze. As a result, we make
	// its components public to make our code neater.
	/** The board GUI Object */
	public BoardView boardView;
	/** The infoBox GUI Object */
	public JLabel infoBox;
	/** 
	 * The GUI Object for displaying the number of stars
	 * achieved
	 * */
	public JLabel starDisplay;
	/** The quit button GUI Object */
	public JButton quitButton;
	/** The undo button GUI Object */
	public JButton undoButton;
	/** The reset button GUI Object */
	public JButton resetButton;
	/** The played words pane GUI Object */
	public JScrollPane wordsPane;
	/** The words played list GUI Object */
	public JList<String> wordsPlayed;
	/** The score text GUI Object */
	public JLabel scoreLabel;
	
	/**
	 * The constructor for the gameView
	 * @param m The model
	 */
	public GameView(Model m) {
		super();
		
		this.m = m;
		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
		gbl.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
		this.setLayout(gbl);

		boardView = new BoardView(m);
		infoBox = new JLabel(m.currentGame.getInfoString());
		infoBox.setFocusable(false);
		starDisplay = new JLabel();
		starDisplay.setFocusable(false);
		quitButton = new JButton("quit");
		quitButton.setFocusable(false);
		undoButton = new JButton("undo");
		undoButton.setFocusable(false);
		resetButton = new JButton("reset");
		resetButton.setFocusable(false);
		wordsPlayed = new JList<String>();
		wordsPlayed.setFocusable(false);
		wordsPane = new JScrollPane(wordsPlayed);
		wordsPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		wordsPane.setPreferredSize(new Dimension(0, 100));
		scoreLabel = new JLabel();
		scoreLabel.setText("Score: " + m.getCurrentGame().getScore());

		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(3, 3, 3, 3);
		gc.gridheight = 1;
		gc.gridwidth = 2;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		
		gc.gridx = 6;
		gc.gridy = 0;
		this.add(infoBox,gc);
		
		gc.gridy = 1;
		this.add(resetButton,gc);

		gc.gridy = 2;
		this.add(undoButton,gc);

		gc.gridy = 3;
		gc.gridheight = 6;
		this.add(wordsPane,gc);

		gc.gridy = 9;
		gc.gridheight = 1;
		this.add(quitButton,gc);

		gc.gridwidth = 1;
		gc.gridx = 0;
		this.add(scoreLabel,gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 5;
		gc.gridheight = 10;
		this.add(boardView, gc);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.gridheight=0;
		this.add(starDisplay, gc);
	}
	
	/**
	 * This method updates the number of stars in the display
	 * when the user has earned more stars, or has reverted a
	 * more, and lowered his score to loose a star.
	 */
	public void updateStarDisplay() {
		int stars = m.currentGame.computeStars();
		Image img = null;
		switch (stars) {
		case 0:
			img = Resources.SI0;
			break;
		case 1:
			img = Resources.SI1;
			break;
		case 2:
			img = Resources.SI2;
			break;
		case 3:
			img = Resources.SI3;
			break;
		}
		this.starDisplay.setIcon(new ImageIcon(img));
	}
	
	/**
	 * Refresh all of the Game GUI's 
	 */
	public void update() {
		boardView.update();
		this.updateStarDisplay();
		Game g = m.getCurrentGame();
		infoBox.setText(m.currentGame.getInfoString());
		scoreLabel.setText("Score: " + g.getScore());
		wordsPlayed.setListData(g.getPastWords().toArray(
				new String[g.getPastWords().size()]));
	}
}
