package note_take;

import java.awt.*;
import javax.swing.*;

public class TopLevelWindow {
	
	protected static JFrame frame;
	protected static JLabel label1;
	protected static JTextArea storedText;
	protected static JScrollPane topScrollPane;
	protected static JPanel mainPanel;
	
	// creates the window
	public static void createWindow() {	
		
		//creating the main frame
		frame = new JFrame("Pro-crastin8r");// main title of the program
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);	// adds a way to close the program
		//adding a label
		label1 = new JLabel("A label on the window");
		label1.setPreferredSize(new Dimension(300, 100));
		frame.getContentPane().add(label1, BorderLayout.CENTER);
		
		//Display the window
		frame.setLocationRelativeTo(null);
		
		//looks to make sure that the screen is big enough to display the content
		frame.pack();
		
		//setting frame to visible and the size
		frame.setSize(360,700);
		frame.setVisible(true);
				
		//creating the already stored tasks
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(5, 5));
		mainPanel.setBackground(Color.LIGHT_GRAY);
		
		//creating the saved tasks
		storedText = new JTextArea(5, 20);
		topScrollPane = new JScrollPane(storedText);
		storedText.setEditable(false);
		
		// adding the components
		frame.add(mainPanel).setBackground(Color.GRAY); // add the MainPanel to the frame
		mainPanel.add(storedText).setVisible(true); // adds to the mainPanel
		
		
		
		
	}
	
	
	
}
