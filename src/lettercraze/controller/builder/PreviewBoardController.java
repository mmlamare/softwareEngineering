package lettercraze.controller.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.model.BuilderModel;
import lettercraze.model.LevelType;
import lettercraze.view.BuilderView;
import lettercraze.view.LetterCraze;

public class PreviewBoardController implements ActionListener {

	BuilderModel m;
	BuilderView app;
	
	public PreviewBoardController(BuilderModel m, BuilderView app) {
		this.m = m;
		this.app = app;
	}

	@Override
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
