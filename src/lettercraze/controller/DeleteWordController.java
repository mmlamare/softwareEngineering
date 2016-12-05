package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 * This ActionListener Removes the selected word from the wordbank in the windowbuilder
 * @see BuilderView
 */
public class DeleteWordController implements ActionListener
{
	JFrame frame;
	JList list;
	
	/**
	 * Initializer requires the frame and the JList that the new word will be added to
	 * 
	 * @param frame
	 * @param l
	 */
	public DeleteWordController(JFrame frame, JList list)
	{
		this.frame = frame;
		this.list = list;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Deleting word");
		DefaultListModel listModel = (DefaultListModel) list.getModel();
		int selectedItem = list.getSelectedIndex();
		if (selectedItem >= 0)
		{
			listModel.remove(selectedItem);
		}
	}

}
