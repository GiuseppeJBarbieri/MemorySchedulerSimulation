package main_view.add_process_node;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class shows the add process node for the GUI.
 * 
 */
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import main_view.director.Main_View_Director;

public class Display_Add_Process_Node {
	
	private Add_Process_Node_Controller controller;
	private VBox root;
	public Display_Add_Process_Node(Main_View_Director directorMap) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/add_process_node/Add_Process_Node_Skin.fxml"));
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
