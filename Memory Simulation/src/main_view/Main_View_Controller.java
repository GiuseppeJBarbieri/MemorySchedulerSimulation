package main_view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import alerts.Missing_Information_Alert;
import algorithm.First_Fit_Algorithm_Thread;
import controller.FFA_To_MemArrView_Controller;
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
import model.Segment_Object;
import model.Waiting_Process_Obj;

public class Main_View_Controller implements Initializable {

	@FXML
	private Button addProcessBtn, compactBtn, restartBtn, startBtn, stopBtn;
	@FXML
	private ChoiceBox<String> algorithmChoiceBox, processIdChoiceBox, partitionTypeChoiceBox,
			partitionSizeTypeChoiceBox;
	@FXML
	private TableColumn<Waiting_Process_Obj, String> burstCol, processCol, sizeCol;
	@FXML
	private TextField freeBlocksTxt, memBlocksInUseTxt, totalMemoryTxt, processSizeTxt, burstTimeTxt, timeElapsedTxt;
	@FXML
	private TableView<Waiting_Process_Obj> waitingQueueTbl;
	@FXML
	private Slider cpuSpeedChoice;
	@FXML
	private VBox memoryBox;

	private String[] processList = { "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", "P11", "P12", "P13",
			"P14", "P15", };
	private String[] algorithmList = { "First-Fit", "Best-Fit", "Worst-Fit" };
	private String[] partitionTypeList = { "Fixed Partitioning" };
	private String[] partitionSizeTypeList = { "Equal", "Unequal" };
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
		partitionTypeChoiceBox.getSelectionModel().select(0);
		// Setup tooltip that says if it's equal it will equally assign each partition
		// size
		// to the size of the biggest process running (maybe adjust the memory size
		// accordingly)
		partitionSizeTypeChoiceBox.getSelectionModel().select(0);

		addProcessBtn.setOnAction(e -> addProcessToWaitingQueue());
		startBtn.setOnAction(e -> startSimulation());
		stopBtn.setOnAction(e -> stopSimulation());

		memArrayNode = new Display_Memory_Array_Node(memoryBox);

		for (int i = 0; i < 15; i++) {
			processIdChoiceBox.getSelectionModel().select(i);
			String process = processIdChoiceBox.getSelectionModel().getSelectedItem();
			int size = (int) (Math.random() * 100);
			int burst = (int) (Math.random() * 100);
			waitingQueue.add(new Waiting_Process_Obj(process, Integer.toString(size), Integer.toString(burst)));
		}

		ObservableList<Waiting_Process_Obj> tableList = FXCollections.observableArrayList(waitingQueue);
		waitingQueueTbl.setItems(tableList);
		totalMemoryTxt.setText("600");

	}

	public void setfreeAndInUseBlocksTxt(String freeBlocks, String inUseBlocks) {
		freeBlocksTxt.setText(freeBlocks);
		memBlocksInUseTxt.setText(inUseBlocks);
	}

	public void updateWaitingQueue(ArrayList<Waiting_Process_Obj> queue) {
		ArrayList<String> processesUsed = new ArrayList<>();
		waitingQueue = queue;
		if (waitingQueue.size() < 15) {
			for(Waiting_Process_Obj e : waitingQueue) {
				processesUsed.add(e.getProcessId());
			}
			int p1 = 0;
			int p2 = 0;
			int p3 = 0;
			int p4 = 0;
			int p5 = 0;
			int p6 = 0;
			int p7 = 0;
			int p8 = 0;
			int p9 = 0;
			int p10 = 0;
			int p11 = 0;
			int p12 = 0;
			int p13 = 0;
			int p14 = 0;
			int p15 = 0;
			
			for(String e : processesUsed) {
				if (e.equals("P1")) {
					p1 = 1;
				} else if (e.equals("P2")) {
					p2 = 1;
				} else if (e.equals("P3")) {
					p3 = 1;
				} else if (e.equals("P4")) {
					p4 = 1;
				} else if (e.equals("P5")) {
					p5 = 1;
				} else if (e.equals("P6")) {
					p6 = 1;
				} else if (e.equals("P7")) {
					p7 = 1;
				} else if (e.equals("P8")) {
					p8 = 1;
				} else if (e.equals("P9")) {
					p9 = 1;
				} else if (e.equals("P10")) {
					p10 = 1;
				} else if (e.equals("P11")) {
					p11 = 1;
				} else if (e.equals("P12")) {
					p12 = 1;
				} else if (e.equals("P13")) {
					p13 = 1;
				} else if (e.equals("P14")) {
					p14 = 1;
				} else if (e.equals("P15")) {
					p15 = 1;
				}
			}
			
			if (p1 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P1", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p2 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P2", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p3 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P3", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p4 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P4", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p5 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P5", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p6 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P6", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p7 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P7", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p8 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P8", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p9 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P9", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p10 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P10", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p11 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P11", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p12 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P12", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p13 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P13", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p14 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P14", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			} else if (p15 == 0) {
				waitingQueue.add(new Waiting_Process_Obj("P15", (Integer.toString((int) (Math.random() * 100 + 100))),
						(Integer.toString((int) (Math.random() * 100 + 10)))));
			}
			
			
		}

		ObservableList<Waiting_Process_Obj> tableList = FXCollections.observableArrayList(waitingQueue);
		waitingQueueTbl.setItems(tableList);
	}

	private void stopSimulation() {
		// ffat.stopQueue();
		ffat.pauseQueue(cpuSpeedChoice.getValue());
		if (stopBtn.getText().equals("Stop Simulation")) {
			stopBtn.setText("Resume Simulation");
		} else {
			stopBtn.setText("Stop Simulation");
		}
	}

	private void startSimulation() {
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

	private void addProcessToWaitingQueue() {

		if (processSizeTxt.getText().equals("") || burstTimeTxt.getText().equals("")) {
			new Missing_Information_Alert("Missing process information.");

		} else {
			if (checkIfProccessInWaitingQueue(processIdChoiceBox.getSelectionModel().getSelectedItem()) == true) {
				new Missing_Information_Alert("Process already in waiting queue!");
			} else {
				if (ffat != null) {
					ffat.updateWaitingQueue(
							new Waiting_Process_Obj(processIdChoiceBox.getSelectionModel().getSelectedItem(),
									processSizeTxt.getText(), burstTimeTxt.getText()));
				}
				ObservableList<Waiting_Process_Obj> tableList = FXCollections.observableArrayList(waitingQueue);
				waitingQueueTbl.setItems(tableList);
			}
		}
	}

	private boolean checkIfProccessInWaitingQueue(String processId) {
		for (Waiting_Process_Obj e : waitingQueue) {
			if (e.getProcessId().equals(processId)) {
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
		ObservableList<String> partitionTypeObsList = FXCollections.observableArrayList(partitionTypeList);
		partitionTypeChoiceBox.setItems(partitionTypeObsList);
		ObservableList<String> partitionSizeTypeObsList = FXCollections.observableArrayList(partitionSizeTypeList);
		partitionSizeTypeChoiceBox.setItems(partitionSizeTypeObsList);
	}

	private void initializeTblCol() {
		burstCol.setCellValueFactory(new PropertyValueFactory<Waiting_Process_Obj, String>("burstSize"));
		processCol.setCellValueFactory(new PropertyValueFactory<Waiting_Process_Obj, String>("processId"));
		sizeCol.setCellValueFactory(new PropertyValueFactory<Waiting_Process_Obj, String>("processSize"));
	}

	public void setTimeElapsedTxt(int timeElapsed) {
		timeElapsedTxt.setText(Integer.toString(timeElapsed));
	}
}
