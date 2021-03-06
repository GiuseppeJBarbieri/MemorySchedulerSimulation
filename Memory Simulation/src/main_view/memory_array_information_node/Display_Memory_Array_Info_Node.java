package main_view.memory_array_information_node;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class shows the display memory array info node for the GUI.
 * 
 */
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import main_view.director.Main_View_Director;

public class Display_Memory_Array_Info_Node {
	
	private Memory_Array_Info_Node_Controller controller;
	private VBox root;
	
	public Display_Memory_Array_Info_Node(Main_View_Director directorMap) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/memory_array_information_node/Memory_Array_Info_Node_Skin.fxml"));
			root = loader.load();
			controller = loader.getController();
			controller.setDirectorMap(directorMap);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public VBox getNode() {
		return root;
	}
}
