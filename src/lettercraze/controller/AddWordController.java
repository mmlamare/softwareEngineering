package lettercraze.controller;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class AddWordController implements ActionListener
{
	JList list;
	JFrame frame;
	
	public AddWordController(JFrame frame, JList l)
	{
		this.frame = frame;
		list = l;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Adding word");
		String word = JOptionPane.showInputDialog(frame, "Enter a word");
		DefaultListModel listModel = (DefaultListModel) list.getModel();
		listModel.add(listModel.getSize(), word);
	}

}
