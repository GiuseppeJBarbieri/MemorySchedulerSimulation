package main_view.cpu_speed_partition_type_node;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class controls the cpu speed and partition
 * node for the GUI.
 * 
 */
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import main_view.director.Main_View_Director;

public class CPU_Speed_Partition_Type_Node_Controller implements Initializable {
	@FXML
	private Slider cpuSpeedChoice;
	@FXML
	private ChoiceBox<String> partitionTypeChoiceBox;

	private String[] partitionTypeList = { "Fixed Partitioning" };
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> partitionTypeObsList = FXCollections.observableArrayList(partitionTypeList);
		partitionTypeChoiceBox.setItems(partitionTypeObsList);
		partitionTypeChoiceBox.getSelectionModel().select(0);
	}

	public void setDirectorMap(Main_View_Director directorMap) {
		directorMap.setCsptnC(this);
	}

	public double getCpuSpeedChoice() {
		return cpuSpeedChoice.getValue();
	}
	public void disableCpuSpeedChoice(boolean b) {
		cpuSpeedChoice.setDisable(b);
	}
	
}
