package lettercraze.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * This is the GUI Boundary class for the splash screen
 * @author Ruthenium
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SplashScreenView extends JFrame
{
	JFrame frame;
	String messages[];
	
	/**
	 * Splash screen view constructor
	 * @param newMessages The messages that will be displayed
	 * on the splash screen.
	 */
	public SplashScreenView(String newMessages[])
	{
		messages = newMessages;
		initialize();
	}
	
	/**
	 * Initializes the splash screen
	 */
	public void initialize() {
		this.setLayout(new GridLayout(7, 1));
		//this.setBackground(new Color(30, 180, 130));
		
		for (int i=0; i<messages.length; i++)
		{
			this.add(getTextField(messages[i]));
		}
		
		this.setBounds(new Rectangle(100, 100, 400, 400));
		this.setVisible(true);
	}
	
	/**
	 * Create a new JLabel with formatted text
	 * @param str The string value of the label
	 * @return The created JLabel
	 */
	private JLabel getTextField(String str)
	{
		JLabel field = new JLabel(str, SwingConstants.CENTER);
		field.setFont(new Font("Arial", Font.BOLD, 22));
		//field.setBackground(128, 128, 128, 128);
		field.setOpaque(true);
		
		return field;
	}
}
