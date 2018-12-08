package main_view.cpu_speed_partition_type_node;

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

	private Main_View_Director directorMap;
	private String[] partitionTypeList = { "Fixed Partitioning" };
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> partitionTypeObsList = FXCollections.observableArrayList(partitionTypeList);
		partitionTypeChoiceBox.setItems(partitionTypeObsList);
		partitionTypeChoiceBox.getSelectionModel().select(0);
	}

	public void setDirectorMap(Main_View_Director directorMap) {
		this.directorMap = directorMap;
		directorMap.setCsptnC(this);
	}

	public double getCpuSpeedChoice() {
		return cpuSpeedChoice.getValue();
	}
	
}
