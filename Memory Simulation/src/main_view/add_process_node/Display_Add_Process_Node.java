package main_view.add_process_node;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Display_Add_Process_Node {
	
	private Add_Process_Node_Controller controller;
	
	public Display_Add_Process_Node() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view.add_process_box/Add_Process_Box_Skin.fxml"));
			HBox root = loader.load();
			controller = loader.getController();
			vbox.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
