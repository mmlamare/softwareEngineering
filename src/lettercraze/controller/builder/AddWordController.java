package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import lettercraze.model.BuilderModel;
import lettercraze.view.BuilderView;

/**
 * This ActionListener is used to prompt the user to add a word in the window builder.
 * @author Ruthenium
 * @see BuilderView
 */
public class AddWordController implements ActionListener {
	BuilderModel m;
	BuilderView app;
	
	/**
	 * Initializer requires the frame and the JList that the new word will be added to.
	 * 
	 * @param frame
	 * @param l
	 */
	public AddWordController(BuilderModel m, BuilderView app) {
		this.m = m;
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String word = JOptionPane.showInputDialog(app, "Enter a word");
		m.addWord(word);
		app.update();
	}
}
