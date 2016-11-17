package lettercraze.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lettercraze.model.Model;

@SuppressWarnings("serial")
public class MenuView extends JPanel {
	Model m;
	LetterCraze app;
	LevelButton buttons[];

	static final int NUM_LEVELS = 15;

	public MenuView(Model m, LetterCraze app) {
		super();
		this.m = m;
		this.app = app;
		buttons = new LevelButton[NUM_LEVELS];

		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(8,8,8,8);
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.anchor = GridBagConstraints.CENTER;

		int rowOffset=1;
		int colOffset=3;
		int idx = 0;
		for (int col=colOffset; col<5 + colOffset; ++col ) {
			for (int row=rowOffset; row<3 + rowOffset; ++row) {
				gc.gridx = col;
				gc.gridy = row;
				buttons[idx] = new LevelButton(idx,m.getHighScore(idx),
						m.isUnlocked(idx));
				this.add(buttons[idx],gc);
				++idx;
			}
		}
		
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 1;
		this.add(new JLabel("Puzzle"),gc);
		gc.gridy = 2;
		this.add(new JLabel("Lightning"),gc);
		gc.gridy = 3;
		this.add(new JLabel("Theme"),gc);

		gc.gridwidth = 7;
		gc.gridx = 0;
		gc.gridy = 0;
		this.add(new JLabel("WELCOME TO LETTERCRAZE!"),gc);
	}
	
	public void addActionListener(ActionListener l) {
		for (int i =0; i < NUM_LEVELS; ++i) {
			buttons[i].addActionListener(l);
		}
	}
	
	public void update() {
		for (int i = 0; i < NUM_LEVELS; ++i) {
			buttons[i].setStars(m.getHighScore(i));
			buttons[i].setUnlocked(m.isUnlocked(i));
		}
	}
}
