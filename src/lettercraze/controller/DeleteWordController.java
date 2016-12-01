package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class DeleteWordController implements ActionListener
{
	JFrame frame;
	JList list;
	
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
