package main_view.waiting_queue_node;

import java.net.URL;
import java.util.ArrayList;
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
	private ArrayList<Process_Object> waitingQueue;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Process_Object> tableList = FXCollections.observableArrayList(waitingQueue);
		waitingQueueTbl.setItems(tableList);
		initializeTblCol();
		waitingQueue = new ArrayList<>();
	}
	
	private void initializeTblCol() {
		burstCol.setCellValueFactory(new PropertyValueFactory<Process_Object, String>("burstSize"));
		processCol.setCellValueFactory(new PropertyValueFactory<Process_Object, String>("processId"));
		sizeCol.setCellValueFactory(new PropertyValueFactory<Process_Object, String>("processSize"));
	}

	public void updateWaitingQueue(ArrayList<Process_Object> queue) {
		ArrayList<String> processesUsed = new ArrayList<>();
		waitingQueue = queue;
		if (waitingQueue.size() < 15) {
			for (Process_Object e : waitingQueue) {
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

			for (String e : processesUsed) {
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

			if (directorMap.getSetupAppNodeCont().isYGenerateRBtnSelected()) {
				if (p1 == 0) {
					waitingQueue
							.add(new Process_Object("P1", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p2 == 0) {
					waitingQueue
							.add(new Process_Object("P2", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p3 == 0) {
					waitingQueue
							.add(new Process_Object("P3", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p4 == 0) {
					waitingQueue
							.add(new Process_Object("P4", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p5 == 0) {
					waitingQueue
							.add(new Process_Object("P5", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p6 == 0) {
					waitingQueue
							.add(new Process_Object("P6", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p7 == 0) {
					waitingQueue
							.add(new Process_Object("P7", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p8 == 0) {
					waitingQueue
							.add(new Process_Object("P8", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p9 == 0) {
					waitingQueue
							.add(new Process_Object("P9", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p10 == 0) {
					waitingQueue
							.add(new Process_Object("P10", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p11 == 0) {
					waitingQueue
							.add(new Process_Object("P11", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p12 == 0) {
					waitingQueue
							.add(new Process_Object("P12", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p13 == 0) {
					waitingQueue
							.add(new Process_Object("P13", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p14 == 0) {
					waitingQueue
							.add(new Process_Object("P14", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				} else if (p15 == 0) {
					waitingQueue
							.add(new Process_Object("P15", (Integer.toString((int) (Math.random() * 100 + 100))),
									(Integer.toString((int) (Math.random() * 100 + 10)))));
				}
			}
			
		}

		ObservableList<Process_Object> tableList = FXCollections.observableArrayList(waitingQueue);
		waitingQueueTbl.setItems(tableList);
	}

	private void presetInformation() {
		
		if (directorMap.getSetupAppNodeCont().isYPreloadRBtnSelected()) {
			waitingQueue.add(new Process_Object("P1", Integer.toString(130), Integer.toString(5)));
			waitingQueue.add(new Process_Object("P2", Integer.toString(230), Integer.toString(68)));
			waitingQueue.add(new Process_Object("P3", Integer.toString(330), Integer.toString(12)));
			waitingQueue.add(new Process_Object("P4", Integer.toString(420), Integer.toString(28)));
			waitingQueue.add(new Process_Object("P5", Integer.toString(140), Integer.toString(94)));
			waitingQueue.add(new Process_Object("P6", Integer.toString(200), Integer.toString(12)));
			waitingQueue.add(new Process_Object("P7", Integer.toString(500), Integer.toString(83)));
			waitingQueue.add(new Process_Object("P8", Integer.toString(540), Integer.toString(86)));
			waitingQueue.add(new Process_Object("P9", Integer.toString(220), Integer.toString(41)));
			waitingQueue.add(new Process_Object("P10", Integer.toString(490), Integer.toString(48)));
			waitingQueue.add(new Process_Object("P11", Integer.toString(280), Integer.toString(4)));
			waitingQueue.add(new Process_Object("P12", Integer.toString(160), Integer.toString(82)));
			waitingQueue.add(new Process_Object("P13", Integer.toString(300), Integer.toString(41)));
			waitingQueue.add(new Process_Object("P14", Integer.toString(540), Integer.toString(30)));
			waitingQueue.add(new Process_Object("P15", Integer.toString(130), Integer.toString(32)));
		}
		 
	}
	
	public void setDirectorMap(Main_View_Director directorMap) {
		this.directorMap = directorMap;
	}
}
