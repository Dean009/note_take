package NoteTaker;

import javax.swing.*;
import java.awt.*;
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
            	}
            });
        subMenu.add(menuItem);
        
        
        
        
        
        //creating the main panel
        mainPanel = new JPanel();
        mainPanel.setBounds(4, 3, 310, 200);
        mainPanel.setBackground(Color.WHITE);
        
        //adding top title
        topLabel = new JLabel("Tasks to do");
        topLabel.setFont(font);

        //adding an underline to the topLabel
        makeFontUnderlined(topLabel);  
        
        //adding the menu bar and the main panel to the frame
        frame.setJMenuBar(menuBar);
        mainPanel.add(topLabel);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
               
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
	
	
	
}