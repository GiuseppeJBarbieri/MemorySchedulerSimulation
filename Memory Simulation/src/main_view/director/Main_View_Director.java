package main_view.director;

import main_view.setup_app_node.Setup_App_Node_Controller;
import main_view.waiting_queue_node.Waiting_Queue_Node_Controller;

public class Main_View_Director {

	//WaitingQueueNodeController needs
	//yPreloadRBtn isSelected()
	//yPreloadRBtn is from
	
	private Waiting_Queue_Node_Controller wqnC;
	private Setup_App_Node_Controller sanC;
	
	public Main_View_Director() {
		
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
}
