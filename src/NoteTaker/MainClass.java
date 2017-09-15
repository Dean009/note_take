package NoteTaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainClass {
	
	private static JPanel mainPanel;
	private static JFrame frame;
	private static JMenuBar menuBar;
	private static JMenu subMenu;
	private static JMenuItem menuItem;
	private static JRadioButtonMenuItem rbMenuItem;
	private static JCheckBoxMenuItem jcbMenuItem;
	
	
	public MainClass() {
		
	}

	public static void main(String[] args) {
		createWindow();
		
	}

	public static void createWindow() {
		//creating the frame 
		frame = new JFrame("PRO-Crastin8or");
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
        subMenu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
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
        subMenu = new JMenu("Settings");
        subMenu.setMnemonic(KeyEvent.VK_A);
        subMenu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        menuBar.add(subMenu);
        
        
        //third menu option
        subMenu = new JMenu("About");
        subMenu.setMnemonic(KeyEvent.VK_A);
        subMenu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        menuBar.add(subMenu);
        
        
        
        
        //creating the main panel
        mainPanel = new JPanel();
        mainPanel.setBounds(4, 3, 310, 200);
        mainPanel.setBackground(Color.WHITE);
        
        //adding the menu bar and the main panel to the frame
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
               
        // pack and display the frame
        frame.pack();
        frame.setVisible(true);
	}
	
	
	
	
	
}
