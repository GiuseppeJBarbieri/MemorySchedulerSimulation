package main_view.cpu_speed_partition_type_node;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Display_CPU_Speed_Partition_Type_Node {
	
	private CPU_Speed_Partition_Type_Node_Controller controller;
	private HBox root;
	public Display_CPU_Speed_Partition_Type_Node() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/cpu_speed_partition_type_node/CPU_Speed_Partition_Type_Node_Skin.fxml"));
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
