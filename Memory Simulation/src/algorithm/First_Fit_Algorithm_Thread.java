package algorithm;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import controller.FFA_To_MemArrView_Controller;
import javafx.application.Platform;
import main_view.Main_View_Controller;
import model.Segment_Object;
import model.Waiting_Process_Obj;

public class First_Fit_Algorithm_Thread implements Runnable {

	private ArrayList<Waiting_Process_Obj> waitingQueue;
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
			ArrayList<Waiting_Process_Obj> waitingQueue, String totalMemorySize, Double cpuSpeed,
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
		for (Waiting_Process_Obj e : waitingQueue) {
			if (segmentList.size() < 9) {
				limit += Integer.parseInt(e.getProcessSize());
				if (limit > Integer.parseInt(totalMemorySize)) {
					segmentList.add(new Segment_Object(id++, base, (Integer.parseInt(totalMemorySize) - 1), null));
				} else {
					segmentList.add(new Segment_Object(id++, base, limit, e));
					base += Integer.parseInt(e.getProcessSize());
				}
			} else {
				limit = Integer.parseInt(totalMemorySize) + limit;
				if(limit > Integer.parseInt(e.getProcessSize())) {
					segmentList.add(new Segment_Object(id++, base, limit, e));
					break;
				}
			}
		}

		for (Segment_Object e : segmentList) {
			waitingQueue.remove(e.getObj());
		}

		main_View_Controller.updateWaitingQueue(waitingQueue);
		//Starting queue loop--------------------------------------------------------------------------------------------------
		while (!stopQueue) {
			main_View_Controller.setfreeAndInUseBlocksTxt(Integer.toString(freeMemBlocks), Integer.toString(inUseMemBlocks));
			setMemoryArrayInformation();
			startDisplayingMemoryBlocksInArray();
			while (pauseQueue) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			updateTimeElapsed();

			main_View_Controller.updateWaitingQueue(waitingQueue);
			try {
				TimeUnit.SECONDS.sleep(1);
				for (Segment_Object e : segmentList) {
					if (e.getObj() != null) {
						if (Integer.parseInt(e.getObj().getBurstSize()) - cpuSpeed <= 0) {
							e.getObj().setBurstSize("0");
							// This is where i add a new process in and update the partitions -- gto
							removeProcessFromMemory(e.getObj());
							checkIfProcessCanBeAddedToMemory();
						} else {
							e.getObj().setBurstSize(
									Integer.toString((int) (Integer.parseInt(e.getObj().getBurstSize()) - cpuSpeed)));
						}
					}
				}

			} catch (InterruptedException e1) {
				e1.printStackTrace();
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

		}

	}
	
	private void startDisplayingMemoryBlocksInArray() {
		ffamavCont.startDisplayingMemBlocks(segmentList);
	}

	private void setMemoryArrayInformation() {
		//also sets free blocks and blocks in use txtfields
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

	private void checkIfProcessCanBeAddedToMemory() {
		for (Waiting_Process_Obj e : waitingQueue) {
			for (Segment_Object f : segmentList) {
				if ((f.getLimit() - f.getBase()) >= Integer.parseInt(e.getProcessSize()) && f.getObj() == null) {
					f.setObj(e);
					break;
				}
			}
		}
	}

	private void removeProcessFromMemory(Waiting_Process_Obj obj) {
		for (Segment_Object e : segmentList) {
			if (e.getObj() != null) {
				if (e.getObj().equals(obj)) {
					e.setObj(null);
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

	public void updateWaitingQueue(Waiting_Process_Obj process) {
		waitingQueue.add(process);
	}

}
