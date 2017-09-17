package NoteTaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

public class MainClass {
	
	private static JPanel mainPanel;
	private static JFrame frame;
	private static JMenuBar menuBar;
	private static JMenu subMenu;
	private static JMenuItem menuItem;
	private static JLabel topLabel;
	private static Font font;
	private static JTextField textField;
	private static JTextArea textArea;
	private final static String newLine = "\n";
	private static JPanel secondPanel;
	private static int numbInList = 0;
	private static JScrollPane scrollForText;
	
	public MainClass() {
		
	}

	public static void main(String[] args) {
		createWindow("Pro-crastin8or");	
	}

	public static void createWindow(String aTitle) {	
		//creating the font
		font = new Font("Book Antiqua", font.PLAIN, 20);	
		
		//creating the frame 
		frame = new JFrame(aTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(330,700));
     
        //creating the menu bar
        menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(200,20));         
        menuBar.setBackground(Color.LIGHT_GRAY);
        
        //first menu option
        subMenu = new JMenu("File");
        subMenu.setMnemonic(KeyEvent.VK_A);
        subMenu.getAccessibleContext();
        menuBar.add(subMenu);
        
        //adding submenuitems to the first menu option
        menuItem = new JMenuItem("Open File"); 
        menuItem.setMnemonic(KeyEvent.VK_B);
        subMenu.add(menuItem);
        
        //adding submenuitems to the first menu option
        menuItem = new JMenuItem("Save As");
        menuItem.setMnemonic(KeyEvent.VK_B);
        subMenu.add(menuItem);
        
        //adding submenuitems to the first menu option
        menuItem = new JMenuItem("Print");
        menuItem.setMnemonic(KeyEvent.VK_B);
        subMenu.add(menuItem);
        
        //adding submenuitems to the first menu option
        menuItem = new JMenuItem("close");
        menuItem.setMnemonic(KeyEvent.VK_B);
        subMenu.add(menuItem);

        //second menu option
        subMenu = new JMenu("Options");
        subMenu.setMnemonic(KeyEvent.VK_A);
        subMenu.getAccessibleContext();
        menuBar.add(subMenu);
        
        //adding submenuitems to the first menu option
        menuItem = new JMenuItem("Launch on Windows start up");
        menuItem.setMnemonic(KeyEvent.VK_B);
        subMenu.add(menuItem);
        
        //adding submenuitems to the first menu option
        menuItem = new JMenuItem("Change Font");
        menuItem.setMnemonic(KeyEvent.VK_B);
        subMenu.add(menuItem);
   
        //third menu option
        subMenu = new JMenu("About");
        subMenu.setMnemonic(KeyEvent.VK_A);
        subMenu.getAccessibleContext();
        menuBar.add(subMenu);
        
        //adding submenuitems to the first menu option
        menuItem = new JMenuItem("User Agreement");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
            	JFrame newFrame = new JFrame("User Agreement");
        		newFrame.setSize(300,300);
        		newFrame.getContentPane().setBackground(Color.white);
        		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		newFrame.setVisible(true);
            	}
            });
        subMenu.add(menuItem);
        
        //adding submenuitems to the first menu option
        menuItem = new JMenuItem("Version");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
            	JFrame newFrame = new JFrame("Version");
        		newFrame.setSize(300,300);
        		newFrame.getContentPane().setBackground(Color.white);
        		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		newFrame.setVisible(true);
        		JLabel jLab = new JLabel("Version: ALPHA 0.02", SwingConstants.CENTER); // centering the label text into middle of the frame
        		newFrame.add(jLab);
            	}
            });
        subMenu.add(menuItem);
            
        //adding the textArea
        textField = new JTextField("Enter a new task", 30);
        textArea = new JTextArea(20,300);
        
        //adding top title
        topLabel = new JLabel("Tasks to do");
        topLabel.setFont(font);
        topLabel.setHorizontalAlignment(JLabel.CENTER); //setting the title to center alignment
        makeFontUnderlined(topLabel);     //adding an underline to the topLabel
        
        
        //creating the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); // creating a new borderlayout
        mainPanel.setBounds(6, 3, 310, 20); // setting panel bounds
        mainPanel.setBackground(Color.WHITE); //setting background to white (more for ease of seeing where each panel is)
        mainPanel.add(topLabel, BorderLayout.CENTER); // adding the title and centering it

  
        //adding the second panel
        secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());
        secondPanel.setBounds(10,10, 310,200);
        secondPanel.setBackground(Color.ORANGE);
        
        //adding the textField and area to the secondPanel
        textField.setBounds(3, 40, 317, 20);
        textArea.setBounds(300, 300, 317, 20);
        textArea.setEditable(false);     
        secondPanel.add(textField, BorderLayout.SOUTH);       
        secondPanel.add(textArea, BorderLayout.SOUTH);
        textField.addFocusListener(new FocusListener() { //highlights the textField when program for easy deletion
        	public void focusGained(FocusEvent e) {
        	    textField.selectAll(); 
        	}
        	public void focusLost(FocusEvent e) {

        	}
        	}); 
        
        textField.addActionListener(new ActionListener() { // actionListener for when enter is clicked
        	public void actionPerformed(ActionEvent e) {
        		String text = textField.getText();
        		if (text.isEmpty() ||  text.trim().length() <= 0) {   // checks if the textField is empty or whitespace
        			textField.setText(""); //basically says do nothing
        		}
        		else {
        			numbInList++; //increments the task list 
	        		textArea.append(numbInList + ":  " + text + newLine); //add the textField content to the list
	        		textField.selectAll();
	        		textField.setText(""); //refreshing the textField
        		}     		
        	}
        });
        	
        
        //adding the menu bar and the main panel to the frame
        frame.setJMenuBar(menuBar);
        mainPanel.add(topLabel);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.add(secondPanel);
               
        // pack and display the frame
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        
  
        
	}
	
		
	public static void makeFontUnderlined(JLabel aLabel) {
		 Font font2 = aLabel.getFont();
	     Map attributes = font2.getAttributes();
	     attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	     aLabel.setFont(font2.deriveFont(attributes));
	}
	
	public void actionPerformed(ActionEvent e) {
		String text = textField.getText();
		textArea.append(text + newLine);
		textField.selectAll();
	}
	
	
	
}