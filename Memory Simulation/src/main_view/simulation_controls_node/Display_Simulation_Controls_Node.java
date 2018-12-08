package main_view.simulation_controls_node;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Display_Simulation_Controls_Node {
	
	private Simulation_Controls_Node_Controller controller;
	
	public Display_Simulation_Controls_Node() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view.simulation_controls_box/Simulation_Controls_Box_Skin.fxml"));
			HBox root = loader.load();
			controller = loader.getController();
			vbox.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}