package lettercraze.controller.builder;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import lettercraze.model.BuilderModel;
import lettercraze.view.BuilderView;

/**
 * Ensure that the value of a number field is always a number
 * @author Ruthenium
 */
public class ChangeScoreController implements FocusListener {
	BuilderModel m;
	BuilderView app;
	int scoreIndex;
	JTextField field;

	public ChangeScoreController(BuilderModel m, BuilderView app, int scoreIndex) {
		this.m = m;
		this.app = app;
		this.scoreIndex = scoreIndex;

		switch(scoreIndex) {
		case 0:
			field = app.getOneStarScore();
			break;
		case 1:
			field = app.getTwoStarScore();
			break;
		case 2:
			field = app.getThreeStarScore();
			break;
		}
	}

	@Override
	public void focusGained(FocusEvent e) { }

	@Override
	public void focusLost(FocusEvent e) {
		String val = field.getText();

		try {
			int score = Integer.parseInt(val);
			switch(scoreIndex) {
			case 0:
				m.getLevel().oneStar = score;
				break;
			case 1:
				m.getLevel().twoStar = score;
				break;
			case 2:
				m.getLevel().threeStar = score;
				break;
			}
			app.update();
			app.updateTextFields();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(app.getFrame(),
					"Score thresholds must be integers.",
					"Invalid field",
					JOptionPane.INFORMATION_MESSAGE);

			// set the text fields back to the last valid value
			switch(scoreIndex) {
			case 0:
				field.setText("" + m.getLevel().oneStar);
				break;
			case 1:
				field.setText("" + m.getLevel().twoStar);
				break;
			case 2:
				field.setText("" + m.getLevel().threeStar);
				break;
			}
			app.update();
			app.updateTextFields();
		}
	}

}
