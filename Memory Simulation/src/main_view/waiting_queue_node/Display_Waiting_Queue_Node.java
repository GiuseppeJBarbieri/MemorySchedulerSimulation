package main_view.waiting_queue_node;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Display_Waiting_Queue_Node {
	
	private Waiting_Queue_Node_Controller controller;
	
	public Display_Waiting_Queue_Node() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view.waiting_queue_box/Waiting_Queue_Box_Skin.fxml"));
			HBox root = loader.load();
			controller = loader.getController();
			vbox.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}