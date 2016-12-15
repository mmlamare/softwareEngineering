package lettercraze.controller.builder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListModel;

import lettercraze.files.Data;
import lettercraze.view.BoardButton;
import lettercraze.view.BuilderView;

/**
 * This controller handles the Saving of a custom board in the builder app.
 * @author Ruthenium
 * @see BuilderView
 */
public class PublishBoardController implements ActionListener
{
	JFrame frame;
	String saveName;
	BoardButton squares[][];
	JRadioButton buttons[];
	JTextField scores[];
	ListModel<String> customWords;
	
	/**
	 * Initializer requires the frame that the builder window belongs to.
	 * @param frame
	 */
	public PublishBoardController(JFrame frame, BoardButton squares[][], JRadioButton buttons[], JTextField scoreThreshholds[], ListModel<String> list)
	{
		this.frame = frame;
		this.squares = squares;
		this.buttons = buttons;
		this.scores = scoreThreshholds;
		this.customWords = list;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(Data.getDataDir());
		fc.showSaveDialog(frame);
		File saveFile = fc.getSelectedFile();

		String levelType = getLevelType();

		//Save all our stuff here given the gamepanel with all the squares
		ArrayList<String> saveData = new ArrayList<String>();
		saveData.add(levelType);
		saveData.add(saveName);

		String line = "";
		for (int row=0; row<squares.length; row++)
		{
			for (int col = 0; col < squares[row].length; col++)
			{
				line += getValue(squares[row][col]);
			}
		}
		
		saveData.add(line);
		
		saveData.add(scores[0].getText() + " " + scores[1].getText() + " " + scores[2].getText());
		saveData.add("0");
		
		if (levelType.equals("theme"))
		{
			//Add custom words
			for (int i=0; i<customWords.getSize(); i++)
			{
				saveData.add(customWords.getElementAt(i).toString());
			}
		}
		
		saveBoardData(saveFile, saveData);
		showMessage(frame, "Board saved!");
	}
	
	private void showMessage(JFrame frame, String message)
	{
		JOptionPane.showMessageDialog(frame, message);
	}
	
	
	private String getLevelType()
	{
		if (buttons[0].isSelected()) return "puzzle";
		if (buttons[1].isSelected()) return "lightning";
		return "theme";
	}
	
	private String getValue(BoardButton b)
	{
		if (b.getBackground().equals(Color.GRAY))
		{
			//The button is disabled
			return "#";
		}
		
		String str = b.getText();
		if (str.length() == 0)
		{
			return ".";
		}
		return str;
	}
	
	private void saveBoardData(File saveFile, ArrayList<String> saveData)
	{
		try
		{
		    PrintWriter writer = new PrintWriter(saveFile, "UTF-8");
		    for (int i=0; i<saveData.size(); i++)
		    {
		    	writer.println(saveData.get(i));
		    }
		    writer.close();
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
		}
	}
}
