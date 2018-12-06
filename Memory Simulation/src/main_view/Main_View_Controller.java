package main_view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import alerts.Missing_Information_Alert;
import algorithm.First_Fit_Algorithm_Thread;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import memory_array_view.Display_Memory_Array_Node;
import model.Waiting_Process_Obj;

public class Main_View_Controller implements Initializable {

	@FXML
	private Button addProcessBtn, compactBtn, restartBtn, startBtn, stopBtn;
	@FXML
	private ChoiceBox<String> algorithmChoiceBox, processIdChoiceBox;
	@FXML
	private TableColumn<Waiting_Process_Obj, String> burstCol, processCol, sizeCol;
	@FXML
	private TextField totalMemoryTxt, processSizeTxt, burstTimeTxt;
	@FXML
	private TableView<Waiting_Process_Obj> waitingQueueTbl;
	@FXML
	private Slider cpuSpeedChoice;
	@FXML
	private VBox memoryBox;
	
	private String[] processList = { "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", "P11", "P12", "P13",
			"P14", "P15", };
	private String[] algorithmList = { "First-Fit", "Best-Fit", "Worst-Fit" };
	private ArrayList<Waiting_Process_Obj> waitingQueue;
	private First_Fit_Algorithm_Thread ffat;
	private Thread t;
	private Display_Memory_Array_Node memArrayNode;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		waitingQueue = new ArrayList<>();
		initializeTblCol();
		initializeChoiceBox();
		textFieldInitialization();
		algorithmChoiceBox.getSelectionModel().select(0);
		processIdChoiceBox.getSelectionModel().select(0);
		addProcessBtn.setOnAction(e -> addProcessToWaitingQueue());
		startBtn.setOnAction(e -> startSimulation());
		stopBtn.setOnAction(e -> stopSimulation());
		
		
		for(int i = 0; i < 15; i++) {
			processIdChoiceBox.getSelectionModel().select(i);
			String process = processIdChoiceBox.getSelectionModel().getSelectedItem();
			int size = (int) (Math.random()*100);
			int burst = (int) (Math.random()*100);
			waitingQueue.add(new Waiting_Process_Obj(process, Integer.toString(size), Integer.toString(burst)));
		}
		ObservableList<Waiting_Process_Obj> tableList = FXCollections.observableArrayList(waitingQueue);
		waitingQueueTbl.setItems(tableList);
		totalMemoryTxt.setText("600");
	}
	
	public void updateWaitingQueue(ArrayList<Waiting_Process_Obj> queue) {
		waitingQueue = queue;
		ObservableList<Waiting_Process_Obj> tableList = FXCollections.observableArrayList(waitingQueue);
		waitingQueueTbl.setItems(tableList);
	}
	private void stopSimulation() {
		System.out.println("Stopped");
		//ffat.stopQueue();
		ffat.pauseQueue();
		if(stopBtn.getText().equals("Stop Simulation")) {
			stopBtn.setText("Resume Simulation");
		} else {
			stopBtn.setText("Stop Simulation");
		}
	}
	private void startSimulation() {
		stopBtn.setDisable(false);
		System.out.println("Starting...");
		if(totalMemoryTxt.equals("") ) {
			new Missing_Information_Alert("Missing memory array size!");
		} else {
			if(algorithmChoiceBox.getSelectionModel().getSelectedIndex() == 0) {
				ffat = new First_Fit_Algorithm_Thread(this, waitingQueue, totalMemoryTxt.getText(), cpuSpeedChoice.getValue());
				t = new Thread(ffat);
				t.setDaemon(true);
				t.start();
			}
		}
		startBtn.setDisable(true);
	}

	private void addProcessToWaitingQueue() {
		memArrayNode = new Display_Memory_Array_Node(memoryBox);
		
		if (processSizeTxt.getText().equals("") || burstTimeTxt.getText().equals("")) {
			new Missing_Information_Alert("Missing process information.");

		} else {
			if (checkIfProccessInWaitingQueue(processIdChoiceBox.getSelectionModel().getSelectedItem()) == true) {
				new Missing_Information_Alert("Process already in waiting queue!");
			} else {
				//waitingQueue.add(new Waiting_Process_Obj(processIdChoiceBox.getSelectionModel().getSelectedItem(),
					//	processSizeTxt.getText(), burstTimeTxt.getText()));
				if(ffat != null) {
					ffat.updateWaitingQueue(new Waiting_Process_Obj(processIdChoiceBox.getSelectionModel().getSelectedItem(),
							processSizeTxt.getText(), burstTimeTxt.getText()));
				}
				ObservableList<Waiting_Process_Obj> tableList = FXCollections.observableArrayList(waitingQueue);
				waitingQueueTbl.setItems(tableList);
			}
		}
	}

	private boolean checkIfProccessInWaitingQueue(String processId) {
		for(Waiting_Process_Obj e : waitingQueue) {
			if(e.getProcessId().equals(processId)) {
				return true;
			}
		}
		return false;
	}
	
	private void textFieldInitialization() {
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

	private void initializeChoiceBox() {
		ObservableList<String> processObsList = FXCollections.observableArrayList(processList);
		processIdChoiceBox.setItems(processObsList);
		ObservableList<String> algorithmObsList = FXCollections.observableArrayList(algorithmList);
		algorithmChoiceBox.setItems(algorithmObsList);
	}

	private void initializeTblCol() {
		burstCol.setCellValueFactory(new PropertyValueFactory<Waiting_Process_Obj, String>("burstSize"));
		processCol.setCellValueFactory(new PropertyValueFactory<Waiting_Process_Obj, String>("processId"));
		sizeCol.setCellValueFactory(new PropertyValueFactory<Waiting_Process_Obj, String>("processSize"));
	}
}
