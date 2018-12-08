package main_view.director;

import algorithm.First_Fit_Algorithm_Thread;
import main_view.add_process_node.Add_Process_Node_Controller;
import main_view.cpu_speed_partition_type_node.CPU_Speed_Partition_Type_Node_Controller;
import main_view.memory_array_information_node.Memory_Array_Info_Node_Controller;
import main_view.memory_array_node.Memory_Array_Node_Controller;
import main_view.setup_app_node.Setup_App_Node_Controller;
import main_view.simulation_controls_node.Simulation_Controls_Node_Controller;
import main_view.waiting_queue_node.Waiting_Queue_Node_Controller;

public class Main_View_Director {

	private Waiting_Queue_Node_Controller wqnC;
	private Memory_Array_Info_Node_Controller mainC;
	private Memory_Array_Node_Controller manC;
	private Setup_App_Node_Controller sanC;
	private Simulation_Controls_Node_Controller scnC;
	private CPU_Speed_Partition_Type_Node_Controller csptnC;
	private Waiting_Queue waitingQueue;
	private First_Fit_Algorithm_Thread ffat;
	private Add_Process_Node_Controller apnC;
	
	
	public Main_View_Director() {
		waitingQueue = new Waiting_Queue(this);
	}
	public Waiting_Queue getWaitingQueue() {
		return waitingQueue;
	}

	public void setWaitingQueue(Waiting_Queue waitingQueue) {
		this.waitingQueue = waitingQueue;
	}
	public Waiting_Queue_Node_Controller getWqnC() {
		return wqnC;
	}
	public void setWqnC(Waiting_Queue_Node_Controller wqnC) {
		this.wqnC = wqnC;
	}
	public Memory_Array_Info_Node_Controller getMainC() {
		return mainC;
	}
	public void setMainC(Memory_Array_Info_Node_Controller mainC) {
		this.mainC = mainC;
	}
	public Setup_App_Node_Controller getSanC() {
		return sanC;
	}
	public void setSanC(Setup_App_Node_Controller sanC) {
		this.sanC = sanC;
	}
	public Simulation_Controls_Node_Controller getScnC() {
		return scnC;
	}
	public void setScnC(Simulation_Controls_Node_Controller scnC) {
		this.scnC = scnC;
	}
	public CPU_Speed_Partition_Type_Node_Controller getCsptnC() {
		return csptnC;
	}
	public void setCsptnC(CPU_Speed_Partition_Type_Node_Controller csptnC) {
		this.csptnC = csptnC;
	}
	public First_Fit_Algorithm_Thread getFfat() {
		return ffat;
	}
	public void setFfat(First_Fit_Algorithm_Thread ffat) {
		this.ffat = ffat;
	}
	public Add_Process_Node_Controller getApnC() {
		return apnC;
	}
	public void setApnC(Add_Process_Node_Controller apnC) {
		this.apnC = apnC;
	}
	public Memory_Array_Node_Controller getManC() {
		return manC;
	}
	public void setManC(Memory_Array_Node_Controller manC) {
		this.manC = manC;
	}
	
}
