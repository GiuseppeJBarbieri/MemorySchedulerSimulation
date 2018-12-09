package main_view.setup_app_node;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class shows the display setup app node for the GUI.
 * 
 */
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import main_view.director.Main_View_Director;
import main_view.memory_array_node.Display_Memory_Array_Node;

public class Display_Setup_App_Node {
	
	private Setup_App_Node_Controller controller;
	private VBox root;
	
	public Display_Setup_App_Node(Main_View_Director mainDirector, Display_Memory_Array_Node memArrayNode) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/setup_app_node/Setup_App_Node_Skin.fxml"));
			root = loader.load();
			controller = loader.getController();
			controller.setMemArrayNode(memArrayNode);
			controller.setDirectorMap(mainDirector);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public VBox getNode() {
		return root;
	}
}
