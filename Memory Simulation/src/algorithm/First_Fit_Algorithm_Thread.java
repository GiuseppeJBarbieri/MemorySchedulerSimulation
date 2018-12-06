package algorithm;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import model.Segment_Object;
import model.Waiting_Process_Obj;
import view.Main_View_Controller;

public class First_Fit_Algorithm_Thread implements Runnable {

	private ArrayList<Waiting_Process_Obj> waitingQueue;
	private String totalMemorySize;
	private Double cpuSpeed;
	private ArrayList<Segment_Object> segmentList;
	private boolean stopQueue = false;
	private Main_View_Controller main_View_Controller;

	public First_Fit_Algorithm_Thread(Main_View_Controller main_View_Controller,
			ArrayList<Waiting_Process_Obj> waitingQueue, String totalMemorySize, Double cpuSpeed) {
		this.main_View_Controller = main_View_Controller;
		this.waitingQueue = waitingQueue;
		this.totalMemorySize = totalMemorySize;
		this.cpuSpeed = cpuSpeed;
		segmentList = new ArrayList<>();
	}

	@Override
	public void run() {
		// Fill memory block sizes until the total size in the array list =
		// totalMemorySize
		// adds waiting queue to the segment list and adds the processes to the segment
		// then it remvoes them from the queue and updates the
		// waiting queue on the main view

		int base = 0;
		int limit = 0;
		for (Waiting_Process_Obj e : waitingQueue) {
			limit += Integer.parseInt(e.getProcessSize());
			if (limit > Integer.parseInt(totalMemorySize)) {
				segmentList.add(new Segment_Object(base, (Integer.parseInt(totalMemorySize) - 1), null));
			} else {
				segmentList.add(new Segment_Object(base, limit, e));
				base += Integer.parseInt(e.getProcessSize());
			}
		}

		System.out.println("1. ----------Segment List TBl---------");
		for (Segment_Object e : segmentList) {
			waitingQueue.remove(e.getObj());
			if (e.getObj() != null) {
				System.out.println(
						"PID: " + e.getObj().getProcessId() + " BASE: " + e.getBase() + " Limit:" + e.getLimit());
			}
		}
		System.out.println("1. ---Waiting Queue---------");
		for (Waiting_Process_Obj e : waitingQueue) {
			System.out.println(e.getProcessId());
		}

		main_View_Controller.updateWaitingQueue(waitingQueue);

		int z = 1;
		System.out.println("----------------------------------------------Starting Queue");
		while (!stopQueue) {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("-----------------------------------------------Second " + z++);
				for (Segment_Object e : segmentList) {
					if (e.getObj() != null) {
						if (Integer.parseInt(e.getObj().getBurstSize()) - cpuSpeed <= 0) {
							e.getObj().setBurstSize("0");
							// This is where i add a new process in and update the partitions
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

			System.out.println("-------------Segment List TBl---------");
			for (Segment_Object e : segmentList) {
				waitingQueue.remove(e.getObj());
				if (e.getObj() != null) {
					System.out.println(
							"PID: " + e.getObj().getProcessId() + " BASE: " + e.getBase() + " Limit:" + e.getLimit());
				} else {
					System.out.println("PID: None " + "BASE: " + e.getBase() + " Limit:" + e.getLimit());
				}
			}

			System.out.println("---------Waiting QUEUE---------------");
			for (Waiting_Process_Obj e : waitingQueue) {
				System.out.println(e.getProcessId());
			}

		} // <End While Loop>

	}

	private void checkIfProcessCanBeAddedToMemory() {
		int i = 0;
		for (Waiting_Process_Obj e : waitingQueue) {
			for (Segment_Object f : segmentList) {
				if ((f.getLimit() - f.getBase()) >= Integer.parseInt(e.getProcessSize()) && f.getObj() == null) {
					f.setObj(e);
					i++;
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

	public void stopQueue() {
		stopQueue = true;
	}

	public void updateWaitingQueue(Waiting_Process_Obj process) {
		waitingQueue.add(process);
	}

}
