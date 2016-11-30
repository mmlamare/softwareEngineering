package lettercraze.view;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuilderView {

	private JFrame frame;
	private JTextField textField;
	private static KeyAdapter textFilter;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		//This adapter will be assigned to any numerical inputs
		textFilter = new KeyAdapter() {
			   public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  // ignore event unless its a letter
			      }
			   }
			};
			
		//Default windowbuilder code
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				try {
					BuilderView window = new BuilderView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuilderView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 451, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(6, 6, 266, 266);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(284, 6, 160, 266);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblStar = new JLabel("Star 1:");
		lblStar.setBounds(22, 27, 40, 16);
		panel_1.add(lblStar);
		
		JLabel lblThreshholds = new JLabel("Thresholds");
		lblThreshholds.setBounds(6, 6, 148, 16);
		lblThreshholds.setBackground(Color.GRAY);
		lblThreshholds.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblThreshholds);
		
		textField = new JTextField();
		textField.setBounds(74, 22, 56, 26);
		textField.setText("100");
		textField.addKeyListener(textFilter);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblStar_1 = new JLabel("Star 2:");
		lblStar_1.setBounds(22, 50, 40, 15);
		panel_1.add(lblStar_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(74, 45, 56, 26);
		textField_1.setText("200");
		textField.addKeyListener(textFilter);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblStar_2 = new JLabel("Star 3:");
		lblStar_2.setBounds(22, 73, 40, 16);
		panel_1.add(lblStar_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 68, 56, 26);
		textField_2.setText("300");
		textField_2.setColumns(10);
		textField.addKeyListener(textFilter);
		panel_1.add(textField_2);
		
		JLabel lblLevelType = new JLabel("Level Type");
		lblLevelType.setBounds(6, 96, 148, 16);
		lblLevelType.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblLevelType);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Puzzle");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(6, 115, 141, 20);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnLightning = new JRadioButton("Lightning");
		rdbtnLightning.setBounds(6, 133, 141, 20);
		panel_1.add(rdbtnLightning);
		
		JRadioButton rdbtnTheme = new JRadioButton("Theme");
		rdbtnTheme.setBounds(6, 151, 141, 20);
		panel_1.add(rdbtnTheme);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 175, 148, 66);
		panel_1.add(scrollPane);
		
		//String[] data = {"one", "two", "three", "four"};
		JList list = new JList();
		list.setModel(new DefaultListModel());
		list.setToolTipText("Words to add for Theme levels");
		scrollPane.setViewportView(list);
		
		
		JButton btnAddWord = new JButton("+ Add");
		btnAddWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Adding word");
				String word = JOptionPane.showInputDialog(frame, "Enter a word");
				DefaultListModel listModel = (DefaultListModel) list.getModel();
				listModel.add(listModel.getSize(), word);
			}
		});
		btnAddWord.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnAddWord.setBounds(22, 240, 56, 26);
		panel_1.add(btnAddWord);
		
		JButton btnDelete = new JButton("- Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Deleting word");
				DefaultListModel listModel = (DefaultListModel) list.getModel();
				int selectedItem = list.getSelectedIndex();
				if (selectedItem >= 0)
				{
					listModel.remove(selectedItem);
				}
			}
		});
		btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnDelete.setBounds(76, 240, 84, 26);
		panel_1.add(btnDelete);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Saving Board...");
			}
		});
		btnSave.setBounds(16, 277, 117, 29);
		frame.getContentPane().add(btnSave);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Loading Board...");
			}
		});
		btnLoad.setBounds(145, 277, 117, 29);
		frame.getContentPane().add(btnLoad);
		
		JButton btnPublish = new JButton("QUIT");
		btnPublish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Publishing Board...");
			}
		});
		btnPublish.setBounds(308, 277, 117, 29);
		frame.getContentPane().add(btnPublish);
	}
}
