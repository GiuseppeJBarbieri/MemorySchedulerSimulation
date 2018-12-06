package algorithm;

import java.util.ArrayList;

import model.Segment_Object;
import model.Waiting_Process_Obj;
import view.Main_View_Controller;

public class First_Fit_Algorithm_Thread implements Runnable {

	private ArrayList<Waiting_Process_Obj> waitingQueue;
	private String totalMemorySize;
	private Double cpuSpeed;
	private ArrayList<Segment_Object> segmentList;
	private boolean stopQueue = false;

	public First_Fit_Algorithm_Thread(Main_View_Controller main_View_Controller,
			ArrayList<Waiting_Process_Obj> waitingQueue, String totalMemorySize, Double cpuSpeed) {
		this.waitingQueue = waitingQueue;
		this.totalMemorySize = totalMemorySize;
		this.cpuSpeed = cpuSpeed;
		segmentList = new ArrayList<>();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// Fill memory block sizes until the total size in the array list =
		// totalMemorySize
		int base = 0;
		int limit = 0;
		int i = 0;
		for (Waiting_Process_Obj e : waitingQueue) {
			limit += Integer.parseInt(e.getProcessSize());
			if (limit > Integer.parseInt(totalMemorySize)) {
				System.out.println("DONT ADD WAIT");
			} else {
				segmentList.add(new Segment_Object(base, limit, e));
				base += Integer.parseInt(e.getProcessSize());
				i++;
			}
		
		}
		
		for(int j = 0; j < i; j++) {
			waitingQueue.remove(j);
		}
		System.out.println("Segment List TBl\n---------");
		for (Segment_Object e : segmentList) {
			System.out.println("BASE: " + e.getBase() + " Limit:" + e.getLimit());
		}
		System.out.println("WHATS LEFT IN QUEUE");
		for (Waiting_Process_Obj e : waitingQueue) {
			System.out.println(e.getProcessId());
		}
		while (!stopQueue) {

		}

	}

	public void stopQueue() {
		stopQueue = true;
	}

	public void updateWaitingQueue(Waiting_Process_Obj process) {
		waitingQueue.add(process);
	}

}
