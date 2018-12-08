package main_view.director;

import java.util.ArrayList;

import algorithm.First_Fit_Algorithm_Thread;
import controller.FFA_To_MemArrView_Controller;
import main_view.cpu_speed_partition_type_node.CPU_Speed_Partition_Type_Node_Controller;
import main_view.setup_app_node.Setup_App_Node_Controller;
import main_view.simulation_controls_node.Simulation_Controls_Node_Controller;
import main_view.waiting_queue_node.Waiting_Queue_Node_Controller;
import model.Process_Object;

public class Main_View_Director {

	//WaitingQueueNodeController needs
	//yPreloadRBtn isSelected()
	//yPreloadRBtn is from
	
	private Waiting_Queue_Node_Controller wqnC;
	private Setup_App_Node_Controller sanC;
	private Simulation_Controls_Node_Controller scnC;
	private CPU_Speed_Partition_Type_Node_Controller csptnC;
	private Waiting_Queue waitingQueue;
	private First_Fit_Algorithm_Thread ffat;
	FFA_To_MemArrView_Controller ffamavCont;
	
	public Main_View_Director() {
		waitingQueue = new Waiting_Queue(this);
	}
	
	public void setWaitingQueueNodeCont(Waiting_Queue_Node_Controller wqnC) {
		this.wqnC = wqnC;
	}
	public Waiting_Queue_Node_Controller getWaitingQueueNodeCont() {
		return wqnC;
	}
	public void setSetupAppNodeCont(Setup_App_Node_Controller sanC) {
		this.sanC = sanC;
	}
	public Setup_App_Node_Controller getSetupAppNodeCont() {
		return sanC;
	}
	public void setSimControlsNodeCont(Simulation_Controls_Node_Controller scnC) {
		this.scnC = scnC;
	}
	public Simulation_Controls_Node_Controller getSimControlsNodeCont() {
		return scnC;
	}
	public void setCPUSpeedPartTypeNodeCont(CPU_Speed_Partition_Type_Node_Controller csptnC) {
		this.csptnC = csptnC;
	}
	public CPU_Speed_Partition_Type_Node_Controller getCPUSpeedPartTypeNodeCont() {
		return csptnC;
	}

	public Waiting_Queue getWaitingQueue() {
		return waitingQueue;
	}

	public void setWaitingQueue(Waiting_Queue waitingQueue) {
		this.waitingQueue = waitingQueue;
	}
	
	public void setFFAThread(First_Fit_Algorithm_Thread ffat) {
		this.ffat = ffat;
	}

	public void setFFAMAVCont(FFA_To_MemArrView_Controller ffamavCont) {
		this.ffamavCont = ffamavCont;
	}
	
}
