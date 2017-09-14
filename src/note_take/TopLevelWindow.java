package note_take;

import java.awt.*;
import javax.swing.*;

public class TopLevelWindow {
	
	private JFrame frame;
	private JLabel label1;
	
	// creates the window
	public static void createWindow() {	
		//creating the main frame
		JFrame frame = new JFrame("DAVE: Procrastin8r\r\n");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);	
		//adding a label
		JLabel label1 = new JLabel("A label on the window", SwingConstants.CENTER);
		label1.setPreferredSize(new Dimension(300, 100));
		
		//adding the frames
		frame.getContentPane().add(label1, BorderLayout.CENTER);
		
		//Display the window
		frame.setLocationRelativeTo(null);
		
		//looks to make sure that the screen is big enough to display the content
		frame.pack();
		
		//setting frame to visible
		frame.setVisible(true);
		
		
		
	}
	
	
	
}
