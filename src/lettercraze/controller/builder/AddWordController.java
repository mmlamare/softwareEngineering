package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * This ActionListener is used to prompt the user to add a word in the window builder.
 * @see BuilderView
 */
public class AddWordController implements ActionListener
{
	JList list;
	JFrame frame;
	
	/**
	 * Initializer requires the frame and the JList that the new word will be added to.
	 * 
	 * @param frame
	 * @param l
	 */
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
