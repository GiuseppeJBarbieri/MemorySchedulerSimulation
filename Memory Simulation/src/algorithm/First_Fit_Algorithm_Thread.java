package algorithm;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import controller.FFA_To_MemArrView_Controller;
import javafx.application.Platform;
import main_view.main.Main_View_Controller;
import model.Segment_Object;
import model.Process_Object;

public class First_Fit_Algorithm_Thread implements Runnable {

	private ArrayList<Process_Object> waitingQueue;
	private String totalMemorySize;
	private Double cpuSpeed;
	private ArrayList<Segment_Object> segmentList;
	private boolean stopQueue = false;
	private boolean pauseQueue = false;
	private Main_View_Controller main_View_Controller;
	private int timeElapsed;
	private FFA_To_MemArrView_Controller ffamavCont;
	private int freeMemBlocks;
	private int inUseMemBlocks;

	public First_Fit_Algorithm_Thread(Main_View_Controller main_View_Controller,
			ArrayList<Process_Object> waitingQueue, String totalMemorySize, Double cpuSpeed,
			FFA_To_MemArrView_Controller ffamavCont) {
		timeElapsed = 0;
		this.main_View_Controller = main_View_Controller;
		this.waitingQueue = waitingQueue;
		this.totalMemorySize = totalMemorySize;
		this.cpuSpeed = cpuSpeed;
		segmentList = new ArrayList<>();
		this.ffamavCont = ffamavCont;
		freeMemBlocks = 0;
		inUseMemBlocks = 0;
	}

	@Override
	public void run() {
		// Fill memory block sizes until the total size in the array list =
		// totalMemorySize
		// adds waiting queue to the segment list and adds the processes to the segment
		// then it remvoes them from the queue and updates the
		// waiting queue on the main view

		int base = 200;
		int limit = 200;
		int id = 1;
		for (Process_Object e : waitingQueue) {
			if (Integer.parseInt(e.getProcessSize()) < ((Integer.parseInt(totalMemorySize) - limit))) {
				limit += Integer.parseInt(e.getProcessSize());
				if (limit > Integer.parseInt(totalMemorySize)) {
					segmentList.add(new Segment_Object(id++, base, (Integer.parseInt(totalMemorySize) - 1), null));
				} else {
					segmentList.add(new Segment_Object(id++, base, (limit - 1), e));
					base += Integer.parseInt(e.getProcessSize());
				}
			}
		}
		if (limit < Integer.parseInt(totalMemorySize)) {
			// this creates the free space at the end of the memory array
			Process_Object obj = new Process_Object("0", Integer.toString((Integer.parseInt(totalMemorySize) - limit)), "0");
			segmentList.add(new Segment_Object(0, limit, Integer.parseInt(totalMemorySize), obj));
		}
		for (Segment_Object e : segmentList) {
			waitingQueue.remove(e.getObj());
		}
		main_View_Controller.updateWaitingQueue(waitingQueue);
		for (Segment_Object e : segmentList) {
			System.out.println("BLOCK ID: " + e.getSegmentId() + "\tBASE: " + e.getBase() + " LIMIT: " + e.getLimit());

			if (e.getObj() != null) {
				System.out.println("\t\tPROCESS ID: " + e.getObj().getProcessId() + " SIZE: "
						+ e.getObj().getProcessSize() + " Burst Time: " + e.getObj().getBurstSize());
			}
			System.out.println();
		}
		System.out.println("-------------------------------------------");
		// Starting queue
		inUseMemBlocks = 0;
		freeMemBlocks = 0;
		main_View_Controller.setfreeAndInUseBlocksTxt(Integer.toString(freeMemBlocks),Integer.toString(inUseMemBlocks));
		main_View_Controller.updateWaitingQueue(waitingQueue);
		setMemoryArrayInformation();
		startDisplayingMemoryBlocksInArray();
		
		while(!stopQueue) {
			main_View_Controller.setfreeAndInUseBlocksTxt(Integer.toString(freeMemBlocks),Integer.toString(inUseMemBlocks));
			main_View_Controller.updateWaitingQueue(waitingQueue);
			setMemoryArrayInformation();
			startDisplayingMemoryBlocksInArray();
			updateTimeElapsed();
			updateFreeAndInUseBlockTxt();
			try {
				TimeUnit.SECONDS.sleep(1);
				
				while (pauseQueue) {
					TimeUnit.SECONDS.sleep(1);
				}
				
				for (Segment_Object e : segmentList) {
					if (Integer.parseInt(e.getObj().getBurstSize()) - cpuSpeed <= 0) {
						e.getObj().setBurstSize("0");
						removeProcessFromMemory(e.getObj());
						checkIfProcessCanBeAddedToMemory();
					} else {
						e.getObj().setBurstSize(Integer.toString((int) (Integer.parseInt(e.getObj().getBurstSize()) - cpuSpeed)));
					}
					
				}
				inUseMemBlocks = 0;
				freeMemBlocks = 0;
				for (Segment_Object e : segmentList) {
					waitingQueue.remove(e.getObj());
					if (e.getObj() != null) {
						inUseMemBlocks++;
					} else {
						freeMemBlocks++;
					}
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void startDisplayingMemoryBlocksInArray() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				ffamavCont.startDisplayingMemBlocks(segmentList);
			}
		});

	}

	private void setMemoryArrayInformation() {
		// also sets free blocks and blocks in use txtfields
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				ffamavCont.setMemBlockSizeTxt(segmentList);
			}
		});
	}

	private void updateTimeElapsed() {
		timeElapsed++;
		main_View_Controller.setTimeElapsedTxt(timeElapsed);
	}
	
	private void updateFreeAndInUseBlockTxt() {
		int freeBlocks = 0;
		for(Segment_Object e : segmentList) {
			if(e.getObj().getProcessId().equals("0")) {
				freeBlocks++;
			}
		}
		main_View_Controller.setfreeAndInUseBlocksTxt(Integer.toString(freeBlocks), Integer.toString((segmentList.size() - freeBlocks )));
	}

	private void checkIfProcessCanBeAddedToMemory() {
		for (Process_Object e : waitingQueue) {
			for (Segment_Object f : segmentList) {
				if (f.getObj().getProcessId().equals("0")) {
					f.setObj(e);
					break;
				}
			}
		}
	}

	private void removeProcessFromMemory(Process_Object obj) {
		for (Segment_Object e : segmentList) {
			if (e.getObj() != null) {
				if (e.getObj().equals(obj)) {
					Process_Object obj2 = new Process_Object("0", Integer.toString((e.getBase() + e.getLimit() + 1)), "0");
					e.setObj(obj2);
				}
			}
		}
	}

	public void pauseQueue(double cpuSpeed) {
		pauseQueue = !pauseQueue;
		this.cpuSpeed = cpuSpeed;
	}

	public void stopQueue() {
		stopQueue = true;
	}

	public void updateWaitingQueue(Process_Object process) {
		waitingQueue.add(process);
	}

}
