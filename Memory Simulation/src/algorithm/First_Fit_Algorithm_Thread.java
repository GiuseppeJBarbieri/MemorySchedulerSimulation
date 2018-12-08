package algorithm;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import main_view.director.Main_View_Director;
import main_view.main.Main_View_Controller;
import model.Process_Object;
import model.Segment_Object;

public class First_Fit_Algorithm_Thread implements Runnable {

	private ArrayList<Process_Object> waitingQueue;
	private String totalMemorySize;
	private Double cpuSpeed;
	private ArrayList<Segment_Object> segmentList;
	private boolean stopQueue = false;
	private boolean pauseQueue = false;
	private int timeElapsed;
	private int freeMemBlocks;
	private int inUseMemBlocks;
	private Main_View_Director directorMap;

	public First_Fit_Algorithm_Thread(Main_View_Director directorMap) {
		this.directorMap = directorMap;
		timeElapsed = 0;
		freeMemBlocks = 0;
		inUseMemBlocks = 0;
		segmentList = new ArrayList<>();
		this.waitingQueue = directorMap.getWaitingQueue().getWaitingQueue();
		this.totalMemorySize = directorMap.getSanC().getTotalMemoryTxt();
		this.cpuSpeed = directorMap.getCsptnC().getCpuSpeedChoice();
		
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
		directorMap.getWaitingQueue().setWaitingQueue(waitingQueue);
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
		directorMap.getMainC().setfreeAndInUseBlocksTxt(Integer.toString(freeMemBlocks),Integer.toString(inUseMemBlocks));
		directorMap.getWaitingQueue().setWaitingQueue(waitingQueue);
		setMemoryArrayInformation();
		startDisplayingMemoryBlocksInArray();
		
		while(!stopQueue) {
			directorMap.getMainC().setfreeAndInUseBlocksTxt(Integer.toString(freeMemBlocks),Integer.toString(inUseMemBlocks));
			directorMap.getWaitingQueue().setWaitingQueue(waitingQueue);
			setMemoryArrayInformation();
			startDisplayingMemoryBlocksInArray();
			updateTimeElapsed();
			updateFreeAndInUseBlockTxt();
			directorMap.getWaitingQueue().updateWaitingQueueTbl();
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
				directorMap.getManC().startDisplayingMemBlocks(segmentList);
			}
		});

	}

	private void setMemoryArrayInformation() {
		// also sets free blocks and blocks in use txtfields
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				directorMap.getManC().setMemBlockTxtFields(segmentList);
			}
		});
	}

	private void updateTimeElapsed() {
		timeElapsed++;
		directorMap.getMainC().setTimeElapsedTxt(timeElapsed);
	}
	
	private void updateFreeAndInUseBlockTxt() {
		int freeBlocks = 0;
		for(Segment_Object e : segmentList) {
			if(e.getObj().getProcessId().equals("0")) {
				freeBlocks++;
			}
		}
		directorMap.getMainC().setfreeAndInUseBlocksTxt(Integer.toString(freeBlocks), Integer.toString((segmentList.size() - freeBlocks )));
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
	
}
