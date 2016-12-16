package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListModel;

import lettercraze.files.Data;
import lettercraze.files.LevelWriter;
import lettercraze.model.BuilderModel;
import lettercraze.model.LevelType;
import lettercraze.view.BoardButton;
import lettercraze.view.BuilderView;

/**
 * This controller handles the Saving of a custom board in the builder app.
 * @author Ruthenium
 * @see BuilderView
 */
public class PublishBoardController implements ActionListener
{
	BuilderModel m;
	BuilderView app;

	/**
	 * Initializer requires the frame that the builder window belongs to.
	 * @param frame
	 */
	public PublishBoardController(BuilderModel m, BuilderView app) {
		this.m = m;
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(Data.getDataDir());
		fc.showSaveDialog(app.getFrame());
		File saveFile = fc.getSelectedFile();
		
		// read the parameters from BuilderView into the model
		String oneStar = app.getOneStarScore().getText();
		String twoStar = app.getTwoStarScore().getText();
		String threeStar = app.getThreeStarScore().getText();
		String miscField = app.getMiscTextField().getText();

		m.getLevel().oneStar = Integer.parseInt(oneStar);
		m.getLevel().twoStar = Integer.parseInt(twoStar);
		m.getLevel().threeStar = Integer.parseInt(threeStar);
		if (m.getLevel().type == LevelType.THEME) {
			m.getLevel().name = miscField;
		} else {
			m.getLevel().limit = Integer.parseInt(miscField);
		}

		boolean success = LevelWriter.writeLevel(m.getLevel(), saveFile);
		if (!success) System.err.println("couldn't write file " + saveFile.getName());

		app.update();
	}
}
