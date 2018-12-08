package main_view.memory_array_information;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Display_Memory_Array_Info_Node {
	
	private Memory_Array_Info_Node_Controller controller;
	
	public Display_Memory_Array_Info_Node() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view.memory_array_information/Memory_Array_Info_Box_Skin.fxml"));
			HBox root = loader.load();
			controller = loader.getController();
			vbox.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
