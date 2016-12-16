package lettercraze.controller.builder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListModel;

import lettercraze.files.Data;
import lettercraze.files.LevelLoader;
import lettercraze.model.BuilderModel;
import lettercraze.model.Level;
import lettercraze.view.BoardButton;
import lettercraze.view.BuilderView;
import lettercraze.view.GameView;

/**
 * This controller handles the loading of board data for the game view.
 * @author Ruthenium
 * @see GameView
 */
public class LoadBoardController implements ActionListener
{
	BuilderModel m;
	BuilderView app;

	JFrame frame;
	JFileChooser fc;
	BoardButton squares[][];
	JRadioButton buttons[];
	JTextField scores[];
	DefaultListModel customWords;
	
	/**
	 * 
	 * @param m The Builder Model
	 * @param app The Builder View
	 */
	public LoadBoardController(BuilderModel m, BuilderView app)
	{
		this.m = m;
		this.app = app;
	}
	
	/**
	 * Loads the File
	 * @param
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		fc = new JFileChooser();
		fc.setCurrentDirectory(Data.getDataDir());
		fc.showOpenDialog(frame);
		File saveFile = fc.getSelectedFile();
		
		try {
			InputStream in = new FileInputStream(saveFile);
			Level l = new LevelLoader().load(in);
			if (l == null) {
				notifyFailed(saveFile);
			} else {
				m.loadLevel(l);
				app.update();
			}
		} catch (FileNotFoundException e1) {
			notifyFailed(saveFile);
		}
	}
	
	/**
	 * Enacted whenever there is a problem with loading a file
	 * @param f The file that was attempted to be loaded
	 */
	public void notifyFailed(File f) {
		JOptionPane.showMessageDialog(app.getFrame(), 
				"Failed to load file: " + f.getName(),
				"Error",
				JOptionPane.ERROR_MESSAGE);
	}
}
