package main_view.add_process_node;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Display_Add_Process_Node {
	
	private Add_Process_Node_Controller controller;
	private VBox root;
	public Display_Add_Process_Node() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/add_process_node/Add_Process_Node_Skin.fxml"));
			root = loader.load();
			controller = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public VBox getNode() {
		return root;
	}
}
