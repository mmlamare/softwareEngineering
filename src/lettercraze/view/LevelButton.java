package lettercraze.view;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import lettercraze.Resources;

@SuppressWarnings("serial")
public class LevelButton extends JButton {
	public final int SIZE = 84;

	int levelID;
	int stars;
	boolean unlocked;

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
		this.setIcon(new ImageIcon(img));
	}

	public void setUnlocked(boolean u) {
		this.unlocked = u;
		this.setText(u ? "Lvl" + levelID : "locked");
	}

	public int getLevelID() {
		return levelID;
	}
}
