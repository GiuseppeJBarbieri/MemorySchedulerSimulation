package main_view.cpu_speed_partition_type_node;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

public class CPU_Speed_Partition_Type_Node_Controller implements Initializable {
	@FXML
	private Slider cpuSpeedChoice;
	@FXML
	private ChoiceBox<String> partitionTypeChoiceBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
