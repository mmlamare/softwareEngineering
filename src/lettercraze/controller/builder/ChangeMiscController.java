package lettercraze.controller.builder;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import lettercraze.model.BuilderModel;
import lettercraze.model.LevelType;
import lettercraze.view.BuilderView;

/**
 * A controller used to track changes to the Misc text field.
 * @author Ruthenium
 *
 */
public class ChangeMiscController implements FocusListener {
	BuilderModel m;
	BuilderView app;
	
	/**
	 * Create a new ChangeMiscController
	 * @param m The model for the builder
	 * @param app The view for the builder
	 */
	public ChangeMiscController(BuilderModel m, BuilderView app) {
		this.m = m;
		this.app = app;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
	}

	/**
	 * Update the misc value when the user changes focus away from the field,
	 * ensuring that the new value is valid.
	 */
	@Override
	public void focusLost(FocusEvent arg0) {
		String str = app.getMiscTextField().getText();
		if (m.getLevel().type == LevelType.THEME) {
			m.getLevel().name = str;
		} else {
			try {
				int limit = Integer.parseInt(str);
				m.getLevel().limit = limit;
				app.update();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(app.getFrame(),
						"Limit must be an integer.",
						"Invalid field",
						JOptionPane.INFORMATION_MESSAGE);
				app.getMiscTextField().setText("" + m.getLevel().limit);
				app.update();
			}
		}
	}

}
