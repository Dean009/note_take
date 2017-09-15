package NoteTaker;

import javax.swing.*;
import java.awt.*;

public class MainClass {
	
	private static JPanel mainPanel;
	private static JFrame frame;
	private static JMenuBar menuBar;
	
	
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
     
        menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(200,20));         
        menuBar.setBackground(Color.LIGHT_GRAY);
        
        mainPanel = new JPanel();
        mainPanel.setBounds(4, 3, 310, 200);
        mainPanel.setBackground(Color.WHITE);
              
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
               
        // pack and display the frame
        frame.pack();
        frame.setVisible(true);
	}
	
	
	
	
	
}
