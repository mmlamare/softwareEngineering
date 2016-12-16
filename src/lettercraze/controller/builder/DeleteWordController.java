package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import lettercraze.model.BuilderModel;
import lettercraze.model.board.Point;
import lettercraze.view.BuilderView;

/**
 * This ActionListener Removes the selected word from the wordbank in the windowbuilder.
 * @author Ruthenium
 * @see BuilderView
 */
public class DeleteWordController implements ActionListener
{
	BuilderModel m;
	BuilderView app;
	JList<String> list;
	
	/**
	 * Initializer requires the frame and the JList that the new word will be added to.
	 * 
	 * @param frame
	 * @param l
	 */
	public DeleteWordController(BuilderModel m, BuilderView app, JList<String> list)
	{
		this.m = m;
		this.app = app;
		this.list = list;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		m.removeWord(list.getSelectedValue());
		app.update();
	}

}
