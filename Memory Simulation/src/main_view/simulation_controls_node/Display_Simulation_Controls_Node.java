package main_view.simulation_controls_node;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Display_Simulation_Controls_Node {
	
	private Simulation_Controls_Node_Controller controller;
	private HBox root;
	public Display_Simulation_Controls_Node() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/simulation_controls_node/Simulation_Controls_Node_Skin.fxml"));
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