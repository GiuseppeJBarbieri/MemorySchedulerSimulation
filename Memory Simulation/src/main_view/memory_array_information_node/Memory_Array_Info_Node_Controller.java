package main_view.memory_array_information_node;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import main_view.director.Main_View_Director;
import model.Segment_Object;

public class Memory_Array_Info_Node_Controller implements Initializable {

	@FXML
	private TextField freeBlocksTxt, memBlocksInUseTxt, timeElapsedTxt;
	
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
	}
	public void setDirectorMap(Main_View_Director directorMap) {
		this.directorMap = directorMap;
		directorMap.setMainC(this);
	}
	
}
