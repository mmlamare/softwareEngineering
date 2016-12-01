package lettercraze.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.view.BoardButton;

public class ToggleController implements ActionListener
{
	BoardButton source;
	
	public ToggleController(BoardButton button)
	{
		this.source = button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Toggling block");
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
