package main_view.simulation_controls_node;

import java.net.URL;
import java.util.ResourceBundle;

import alerts.Missing_Information_Alert;
import algorithm.First_Fit_Algorithm_Thread;
import controller.FFA_To_MemArrView_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main_view.director.Main_View_Director;
import main_view.memory_array_node.Display_Memory_Array_Node;
import model.Process_Object;

public class Simulation_Controls_Node_Controller implements Initializable {
	
	@FXML
	private Button startBtn, stopBtn, restartBtn, compactBtn;
	
	private Main_View_Director directorMap;
	private First_Fit_Algorithm_Thread ffat;
	private Thread t;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startBtn.setOnAction(e -> startSimulation());
		stopBtn.setOnAction(e -> stopSimulation());
		restartBtn.setOnAction(e -> restartSimulation());
	}

	private void restartSimulation() {
		directorMap.getSetupAppNodeCont().disableSetMemorySizeBtn(false);
		stopBtn.setText("Stop Simulation");
		memoryBox.getChildren().clear();
		ffat.stopQueue();
		startBtn.setDisable(false);
		stopBtn.setDisable(true);
		memArrayNode = new Display_Memory_Array_Node(memoryBox);
		waitingQueue.clear();
		ObservableList<Process_Object> tableList = FXCollections.observableArrayList(waitingQueue);
		waitingQueueTbl.setItems(tableList);

	}
	
	private void stopSimulation() {
		ffat.pauseQueue(cpuSpeedChoice.getValue());
		if (stopBtn.getText().equals("Stop Simulation")) {
			stopBtn.setText("Resume Simulation");
		} else {
			stopBtn.setText("Stop Simulation");
		}
	}

	private void startSimulation() {
		presetInformation();
		if (waitingQueue.size() == 0) {
			new Missing_Information_Alert("No processes in the waiting queue. Please add a process before you being.");
		} else {
			setMemorySizeBtn.setText("Stop Simulation");
			setMemorySizeBtn.setDisable(true);
			setTotalMemorySpace();
			stopBtn.setDisable(false);
			if (totalMemoryTxt.equals("")) {
				new Missing_Information_Alert("Missing memory array size!");
			} else {
				if (algorithmChoiceBox.getSelectionModel().getSelectedIndex() == 0) {
					FFA_To_MemArrView_Controller ffamavCont = new FFA_To_MemArrView_Controller(ffat, memArrayNode);
					ffat = new First_Fit_Algorithm_Thread(this, waitingQueue, totalMemoryTxt.getText(),
							cpuSpeedChoice.getValue(), ffamavCont);

					t = new Thread(ffat);
					t.setDaemon(true);
					t.start();
				}
			}
			startBtn.setDisable(true);
		}
	}

	public void setDirectorMap(Main_View_Director directorMap) {
		this.directorMap = directorMap;
	}
	
}
