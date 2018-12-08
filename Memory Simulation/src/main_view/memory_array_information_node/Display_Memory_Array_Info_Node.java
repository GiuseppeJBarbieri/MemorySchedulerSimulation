package main_view.memory_array_information_node;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Display_Memory_Array_Info_Node {
	
	private Memory_Array_Info_Node_Controller controller;
	private HBox root;
	
	public Display_Memory_Array_Info_Node() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/memory_array_information_node/Memory_Array_Info_Node_Skin.fxml"));
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
