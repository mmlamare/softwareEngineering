package lettercraze.view;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import lettercraze.Resources;
import lettercraze.controller.LevelSelectionController;
import lettercraze.controller.LightningClockController;
import lettercraze.controller.QuitLevelController;
import lettercraze.controller.ResetController;
import lettercraze.controller.SaveStateController;
import lettercraze.controller.SelectionController;
import lettercraze.controller.SubmitController;
import lettercraze.controller.UndoButtonController;
import lettercraze.model.Model;

@SuppressWarnings("serial")
public class LetterCraze extends JFrame {
	public static final int WIDTH=600;
	public static final int HEIGHT=400;
	public static final int TICK_TIME=1000;
	public static final int SPLASH_TIME=4000;

	Model m;
	GameView gameView;
	MenuView menuView;

	public LetterCraze(Model m) {
		super();
		this.m = m;
		this.setSize(WIDTH,HEIGHT);
		this.setResizable(false);

		this.addKeyListener(new SubmitController(m, this));
		this.addWindowListener(new SaveStateController(m,this));
	}
	
	public void run() {
		this.showSplash();
		this.setVisible(true);
		LetterCraze self = this;
		Timer splashTimer = new Timer(SPLASH_TIME, (ActionEvent ae) -> {
			System.out.print("done: " + (this == self));
			getContentPane().removeAll();
			update();
		});
		splashTimer.setRepeats(false);
		splashTimer.start();
	}
	
	public void showSplash() {
		this.add(new JLabel(new ImageIcon(Resources.SPLASH)));
	}

	public void initializeGame() {
		if (menuView != null) {
			this.remove(menuView);
			menuView = null;
		}

		gameView = new GameView(m);
		gameView.boardView.addActionListener(new SelectionController(m,this));
		gameView.undoButton.addActionListener(new UndoButtonController(m,this));
		gameView.resetButton.addActionListener(new ResetController(m,this));
		gameView.quitButton.addActionListener(new QuitLevelController(m,this));
		this.add(gameView);
		this.revalidate();

		// Create a timer if we are in Lightning mode
		if (m.getCurrentGame() instanceof lettercraze.model.game.LightningGame) {
			new Timer(TICK_TIME, new LightningClockController(m, this)).start();
		}
	}
	
	public void initializeMenu() {
		if (gameView != null) {
			this.remove(gameView);
			gameView = null;
		}

		menuView = new MenuView(m, this);
		menuView.addActionListener(new LevelSelectionController(m,this));
		this.add(menuView);
		this.revalidate();
	}

	public void update() {
		if (m.isInGame()) {
			if(gameView == null) {
				this.initializeGame();
			}
			this.gameView.update();
		} else {
			if (menuView == null) {
				initializeMenu();
			}
			menuView.update();
		}
		this.repaint();
	}

	public void initialize() {
		this.initializeMenu();
		this.setVisible(true);
	}
}
