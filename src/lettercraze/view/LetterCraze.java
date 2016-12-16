package lettercraze.view;

import javax.swing.JFrame;
import javax.swing.Timer;

import lettercraze.controller.LevelSelectionController;
import lettercraze.controller.LightningClockController;
import lettercraze.controller.QuitLevelController;
import lettercraze.controller.ResetController;
import lettercraze.controller.SaveStateController;
import lettercraze.controller.SelectionController;
import lettercraze.controller.SubmitController;
import lettercraze.controller.UndoButtonController;
import lettercraze.model.Level;
import lettercraze.model.Model;

/**
 * This is the highest level GUI class for the entire game
 * @author Ruthenium
 * @version 1.2
 */
@SuppressWarnings("serial")
public class LetterCraze extends JFrame {
	/** This static variable is the width of the window */
	public static final int WIDTH=600;
	/** This static variable is the height of the window */
	public static final int HEIGHT=400;
	/** 
	 * This static variable number of ticks for the real
	 * time clock
	 * */
	public static final int TICK_TIME=1000;

	Model m;
	GameView gameView;
	MenuView menuView;
	boolean preview = false;

	/** This constructor is used to create a preview window. It starts out in
	 * the provided level and exits when the user leaves that level.
	 */
	private LetterCraze() {
		
	}
	
	public boolean isPreview() {
		return preview;
	}
	
	public static void previewLevel(Level l) {
		LetterCraze preview = new LetterCraze();
		preview.preview = true;
		preview.m = new Model(null);
		preview.m.loadLevel(l);
		preview.setSize(WIDTH, HEIGHT);
		preview.addKeyListener(new SubmitController(preview.m, preview));
		preview.setVisible(true);
		preview.update();
	}

	/**
	 * This is the constructor for the LetterCraze class
	 * @param m The model
	 */
	public LetterCraze(Model m) {
		super();
		this.m = m;
		this.setSize(WIDTH,HEIGHT);
		this.setResizable(false);

		this.addKeyListener(new SubmitController(m, this));
		this.addWindowListener(new SaveStateController(m,this));
		this.setVisible(true);
		this.update();
	}

	/**
	 * Initializes a game from the very beginning
	 */
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
	
	/**
	 * Initialize the level select menu GUIs
	 */
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
	
	/**
	 * Refreshes the Gui's
	 */
	public void update() {
		if (m.isInGame()) {
			if(gameView == null) {
				this.initializeGame();
			}
			this.gameView.update();
		} else if (preview) {
			// if we've exited the game in preview mode, then quit
			this.setVisible(false);
			gameView = null;
			this.dispose();
		} else {
			if (menuView == null) {
				initializeMenu();
			}
			menuView.update();
		}
		
		this.repaint();
	}

	/**
	 * Initializes a game
	 */
	public void initialize() {
		this.initializeMenu();
		this.setVisible(true);
	}
}
