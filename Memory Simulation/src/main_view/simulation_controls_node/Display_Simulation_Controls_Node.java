package main_view.simulation_controls_node;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main_view.director.Main_View_Director;

public class Display_Simulation_Controls_Node {
	
	private Simulation_Controls_Node_Controller controller;
	private VBox root;
	public Display_Simulation_Controls_Node(Main_View_Director directorMap) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/simulation_controls_node/Simulation_Controls_Node_Skin.fxml"));
			root = loader.load();
			controller = loader.getController();
			controller.setDirectorMap(directorMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public VBox getNode() {
		return root;
	}
}