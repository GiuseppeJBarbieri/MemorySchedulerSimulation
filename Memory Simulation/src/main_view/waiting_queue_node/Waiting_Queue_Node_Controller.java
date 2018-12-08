package main_view.waiting_queue_node;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main_view.director.Main_View_Director;
import model.Process_Object;

public class Waiting_Queue_Node_Controller implements Initializable {

	@FXML
	private TableView<Process_Object> waitingQueueTbl;
	@FXML
	private TableColumn<Process_Object, String> processCol, sizeCol, burstCol;
	
	private Main_View_Director directorMap;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeTblCol();
	}
	
	private void initializeTblCol() {
		burstCol.setCellValueFactory(new PropertyValueFactory<Process_Object, String>("burstSize"));
		processCol.setCellValueFactory(new PropertyValueFactory<Process_Object, String>("processId"));
		sizeCol.setCellValueFactory(new PropertyValueFactory<Process_Object, String>("processSize"));
	}


	public void setDirectorMap(Main_View_Director directorMap) {
		this.directorMap = directorMap;
		directorMap.setWqnC(this);
	}
	
	public TableView<Process_Object> getWaitingQueueTbl() {
		return waitingQueueTbl;
	}
}
