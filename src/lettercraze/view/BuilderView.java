package lettercraze.view;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import lettercraze.controller.ToggleController;
import lettercraze.controller.builder.AddWordController;
import lettercraze.controller.builder.DeleteWordController;
import lettercraze.controller.builder.LoadBoardController;
import lettercraze.controller.builder.PublishBoardController;
import lettercraze.controller.builder.QuitBoardController;
import lettercraze.controller.builder.RightClickController;
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

public class BuilderView {

	private JFrame frame;
	private JTextField textField;
	private static KeyAdapter textFilter;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public final static int BUTTON_SIZE = 32;
	
	private static ModelBuilder m;
	
	BoardButton squares[][];
	
	public BuilderView(ModelBuilder m)
	{
		this.m = m;
		initBoard();
	}

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args)
	public void initBoard()
	{
		//m = mNew;
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
				squares[row][col] = new BoardButton(new Point(row,col));
				squares[row][col].setOpaque(true);
				squares[row][col].setSize(BUTTON_SIZE, BUTTON_SIZE);
				squares[row][col].setFocusable(false);
				squares[row][col].addActionListener(new ToggleController(squares[row][col]));
				squares[row][col].addMouseListener(new RightClickController(squares[row][col]));
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
		frame.setBounds(100, 100, 451, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//int intVals[] = new int[15];
		//for (int i=0; i<15; i++){intVals[i]=i;}
		/*BoardView panel = new BoardView(m); //Fix this contructor?
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(6, 6, 266, 266);
		frame.getContentPane().add(panel);*/
		
		JPanel gamePanel = addGameBoard(frame);
		frame.getContentPane().add(gamePanel);
		
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
		
		JTextField scores[] = new JTextField[3];
		scores[0] = new JTextField();
		scores[0].setBounds(74, 22, 56, 26);
		scores[0].setText("100");
		scores[0].addKeyListener(textFilter);
		panel_1.add(scores[0]);
		scores[0].setColumns(10);
		
		JLabel lblStar_1 = new JLabel("Star 2:");
		lblStar_1.setBounds(22, 50, 40, 15);
		panel_1.add(lblStar_1);
		
		scores[1] = new JTextField();
		scores[1].setBounds(74, 45, 56, 26);
		scores[1].setText("200");
		scores[1].addKeyListener(textFilter);
		panel_1.add(scores[1]);
		scores[1].setColumns(10);
		
		JLabel lblStar_2 = new JLabel("Star 3:");
		lblStar_2.setBounds(22, 73, 40, 16);
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
		
		JRadioButton buttons[] = new JRadioButton[3];
		buttons[0] = new JRadioButton("Puzzle");
		buttons[0].setSelected(true);
		buttons[0].setBounds(6, 115, 141, 20);
		panel_1.add(buttons[0]);
		
		buttons[1] = new JRadioButton("Lightning");
		buttons[1].setBounds(6, 133, 141, 20);
		panel_1.add(buttons[1]);
		
		buttons[2] = new JRadioButton("Theme");
		buttons[2].setBounds(6, 151, 141, 20);
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
		JList list = new JList();
		DefaultListModel listModel = new DefaultListModel();
		list.setModel(listModel);
		list.setToolTipText("Words to add for Theme levels");
		scrollPane.setViewportView(list);
		
		JButton btnAddWord = new JButton("+ Add");
		btnAddWord.addActionListener(new AddWordController(frame, list));
		
		btnAddWord.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnAddWord.setBounds(22, 240, 56, 26);
		panel_1.add(btnAddWord);
		
		JButton btnDelete = new JButton("- Delete");
		btnDelete.addActionListener(new DeleteWordController(frame, list));
		btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnDelete.setBounds(76, 240, 84, 26);
		panel_1.add(btnDelete);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new PublishBoardController(frame, squares, buttons, scores, listModel));
		btnSave.setBounds(16, 277, 117, 29);
		frame.getContentPane().add(btnSave);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new LoadBoardController(frame, squares, buttons, scores, listModel));
		btnLoad.setBounds(145, 277, 117, 29);
		frame.getContentPane().add(btnLoad);
		
		JButton btnPublish = new JButton("QUIT");
		btnPublish.addActionListener(new QuitBoardController(frame));
		btnPublish.setBounds(308, 277, 117, 29);
		frame.getContentPane().add(btnPublish);
	}
}
