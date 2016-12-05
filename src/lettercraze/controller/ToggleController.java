package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.view.BoardButton;

/**
 * This controller handles the toggling of a blocks state in the builder View
 * @see BuilderView
 */
public class ToggleController implements ActionListener
{
	BoardButton source;
	int active[] = {255, 255, 255};
	int inactive[] = {128, 128, 128};
	
	/**
	 * Initializer requires the source button
	 * @param button
	 */
	public ToggleController(BoardButton button)
	{
		this.source = button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Toggling block, fix this!");
		if (source.isEnabled())
		{
			source.setEnabled(false);
		}
		else
		{
			source.setEnabled(true);
		}
		System.out.println("Button x, y = " + source.getPoint().row + ", " + source.getPoint().col);
	}

}
