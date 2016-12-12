package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import lettercraze.view.BoardButton;

/**
 * This controller handles the loading of board data for the game view.
 * @see GameView
 */
public class LoadBoardController implements ActionListener
{
	JFrame frame;
	final JFileChooser fc;
	BoardButton squares[][];
	
	/**
	 * Initializer requires the JFrame that the board belongs to.
	 * @param frame
	 */
	public LoadBoardController(JFrame frame, BoardButton squares[][])
	{
		this.frame = frame;
		File currentDir = new File(System.getProperty("user.dir"));
		fc = new JFileChooser(currentDir);
		this.squares = squares;
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
		
		loadBoard(lines, squares);
	}
	
	private void loadBoard(ArrayList<String> lines, BoardButton squares[][])
	{
		
	}
}
