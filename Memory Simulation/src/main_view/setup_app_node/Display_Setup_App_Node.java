package main_view.setup_app_node;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Display_Setup_App_Node {
	
	private Setup_App_Node_Controller controller;
	private VBox root;
	
	public Display_Setup_App_Node() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/setup_app_node/Setup_App_Node_Skin.fxml"));
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
