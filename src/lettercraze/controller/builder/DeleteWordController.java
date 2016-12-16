package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import lettercraze.model.BuilderModel;
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
	 * @param m The builder entity
	 * @param app The Builder boundary
	 * @param l The boundary's list of strings
	 */
	public DeleteWordController(BuilderModel m, BuilderView app, JList<String> list)
	{
		this.m = m;
		this.app = app;
		this.list = list;
	}
	
	/**
	 * This gets the selected word from the boundary and
	 * removes it from the entity
	 * Then it refreshes the display.
	 * @param e The action event object
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		m.removeWord(list.getSelectedValue());
		app.update();
	}

}
