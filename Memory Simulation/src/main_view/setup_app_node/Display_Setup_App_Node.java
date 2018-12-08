package main_view.setup_app_node;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Display_Setup_App_Node {
	
	private Setup_App_Node_Controller controller;
	
	public Display_Setup_App_Node() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view.setup_app_box/Setup_App_Box_Skin.fxml"));
			HBox root = loader.load();
			controller = loader.getController();
			setupSpotVBox.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
