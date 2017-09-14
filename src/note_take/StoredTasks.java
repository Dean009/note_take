package note_take;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class StoredTasks {

	protected static JPanel mainPanel;
	protected static javax.swing.border.Border blackline;
	
	public StoredTasks() {
		
	}
	
	
	public void createTaskWindow(){
		//creating the already stored tasks
		mainPanel = new JPanel();
		
		//setting panel size/background and making it visible
		mainPanel.setSize(new Dimension(330, 290));
		blackline = BorderFactory.createLineBorder(Color.black);
		//	mainPanel.setBorder(blackline);
		mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		mainPanel.setVisible(true);
	}
	
}
