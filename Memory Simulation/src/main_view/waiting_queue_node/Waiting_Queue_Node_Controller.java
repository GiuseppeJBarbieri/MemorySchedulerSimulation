package main_view.waiting_queue_node;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Process_Object;

public class Waiting_Queue_Node_Controller implements Initializable {

	@FXML
	private TableView<Process_Object> waitingQueueTbl;
	@FXML
	private TableColumn<Process_Object, String> processCol, sizeCol, burstCol;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
