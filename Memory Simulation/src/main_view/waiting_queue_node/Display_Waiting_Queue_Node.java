package main_view.waiting_queue_node;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Display_Waiting_Queue_Node {
	
	private Waiting_Queue_Node_Controller controller;
	private HBox root;
	
	public Display_Waiting_Queue_Node() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/waiting_queue_node/Waiting_Queue_Node_Skin.fxml"));
			root = loader.load();
			controller = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public HBox getNode() {
		return root;
	}
}