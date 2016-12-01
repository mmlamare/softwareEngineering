package lettercraze.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SplashScreenView extends JFrame
{
	JFrame frame;
	String messages[];
	
	public SplashScreenView(String newMessages[])
	{
		messages = newMessages;
		initialize();
	}
	
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
	
	private JLabel getTextField(String str)
	{
		JLabel field = new JLabel(str, SwingConstants.CENTER);
		field.setFont(new Font("Arial", Font.BOLD, 22));
		//field.setBackground(128, 128, 128, 128);
		field.setOpaque(true);
		
		return field;
	}
}
