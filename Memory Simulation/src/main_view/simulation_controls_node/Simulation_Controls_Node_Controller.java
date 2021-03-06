package main_view.simulation_controls_node;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class controls the simulation controls node for the GUI.
 * 
 */
import java.net.URL;
import java.util.ResourceBundle;

import alerts.Missing_Information_Alert;
import algorithm.First_Fit_Algorithm_Thread;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import main_view.director.Main_View_Director;
import main_view.memory_array_node.Display_Memory_Array_Node;
import model.Process_Object;

public class Simulation_Controls_Node_Controller implements Initializable {

	@FXML
	private Button startBtn, stopBtn, restartBtn, compactBtn;

	private VBox memoryBox;
	Display_Memory_Array_Node memArrayNode;

	private Main_View_Director directorMap;
	private First_Fit_Algorithm_Thread ffat;
	private Thread t;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startBtn.setOnAction(e -> startSimulation());
		stopBtn.setOnAction(e -> stopSimulation());
		restartBtn.setOnAction(e -> restartSimulation());
		compactBtn.setOnAction(e -> compactMemory());
	}

	/*
	 * Compacts memory when the compact memory button is clicked.
	 */
	private void compactMemory() {
		directorMap.getWaitingQueue().getMemCompChk().compactMemory();
	}
	/*
	 * This method restarts the simulation and resets all the information.
	 */
	private void restartSimulation() {
		compactBtn.setDisable(true);
		directorMap.getCsptnC().disableCpuSpeedChoice(false);
		directorMap.getSanC().disableSetMemorySizeBtn(false);
		stopBtn.setText("Stop Simulation");
		memoryBox.getChildren().clear();
		if (ffat != null) {
			ffat.stopQueue();
		}

		startBtn.setDisable(false);
		stopBtn.setDisable(true);
		directorMap.resetMemArrNode();
		directorMap.getWaitingQueue().clearWaitingQueue();
		directorMap.getWaitingQueue().updateWaitingQueue();
	}
	
	/*
	 * This method pauses the simulation and resumes the simulation.
	 */
	private void stopSimulation() {
		ffat.pauseQueue(directorMap.getCsptnC().getCpuSpeedChoice());
		if (stopBtn.getText().equals("Stop Simulation")) {
			stopBtn.setText("Resume Simulation");
			directorMap.getCsptnC().disableCpuSpeedChoice(false);
		} else {
			stopBtn.setText("Stop Simulation");
			directorMap.getCsptnC().disableCpuSpeedChoice(true);
		}
	}

	/*
	 * This method starts the simulation.
	 */
	private void startSimulation() {
		compactBtn.setDisable(false);
		directorMap.getCsptnC().disableCpuSpeedChoice(true);
		presetInformation();
		if (directorMap.getWaitingQueue().getSize() == 0) {
			new Missing_Information_Alert("No processes in the waiting queue. Please add a process before you being.");
		} else {
			directorMap.getSanC().setSetMemorySizeBtn("Stop Simulation");
			directorMap.getSanC().setTotalMemorySpace();
			stopBtn.setDisable(false);
			if (directorMap.getSanC().getTotalMemoryTxt().equals("")) {
				new Missing_Information_Alert("Missing memory array size!");
			} else {
				if (directorMap.getSanC().getAlgorithmChoiceBoxSelectedIndex() == 0) {
					ffat = new First_Fit_Algorithm_Thread(directorMap);
					directorMap.setFfat(ffat);
					t = new Thread(ffat);
					t.setDaemon(true);
					t.start();
				}
			}
			startBtn.setDisable(true);
		}
	}

	/*
	 * This method presets the waitingQueue information.
	 */
	private void presetInformation() {
		if (directorMap.getSanC().isYPreloadRBtnSelected()) {
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P1", Integer.toString(130), Integer.toString(5), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P2", Integer.toString(230), Integer.toString(68), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P3", Integer.toString(330), Integer.toString(12), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P4", Integer.toString(420), Integer.toString(28), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P5", Integer.toString(140), Integer.toString(94), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P6", Integer.toString(200), Integer.toString(12), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P7", Integer.toString(500), Integer.toString(83), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P8", Integer.toString(540), Integer.toString(86), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P9", Integer.toString(220), Integer.toString(41), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P10", Integer.toString(490), Integer.toString(48),Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P11", Integer.toString(280), Integer.toString(4), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P12", Integer.toString(160), Integer.toString(82),Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P13", Integer.toString(300), Integer.toString(41),Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P14", Integer.toString(540), Integer.toString(30),Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
			directorMap.getWaitingQueue()
					.addToQueue(new Process_Object("P15", Integer.toString(130), Integer.toString(32),Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
		}

		directorMap.getWaitingQueue().updateWaitingQueueTbl();
	}

	public void setDirectorMap(Main_View_Director directorMap) {
		this.directorMap = directorMap;
		directorMap.setScnC(this);
	}

	public First_Fit_Algorithm_Thread getFFAThread() {
		return ffat;
	}

	public void setMemoryBox(VBox memoryBox, Display_Memory_Array_Node memArrayNode) {
		this.memoryBox = memoryBox;
		this.memArrayNode = memArrayNode;
	}

}
