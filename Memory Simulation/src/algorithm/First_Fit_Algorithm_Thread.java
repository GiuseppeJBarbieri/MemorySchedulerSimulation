package algorithm;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class runs the first fit algorithm.
 * 
 */
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import main_view.director.Main_View_Director;
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
		/* 
		 * Fill memory block sizes until the total size in the array list = totalMemorySize
		 * adds waiting queue to the segment list and adds the processes to the segment
		 * then it removes them from the queue and updates 
		 * the waiting queue on the main view
		 */
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
			Process_Object obj = new Process_Object("0", Integer.toString((Integer.parseInt(totalMemorySize) - limit)),
					"0", Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt()));
			segmentList.add(new Segment_Object(0, limit, Integer.parseInt(totalMemorySize), obj));
		}
		for (Segment_Object e : segmentList) {
			waitingQueue.remove(e.getObj());
		}
		directorMap.getWaitingQueue().setWaitingQueue(waitingQueue);

		inUseMemBlocks = 0;
		freeMemBlocks = 0;
		directorMap.getMainC().setfreeAndInUseBlocksTxt(Integer.toString(freeMemBlocks), Integer.toString(inUseMemBlocks));
		directorMap.getWaitingQueue().setWaitingQueue(waitingQueue);
		setMemoryArrayInformation();
		startDisplayingMemoryBlocksInArray();
		// Starting queue
		while (!stopQueue) {
			directorMap.getWaitingQueue().updateWaitingQueue();	
			directorMap.getWaitingQueue().getMemCompChk().checkMemoryForCompaction();
			directorMap.getMainC().setfreeAndInUseBlocksTxt(Integer.toString(freeMemBlocks),
					Integer.toString(inUseMemBlocks));
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
				//Loop through segment list and remove processes from memory
				//And also check if a process cna be added to memory.
				for (Segment_Object e : segmentList) {
					if (Integer.parseInt(e.getObj().getBurstSize()) - cpuSpeed <= 0) {
						e.getObj().setBurstSize("0");
						removeProcessFromMemory(e.getObj());
						checkIfProcessCanBeAddedToMemory();
					} else {
						e.getObj().setBurstSize(
								Integer.toString((int) (Integer.parseInt(e.getObj().getBurstSize()) - cpuSpeed)));
					}
				}
				//This determines the free memory blocks and the blocks in use.
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

	/*
	 * This method compacts the memory array.
	 */
	public void compactMemory() {
		// updating segments
		int size = segmentList.size();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < segmentList.size(); j++) {
				if (segmentList.get(j).getObj().getProcessId().equals("0")) {
					removeSegmentFromMemory(segmentList.get(j));
				}
			}

		}

		int base2 = 200;
		int limit2 = 199;
		for (int i = 0; i < segmentList.size(); i++) {
			segmentList.get(i).setBase(base2);
			limit2 = limit2 + Integer.parseInt(segmentList.get(i).getObj().getProcessSize());
			segmentList.get(i).setLimit(limit2);
			base2 = limit2 + 1;
		}

		int base = 0;
		int limit = 0;
		int segsize = 0;
		for (int i = 0; i < segmentList.size(); i++) {
			base = segmentList.get(i).getLimit() + 1;
			limit = Integer.parseInt(totalMemorySize);
			segsize = limit - base + 1;
		}
		segmentList.add(
				new Segment_Object(0, (limit2 + 1), limit, new Process_Object("0", Integer.toString(segsize), "0", "999999")));
	}

	/*
	 * This method starts the memory gui portion to start
	 * showing the memory array.
	 */
	private void startDisplayingMemoryBlocksInArray() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				directorMap.getManC().startDisplayingMemBlocks(segmentList);
			}
		});

	}

	/*
	 * Sets the memory array node information fields. 
	 */
	private void setMemoryArrayInformation() {
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

	/*
	 * This method updates the free and in use memory segment textfields.
	 */
	private void updateFreeAndInUseBlockTxt() {
		int freeBlocks = 0;
		for (Segment_Object e : segmentList) {
			if (e.getObj().getProcessId().equals("0")) {
				freeBlocks++;
			}
		}
		directorMap.getMainC().setfreeAndInUseBlocksTxt(Integer.toString(freeBlocks),
				Integer.toString((segmentList.size() - freeBlocks)));
	}

	private void checkIfProcessCanBeAddedToMemory() {
		boolean leaveLoop = false;
		for (int i = 0; i < waitingQueue.size(); i++) {
			if (!leaveLoop) {
				for (Segment_Object f : segmentList) {
					if (f.getObj().getProcessId().equals("0") && f.getSegmentId() != 0) {
						f.setObj(waitingQueue.get(i));
						waitingQueue.remove(waitingQueue.get(i));
						leaveLoop = true;
						break;
					}
				}
			} else {
				break;
			}
		}
	}

	/*
	 * This method removes the process from the memory segment and then it adds a new process to that memory
	 * segment which is process 0.
	 * 
	 * process 0 means it's free space.
	 */
	private void removeProcessFromMemory(Process_Object obj) {
		for (Segment_Object e : segmentList) {
			if (e.getObj() != null) {
				if (e.getObj().equals(obj)) {
					Process_Object obj2 = new Process_Object("0", Integer.toString((e.getBase() + e.getLimit() + 1)),"0", Integer.toString((int) directorMap.getMainC().getElapsedTimeTxt()));
					e.setObj(obj2);
				}
			}
		}
	}

	public void removeSegmentFromMemory(Segment_Object segment_Object) {
		segmentList.remove(segment_Object);
	}

	/*
	 * There is a while loop withing the loop in the run method that sets the 
	 * boolean stopQueue to true which puts it into an infinite loop until it is
	 * resumed.
	 * 
	 * It is used by the pause/resume button.
	 * 
	 * It will update the cpu speed if it was changed.
	 */
	public void pauseQueue(double cpuSpeed) {
		pauseQueue = !pauseQueue;
		this.cpuSpeed = cpuSpeed;
	}
	
	/*
	 * This method stops the main loop in the run method which ends the simulation.
	 * 
	 * Used by the reset simulation button.
	 */
	public void stopQueue() {
		stopQueue = true;
	}

	public void setSegmentList(ArrayList<Segment_Object> segmentList) {
		this.segmentList = segmentList;
	}
	public ArrayList<Segment_Object> getSegmentList() {
		return segmentList;
	}

}
