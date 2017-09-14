package note_take;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainFrame {
	
	protected static JFrame frame;

	protected static JPanel mainPanel;
	
	
	public MainFrame() {
		
	}
	
	// creates the window
	public static void createWindow() {	
		
		//creating the main frame
		frame = new JFrame("Pro-crastin8r");// main title of the program
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);	// adds a way to close the program
		
		//Display the window
		frame.setLocationRelativeTo(null);
		
		//looks to make sure that the screen is big enough to display the content
		frame.pack();
		
		//setting frame to visible and the size
		frame.setSize(360,700);
		frame.setVisible(true);
				
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
