package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.BuilderModel;
import lettercraze.model.LevelType;
import lettercraze.view.BuilderView;
import lettercraze.view.LetterCraze;

/**
 * The controller responsible for launching a preview game when "Preview" is
 * clicked.
 * @author Ruthenium
 *
 */
public class PreviewBoardController implements ActionListener {

	BuilderModel m;
	BuilderView app;
	
	/**
	 * Create a new preview board controller
	 * @param m The builder entity
	 * @param app The builder view
	 */
	public PreviewBoardController(BuilderModel m, BuilderView app) {
		this.m = m;
		this.app = app;
	}

	@Override
	/**
	 * Launch a preview of the current level.
	 */
	public void actionPerformed(ActionEvent e) {
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

		LetterCraze.previewLevel(m.getLevel());
	}

}
