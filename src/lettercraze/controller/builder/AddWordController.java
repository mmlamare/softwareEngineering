package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import lettercraze.model.BuilderModel;
import lettercraze.model.LevelType;
import lettercraze.view.BuilderView;

/**
 * This controller is used to prompt the user to add a word in the window builder.
 * @author Ruthenium
 * @see BuilderView
 */
public class AddWordController implements ActionListener {
	BuilderModel m;
	BuilderView app;
	
	/**
	 * Initializer requires the frame and the JList that the new word will be added to.
	 * @param m the builder model
	 * @param app the builder boundary
	 */
	public AddWordController(BuilderModel m, BuilderView app) {
		this.m = m;
		this.app = app;
	}
	
	/**
	 * This does the controller action of adding the word from the user to the entity.
	 * Then it refreshes the display
	 * @param e The action event object
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Ensure that we're in theme mode
		if (m.getLevel().type == LevelType.THEME) {
			String word = JOptionPane.showInputDialog(app, "Enter a word");
			m.addWord(word);
			app.update();
		}
	}
}
