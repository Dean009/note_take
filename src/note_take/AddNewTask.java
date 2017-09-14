package note_take;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class AddNewTask {
	
	protected static JTextArea storedText;
	protected static JScrollPane topScrollPane;
	
	public AddNewTask() {
		
	}
	
	public void createTask() {
		//creating the saved tasks
		storedText = new JTextArea(5, 20);
		topScrollPane = new JScrollPane(storedText);
		storedText.setEditable(false);
	}
	

}
