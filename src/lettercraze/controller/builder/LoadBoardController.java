package lettercraze.controller.builder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListModel;

import lettercraze.view.BoardButton;
import lettercraze.view.GameView;

/**
 * This controller handles the loading of board data for the game view.
 * @author Ruthenium
 * @see GameView
 */
public class LoadBoardController implements ActionListener
{
	JFrame frame;
	final JFileChooser fc;
	BoardButton squares[][];
	JRadioButton buttons[];
	JTextField scores[];
	DefaultListModel customWords;
	
	/**
	 * Initializer requires the JFrame that the board belongs to.
	 * @param frame
	 */
	public LoadBoardController(JFrame frame, BoardButton squares[][], JRadioButton buttons[], JTextField scoreThreshholds[], DefaultListModel list)
	{
		this.frame = frame;
		File currentDir = new File(System.getProperty("user.dir") + "/resources");
		fc = new JFileChooser(currentDir);
		this.squares = squares;
		this.buttons = buttons;
		this.scores = scoreThreshholds;
		this.customWords = list;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Loading Board...");
		
		ArrayList<String> lines = new ArrayList<String>();
		
		int returnVal = fc.showOpenDialog(frame);
		
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
            File file = fc.getSelectedFile();
            //This is where a real application would open the file.
            System.out.println("Opening: " + file.getName() + ".");
            
            try
            {
                // FileReader reads text files in the default encoding.
                FileReader fileReader = new FileReader(file.getAbsolutePath());

                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = "";
                while((line = bufferedReader.readLine()) != null)
                {
                    lines.add(line);
                }

                // Always close files.
                bufferedReader.close();
            }
            catch (FileNotFoundException err)
            {
            	System.err.println(err.getMessage());
            }
            catch(IOException err)
            {
            	System.err.println(err.getMessage());
            }
        }
		else
        {
            System.out.println("Open command cancelled by user.");
        }
		
		loadBoard(lines);
	}
	
	private void loadBoard(ArrayList<String> lines)
	{
		String levelType = lines.get(0);
		String levelName = lines.get(1);
		String levelData = lines.get(2);
		String threshholds[] = lines.get(3).split(" ");
		
		if (levelType.equals("puzzle"))
		{
			buttons[0].setSelected(true);
		}
		else if (levelType.equals("lightning"))
		{
			buttons[1].setSelected(true);
		}
		else
		{
			buttons[2].setSelected(true);
		}
		
		for (int i=0; i<threshholds.length; i++)
		{
			scores[i].setText(threshholds[i]);
		}
		
		//ArrayList<String> words = new ArrayList<String>();
		if (levelType.equals("theme"))
		{
			for (int i=4; i<lines.size()-1; i++)
			{
				customWords.add(customWords.getSize(), lines.get(i));
			}
		}
		
		String maxWords = lines.get(lines.size()-1);
		for (int row = 0; row < squares.length; row++)
		{
			for (int col = 0; col < squares[row].length; col++)
			{
				String value = getValue(levelData.charAt(row * squares.length + col));
				
				if (value.equals("#"))
				{
					disable(squares[row][col]);
				}
				else
				{
					squares[row][col].setText(value);
				}
			}
		}
	}
	
	private String getValue(char input)
	{
		if (input == '.')
		{
			return ""; //randomLetter();
		}
		return new Character(input).toString();
	}
	
	/*private String randomLetter()
	{
		Random r = new Random();
		return new Character((char)((Math.abs(r.nextInt() % 26)) + 97)).toString();
	}*/
	
	private void disable(BoardButton b)
	{
		b.setBackground(Color.GRAY);
		b.setBorder(null);
		b.setForeground(new Color(80, 80, 80));
	}
}
