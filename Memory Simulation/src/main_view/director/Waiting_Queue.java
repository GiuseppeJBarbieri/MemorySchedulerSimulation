package main_view.director;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class controls the waiting queue array. Each node or any class in that fact uses this class to access the waiting queue list.
 * 
 */
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Process_Object;

public class Waiting_Queue {

	private ArrayList<Process_Object> waitingQueue;
	private Main_View_Director directorMap;
	private Memory_Compaction_Checker memCompChck;

	public Waiting_Queue(Main_View_Director directorMap) {
		waitingQueue = new ArrayList<>();
		this.directorMap = directorMap;
		this.memCompChck = new Memory_Compaction_Checker(directorMap);
	}

	public ArrayList<Process_Object> getWaitingQueue() {
		return waitingQueue;
	}

	public void setWaitingQueue(ArrayList<Process_Object> waitingQueue) {
		this.waitingQueue = waitingQueue;
	}

	public void addToQueue(Process_Object process) {
		waitingQueue.add(process);
	}

	public int getSize() {
		return waitingQueue.size();
	}

	public void clearWaitingQueue() {
		waitingQueue.clear();
	}

	public void updateWaitingQueueTbl() {
		ObservableList<Process_Object> tableList = FXCollections.observableArrayList(waitingQueue);
		directorMap.getWqnC().getWaitingQueueTbl().setItems(tableList);
	}

	public Memory_Compaction_Checker getMemCompChk() {
		return memCompChck;
	}
	
	public void updateWaitingQueue() {
			ArrayList<String> processesUsed = new ArrayList<>();
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

				//This starts generating processes.
				if (directorMap.getSanC().isYGenerateRBtnSelected()) {
					if (p1 == 0) {
						waitingQueue.add(new Process_Object("P1", (Integer.toString((int) (Math.random() * 100 + 100))),
								(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p2 == 0) {
						waitingQueue.add(new Process_Object("P2", (Integer.toString((int) (Math.random() * 100 + 100))),
								(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p3 == 0) {
						waitingQueue.add(new Process_Object("P3", (Integer.toString((int) (Math.random() * 100 + 100))),
								(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p4 == 0) {
						waitingQueue.add(new Process_Object("P4", (Integer.toString((int) (Math.random() * 100 + 100))),
								(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p5 == 0) {
						waitingQueue.add(new Process_Object("P5", (Integer.toString((int) (Math.random() * 100 + 100))),
								(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p6 == 0) {
						waitingQueue.add(new Process_Object("P6", (Integer.toString((int) (Math.random() * 100 + 100))),
								(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p7 == 0) {
						waitingQueue.add(new Process_Object("P7", (Integer.toString((int) (Math.random() * 100 + 100))),
								(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p8 == 0) {
						waitingQueue.add(new Process_Object("P8", (Integer.toString((int) (Math.random() * 100 + 100))),
								(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p9 == 0) {
						waitingQueue.add(new Process_Object("P9", (Integer.toString((int) (Math.random() * 100 + 100))),
								(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p10 == 0) {
						waitingQueue
								.add(new Process_Object("P10", (Integer.toString((int) (Math.random() * 100 + 100))),
										(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p11 == 0) {
						waitingQueue
								.add(new Process_Object("P11", (Integer.toString((int) (Math.random() * 100 + 100))),
										(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p12 == 0) {
						waitingQueue
								.add(new Process_Object("P12", (Integer.toString((int) (Math.random() * 100 + 100))),
										(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p13 == 0) {
						waitingQueue
								.add(new Process_Object("P13", (Integer.toString((int) (Math.random() * 100 + 100))),
										(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p14 == 0) {
						waitingQueue
								.add(new Process_Object("P14", (Integer.toString((int) (Math.random() * 100 + 100))),
										(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					} else if (p15 == 0) {
						waitingQueue
								.add(new Process_Object("P15", (Integer.toString((int) (Math.random() * 100 + 100))),
										(Integer.toString((int) (Math.random() * 100 + 10))), Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt())));
					}
					
				}

			}

			directorMap.getWaitingQueue().updateWaitingQueueTbl();

	}
}
