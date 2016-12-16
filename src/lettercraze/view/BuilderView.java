package lettercraze.view;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import lettercraze.controller.builder.AddWordController;
import lettercraze.controller.builder.ChangeTypeController;
import lettercraze.controller.builder.DeleteWordController;
import lettercraze.controller.builder.LoadBoardController;
import lettercraze.controller.builder.PreviewBoardController;
import lettercraze.controller.builder.PublishBoardController;
import lettercraze.controller.builder.QuitBoardController;
import lettercraze.controller.builder.RightClickController;
import lettercraze.controller.builder.ToggleController;
import lettercraze.model.BuilderModel;
import lettercraze.model.LevelType;
import lettercraze.model.board.Board;
import lettercraze.model.board.ModelBuilder;
import lettercraze.model.board.Point;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is the high level GUI object for the builder application
 * @author Ruthenium
 * @version 1.0
 */
public class BuilderView
{
	JFrame frame;
	private static KeyAdapter textFilter;
	JLabel nameLabel;
	JTextField nameField;
	JTextField scores[] = new JTextField[3];
	
	JButton btnQuit;
	JRadioButton buttons[];
	JButton btnLoad;
	JButton btnSave;
	JButton btnAddWord;
	JButton btnDelete;
	JButton prevButt;
	JList<String> list;
	
	/**The static variable for the button size */
	public final static int BUTTON_SIZE = 32;
	
	private BuilderModel m;
	
	BoardButton squares[][];
	
	
	/**
	 * The constructor for the BuilderView
	 * @param m The model
	 */
	public BuilderView(BuilderModel m)
	{
		this.m = m;
		initialize();
		frame.setVisible(true);
		this.update();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JTextField getOneStarScore() {
		return scores[0];
	}
	
	public JTextField getTwoStarScore() {
		return scores[1];
	}
	
	public JTextField getThreeStarScore() {
		return scores[2];
	}
	
	public JTextField getMiscTextField() {
		return nameField;
	}
	
	/**
	 * Helper function to create a JPanel with the all the board buttons 
	 * @param frame
	 * @return The new panel with the game board 
	 */
	private JPanel addGameBoard(JFrame frame)
	{
		JPanel panel = new JPanel(); //Fix this contructor?
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(6, 6, 266, 266);
		
		panel.setLayout(new GridLayout(6,6));
		//panel.m = m;
		squares = new BoardButton[6][6];
		for (int row = 0; row < Board.SIZE; ++row) {
			for (int col=0; col < Board.SIZE; ++col) {
				Point loc = new Point(row,col);
				squares[row][col] = new BoardButton(new Point(row,col));
				squares[row][col].setOpaque(true);
				squares[row][col].setSize(BUTTON_SIZE, BUTTON_SIZE);
				squares[row][col].setFocusable(false);
				squares[row][col].addActionListener(new ToggleController(m, this, loc));
				squares[row][col].addMouseListener(new RightClickController(m, this, loc));
				panel.add(squares[row][col]);
			}
		}
		
		return panel;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 460, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel gamePanel = addGameBoard(frame);
		frame.getContentPane().add(gamePanel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(284, 6, 160, 266);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblStar = new JLabel("Star 1:");
		lblStar.setBounds(12, 27, 60, 16);
		panel_1.add(lblStar);
		
		JLabel lblThreshholds = new JLabel("Thresholds");
		lblThreshholds.setBounds(6, 6, 148, 16);
		lblThreshholds.setBackground(Color.GRAY);
		lblThreshholds.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblThreshholds);
		
		scores[0] = new JTextField();
		scores[0].setBounds(74, 22, 56, 26);
		scores[0].setText("100");
		scores[0].addKeyListener(textFilter);
		panel_1.add(scores[0]);
		scores[0].setColumns(10);
		
		JLabel lblStar_1 = new JLabel("Star 2:");
		lblStar_1.setBounds(12, 50, 60, 15);
		panel_1.add(lblStar_1);
		
		scores[1] = new JTextField();
		scores[1].setBounds(74, 45, 56, 26);
		scores[1].setText("200");
		scores[1].addKeyListener(textFilter);
		panel_1.add(scores[1]);
		scores[1].setColumns(10);
		
		JLabel lblStar_2 = new JLabel("Star 3:");
		lblStar_2.setBounds(12, 73, 60, 16);
		panel_1.add(lblStar_2);
		
		scores[2] = new JTextField();
		scores[2].setBounds(74, 68, 56, 26);
		scores[2].setText("300");
		scores[2].setColumns(10);
		scores[2].addKeyListener(textFilter);
		panel_1.add(scores[2]);
		
		JLabel lblLevelType = new JLabel("Level Type");
		lblLevelType.setBounds(6, 96, 148, 16);
		lblLevelType.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblLevelType);
		
		buttons = new JRadioButton[3];
		buttons[0] = new JRadioButton("Puzzle");
		buttons[0].setSelected(true);
		buttons[0].setBounds(6, 115, 141, 20);
		buttons[0].addActionListener(new ChangeTypeController(m,this,LevelType.PUZZLE));
		panel_1.add(buttons[0]);
		
		buttons[1] = new JRadioButton("Lightning");
		buttons[1].setBounds(6, 133, 141, 20);
		buttons[1].addActionListener(new ChangeTypeController(m,this,LevelType.LIGHTNING));
		panel_1.add(buttons[1]);
		
		buttons[2] = new JRadioButton("Theme");
		buttons[2].setBounds(6, 151, 141, 20);
		buttons[2].addActionListener(new ChangeTypeController(m,this,LevelType.THEME));
		panel_1.add(buttons[2]);
		
		ButtonGroup gameModes = new ButtonGroup();
		for (int i=0; i<buttons.length; i++)
		{
			gameModes.add(buttons[i]);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 175, 148, 66);
		panel_1.add(scrollPane);
		
		//String[] data = {"one", "two", "three", "four"};
		list = new JList<String>();
		list.setToolTipText("Words to add for Theme levels");
		scrollPane.setViewportView(list);
		
		btnAddWord = new JButton("+ Add");
		btnAddWord.addActionListener(new AddWordController(m, this));
		
		btnAddWord.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnAddWord.setBounds(5, 240, 70, 26);
		panel_1.add(btnAddWord);
		
		btnDelete = new JButton("- Delete");
		btnDelete.addActionListener(new DeleteWordController(m, this, list));
		btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnDelete.setBounds(76, 240, 84, 26);
		panel_1.add(btnDelete);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new PublishBoardController(m, this));
		btnSave.setName("save");
		btnSave.setBounds(16, 315, 117, 29);
		frame.getContentPane().add(btnSave);
		
		btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new LoadBoardController(m, this));
		btnLoad.setName("load");
		btnLoad.setBounds(145, 315, 117, 29);
		frame.getContentPane().add(btnLoad);
		
		btnQuit = new JButton("QUIT");
		btnQuit.addActionListener(new QuitBoardController(this));
		btnQuit.setName("quit");
		btnQuit.setBounds(308, 315, 117, 29);
		frame.getContentPane().add(btnQuit);
		
		nameLabel = new JLabel("Theme Name:");
		nameLabel.setBounds(22, 280, 160, 16);
		frame.getContentPane().add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(160, 280, 100, 26);
		nameField.setText("");
		nameField.setColumns(10);
		nameField.addKeyListener(textFilter);
		frame.getContentPane().add(nameField);
		
		prevButt = new JButton("Preview");
		prevButt.addActionListener(new PreviewBoardController(m, this));
		prevButt.setName("Preview");
		prevButt.setBounds(308, 280, 117, 29);
		frame.getContentPane().add(prevButt);
	}
	
	public void update() {
		switch(m.getLevel().type) {
		case PUZZLE:
			nameLabel.setText("Moves limit:");
			break;
		case LIGHTNING:
			nameLabel.setText("Time limit:");
			break;
		case THEME:
			nameLabel.setText("Theme Name:");
		}
		if (m.getLevel().type == LevelType.THEME && m.getLevel().words != null) {
			ArrayList<String> data = m.getLevel().words.getList();
			list.setListData(data.toArray(new String[data.size()]));
		}
		
		// set all the board buttons
		for (int row = 0; row < Board.SIZE; ++row) {
			for (int col = 0; col < Board.SIZE; ++col) {
				BoardButton b = squares[row][col];
				Point p = new Point(row, col);
				if (m.getBoard().isEmpty(p)) {
					b.setBackground(Color.WHITE);
					b.setText("");
				} else if (m.getBoard().isBlocked(p)) {
					b.setBackground(Color.BLACK);
					b.setText("");
				} else {
					char ch = m.getBoard().getLetter(p);
					if (ch == 'q')
						b.setText("qu");
					else
						b.setText("" + ch);
				}
			}
		}
	}

	/**
	 *  Change the values of the text fields to match the loaded level. This
	 *  normally is only invoked on a level load. Also changes the radio
	 *  buttons.
	 */
	public void updateTextFields() {
		this.scores[0].setText(Integer.toString(m.getLevel().oneStar));
		this.scores[1].setText(Integer.toString(m.getLevel().twoStar));
		this.scores[2].setText(Integer.toString(m.getLevel().threeStar));
		
		switch(m.getLevel().type) {
		case PUZZLE:
			nameField.setText(Integer.toString(m.getLevel().limit));
			buttons[0].setSelected(true);
			break;
		case LIGHTNING:
			nameField.setText(Integer.toString(m.getLevel().limit));
			buttons[1].setSelected(true);
			break;
		case THEME:
			nameField.setText(m.getLevel().name);
			buttons[2].setSelected(true);
			break;
		}
	}
}
