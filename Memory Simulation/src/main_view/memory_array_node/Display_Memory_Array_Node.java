package main_view.memory_array_node;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main_view.director.Main_View_Director;
import model.Segment_Object;

/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class loads the Memory Array Node that is used to show 
 * the processes and memory segments as they move in and out of memory.
 * 
 */

public class Display_Memory_Array_Node {
	private Memory_Array_Node_Controller controller;

	public Display_Memory_Array_Node(VBox memArrBox) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/memory_array_node/Memory_Array_Skin.fxml"));
			HBox root = loader.load();
			controller = loader.getController();
			memArrBox.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void setMemBlockSizeTxtFields(ArrayList<Segment_Object> segmentList) {
		controller.setMemBlockTxtFields(segmentList);
	}

	public void setFreeSpaceInformation(String text) {
		controller.setFreeSpaceInformation(text);
	}

	public void startDisplayingMemBlocks(ArrayList<Segment_Object> segmentList) {
		controller.startDisplayingMemBlocks(segmentList);
	}

}
