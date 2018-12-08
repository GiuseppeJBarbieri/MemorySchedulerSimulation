package main_view.add_process_node;

import java.net.URL;
import java.util.ResourceBundle;

import alerts.Missing_Information_Alert;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Process_Object;

public class Add_Process_Node_Controller implements Initializable {
	@FXML
	private ChoiceBox<String> processIdChoiceBox;
	@FXML
	private TextField processSizeTxt, burstTimeTxt;
	@FXML
	private Button addProcessBtn;

	private String[] processList = { "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", "P11", "P12", "P13",
			"P14", "P15", };
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> processObsList = FXCollections.observableArrayList(processList);
		processIdChoiceBox.setItems(processObsList);
		processIdChoiceBox.getSelectionModel().select(0);
		textFieldListener();
		
		//addProcessBtn.setOnAction(e -> addProcessToWaitingQueue());
	}
	
	private void textFieldListener() {
		processSizeTxt.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					processSizeTxt.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		
		burstTimeTxt.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					burstTimeTxt.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
	}
/*
	private void addProcessToWaitingQueue() {

		if (processSizeTxt.getText().equals("") || burstTimeTxt.getText().equals("")) {
			new Missing_Information_Alert("Missing process information.");

		} else {
			if (checkIfProccessInWaitingQueue(processIdChoiceBox.getSelectionModel().getSelectedItem()) == true) {
				new Missing_Information_Alert("Process already in waiting queue!");
			} else {
				if (ffat != null) {
					ffat.updateWaitingQueue(
							new Process_Object(processIdChoiceBox.getSelectionModel().getSelectedItem(),
									processSizeTxt.getText(), burstTimeTxt.getText()));
				}
				ObservableList<Process_Object> tableList = FXCollections.observableArrayList(waitingQueue);
				waitingQueueTbl.setItems(tableList);
			}
		}
	}
	
	private boolean checkIfProccessInWaitingQueue(String processId) {
		for (Process_Object e : waitingQueue) {
			if (e.getProcessId().equals(processId)) {
				return true;
			}
		}
		return false;
	}
	*/
}
