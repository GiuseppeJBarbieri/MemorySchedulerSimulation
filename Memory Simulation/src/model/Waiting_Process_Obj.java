package model;

public class Waiting_Process_Obj {

	private String processId, processSize, burstSize;

	public Waiting_Process_Obj(String processId, String processSize, String burstSize) {
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
