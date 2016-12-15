package lettercraze.view;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import lettercraze.files.Resources;

/**
 * This is the GUI boundary object of the main menu button that
 * the player selects to play that level if it is availible. If
 * it is not unlocked, it will display a locked image, and will
 * not respond to mouse inputs.
 * @author Ruthenium
 * @version 1.0
 */
@SuppressWarnings("serial")
public class LevelButton extends JButton {
	/**Static variable for the size of the button */
	public final int SIZE = 84;

	int levelID;
	int stars;
	boolean unlocked;

	/**
	 * Constructor for a level button
	 * @param levelID The level number
	 * @param stars The number of stars that have been previously
	 * earned playing this level
	 * @param unlocked The locked/unlocked status of the level
	 */
	public LevelButton(int levelID, int stars, boolean unlocked) {
		super();
		this.levelID = levelID;
		this.setStars(stars);
		this.setUnlocked(unlocked);
		this.setFocusable(false);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
		this.setPreferredSize(new Dimension(SIZE,SIZE));
	}

	/**
	 * The method for setting the visibility of the number of
	 * stars earned for a level
	 * @param stars The number of stars to display
	 */
	public void setStars(int stars) {
		this.stars = stars;

		Image img = null;
		switch (stars) {
		case 0:
			img = Resources.LB0;
			break;
		case 1:
			img = Resources.LB1;
			break;
		case 2:
			img = Resources.LB2;
			break;
		case 3:
			img = Resources.LB3;
			break;
		}
		//TODO default case
		this.setIcon(new ImageIcon(img));
	}

	/**
	 * Method to set a level as unlocked
	 * @param u The boolean input: True -> Unlocked, 
	 * False -> still locked
	 */
	public void setUnlocked(boolean u) {
		this.unlocked = u;
		this.setText(u ? "Lvl" + levelID : "locked");
	}

	/**
	 * Level ID getter
	 * @return The level number
	 */
	public int getLevelID() {
		return levelID;
	}
}
