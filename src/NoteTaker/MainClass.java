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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
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
	private static HashMap <Integer, String> noteMap;
	
	public MainClass() {
		
	}

	public static void main(String[] args) {
		createWindow("Pro-crastin8or");	
	}

	public static void createWindow(String aTitle) {	
		//creating the list
		noteMap = new HashMap<Integer, String>();
		
		//creating the font
		font = new Font("Arial", Font.PLAIN, 20);	
		
		//creating the frame 
		frame = new JFrame(aTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(330,700));
     
        //creating the menu bar
        menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(200,20));         
        menuBar.setBackground(Color.LIGHT_GRAY);
        
        //adding file menu option
        subMenu = new JMenu("File");
        subMenu.setMnemonic(KeyEvent.VK_A);
        subMenu.getAccessibleContext();
        menuBar.add(subMenu);
        
        //adding Open to the first menu option
        menuItem = new JMenuItem("Open File"); 
        menuItem.setMnemonic(KeyEvent.VK_B);
        subMenu.add(menuItem);
        
        //adding save to the first menu option which saves the list to a txt file
        menuItem = new JMenuItem("Save"); //adds a save option to the list. Now currently only saves with no option on where. Need to change. 
        menuItem.setMnemonic(KeyEvent.VK_B);
        subMenu.add(menuItem);
        menuItem.addMouseListener(new MouseAdapter(){
        	@Override
            public void mousePressed(MouseEvent e) {
            	String text1 = textArea.getText();
            	BufferedWriter writer = null;
            	try
            	{
            	    writer = new BufferedWriter( new FileWriter("Saved Tasks.txt")); //creating the new file
            	    writer.write(text1);
            	}
            	catch ( IOException error)
            	{
            	}
            	finally
            	{
            	    try
            	    {
            	        if ( writer != null)
            	        writer.close();
            	    }
            	    catch (IOException error)
            	    {
            	    }
            	}
            	}
            });
        
        //adding print to the first menu option
        menuItem = new JMenuItem("Print");
        menuItem.setMnemonic(KeyEvent.VK_B);
        subMenu.add(menuItem);
        
        //adding close to the first menu option
        menuItem = new JMenuItem("Close");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.addMouseListener(new MouseAdapter(){ // sets the 'close' option in the submenu to close the program down
        	@Override
        	public void mousePressed(MouseEvent e) {
            	frame.dispose();
            	}
            });
        subMenu.add(menuItem);

        //Options menu option
        subMenu = new JMenu("Options");
        subMenu.setMnemonic(KeyEvent.VK_A);
        subMenu.getAccessibleContext();
        menuBar.add(subMenu);
        
        //adding Launch on windows start up to the second menu option
        menuItem = new JMenuItem("Launch on Windows start up");
        menuItem.setMnemonic(KeyEvent.VK_B);
        subMenu.add(menuItem);
        
        //adding Change Font to the second menu option
        menuItem = new JMenuItem("Change Font");
        menuItem.setMnemonic(KeyEvent.VK_B);
        subMenu.add(menuItem);
        
        //adding Clear Tasks to the second menu option
        menuItem = new JMenuItem("Clear Tasks");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.addMouseListener(new MouseAdapter(){
        	@Override
            public void mousePressed(MouseEvent e) {
        		textArea.setText("");
            	}
            });
        subMenu.add(menuItem);
   
        //adding the About menu option
        subMenu = new JMenu("About");
        subMenu.setMnemonic(KeyEvent.VK_A);
        subMenu.getAccessibleContext();
        menuBar.add(subMenu);
        
        //adding User Agreement to the third menu option
        menuItem = new JMenuItem("User Agreement");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.addMouseListener(new MouseAdapter(){
        	@Override
            public void mousePressed(MouseEvent e) {
            	JFrame newFrame = new JFrame("User Agreement");
        		newFrame.setSize(300,300);
        		newFrame.getContentPane().setBackground(Color.white);
        		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		newFrame.setVisible(true);
            	}
            });
        subMenu.add(menuItem);
        
        //adding Version to the third menu option
        menuItem = new JMenuItem("Version");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.addMouseListener(new MouseAdapter(){
        	@Override
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
        textArea = new JTextArea();
        textArea.setEditable(false);
        
        //adding top title
        topLabel = new JLabel("Tasks");
        topLabel.setFont(font);
        topLabel.setHorizontalAlignment(JLabel.CENTER); //setting the title to center alignment
         
        //creating the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); // creating a new borderlayout
        mainPanel.setBounds(6, 3, 310, 20); // setting panel bounds
        mainPanel.setBackground(Color.WHITE); //setting background to white (more for ease of seeing where each panel is)
        mainPanel.add(topLabel, BorderLayout.CENTER); // adding the title and centering topLabel
        
        //adding the second panel
        secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());
        secondPanel.setBounds(10,10, 20,20);
        secondPanel.setBackground(Color.YELLOW); //Sets the secondPanel to yellow
        
        //adding the textField and area to the secondPanel
        textField.setBounds(3, 40, 317, 20);
        textArea.setBounds(3, 40, 317, 500); 
        secondPanel.add(textField, BorderLayout.AFTER_LAST_LINE);           
        secondPanel.add(textArea, BorderLayout.SOUTH);
        textField.addFocusListener(new FocusListener() { //highlights the textField when program for easy deletion
        	@Override
        	public void focusGained(FocusEvent e) {
        	    textField.selectAll(); 
        	}
        	@Override
        	public void focusLost(FocusEvent e) {

        	}
        	});       
        
        textField.addActionListener(new ActionListener() { // actionListener for when enter is clicked
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		int newNum = 0;
        		String text = textField.getText();
        		if (text.isEmpty() ||  text.trim().length() <= 0) {   // checks if the textField is empty or whitespace
        			textField.setText(""); //basically says 'do nothing'
        		}
        		else {
        			newNum++;
        			noteMap.put(newNum,text); //adding the task to the HashMap
        			numbInList++; //increments the task list 
        			textArea.append(numbInList + ":  " + text + newLine);
	        		textField.selectAll();
	        		textField.setText(""); //refreshing the textField
        		}     		
        	}
        });  	
        
        //Remove the item specified from the hashmap
       
        
        
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
	
	
	public static void changeFont (Component component, Font font) // changes font of a container and its children
	{
	    component.setFont (font);
	    if (component instanceof Container)
	    {
	        for (Component child : ((Container)component).getComponents()) // loops through the containers 
	        {
	            changeFont (child, font); //recursively changes font
	        }
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
}