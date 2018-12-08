package model;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class creates a process object which stores..
 * 				1. The Process Id
 * 				2. The Process Size
 * 				3. The Process Burst Size
 * 
 */
public class Process_Object {

	private String processId, processSize, burstSize;

	public Process_Object(String processId, String processSize, String burstSize) {
		super();
		this.processId = processId;
		this.processSize = processSize;
		this.burstSize = burstSize;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getProcessSize() {
		return processSize;
	}

	public void setProcessSize(String processSize) {
		this.processSize = processSize;
	}

	public String getBurstSize() {
		return burstSize;
	}

	public void setBurstSize(String burstSize) {
		this.burstSize = burstSize;
	}
	
}
