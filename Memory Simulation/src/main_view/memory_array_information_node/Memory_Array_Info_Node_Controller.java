package main_view.memory_array_information_node;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class controls the display memory array info node for the GUI.
 * 
 */
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import main_view.director.Main_View_Director;

public class Memory_Array_Info_Node_Controller implements Initializable {

	@FXML
	private TextField freeBlocksTxt, memBlocksInUseTxt, timeElapsedTxt, cpuTimeElapsedTxt;

	private Main_View_Director directorMap;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void setfreeAndInUseBlocksTxt(String freeBlocks, String inUseBlocks) {
		freeBlocksTxt.setText(freeBlocks);
		memBlocksInUseTxt.setText(inUseBlocks);
	}
	public void setTimeElapsedTxt(int timeElapsed) {
		timeElapsedTxt.setText(Integer.toString(timeElapsed));
		cpuTimeElapsedTxt.setText(Integer.toString(timeElapsed * (int) directorMap.getCsptnC().getCpuSpeedChoice()));
	}
	public void setDirectorMap(Main_View_Director directorMap) {
		this.directorMap = directorMap;
		directorMap.setMainC(this);
	}

	public double getElapsedTimeTxt() {
		if(!timeElapsedTxt.getText().equals("")) {
			return Double.parseDouble(timeElapsedTxt.getText());
		}
		return 0;
	}
	
}
