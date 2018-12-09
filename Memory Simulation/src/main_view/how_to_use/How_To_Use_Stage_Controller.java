package main_view.how_to_use;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class controls the how touse stage node for the GUI.
 * 
 */
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class How_To_Use_Stage_Controller implements Initializable {

	@FXML
	private TextArea howToTextArea;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setTextArea();
	}

	private void setTextArea() {
		howToTextArea.appendText("How to Use\n\n");
		
		howToTextArea.appendText("\t1. Start by selecting an algorithm.\n");
		howToTextArea.appendText("\t2. Select a partition size type.\n");
		howToTextArea.appendText("\t3. Enter the memory size (can’t be less than 1024kb (1mb) or greater than 4096 (4mb)).\n");
		howToTextArea.appendText("\t4. Select if you want to preload waiting queue with random processes.\n");
		howToTextArea.appendText("\t5. Select if you want to generate new processes as the simulation continues.\n");
		howToTextArea.appendText("\t6. If you choose not to preload the waiting queue you can enter in processes.\n");
		howToTextArea.appendText("\t7. Also select the CPU speed and partitioning type.\n");
		
	}
	
}
