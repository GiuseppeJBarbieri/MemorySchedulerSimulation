package controller;

import java.util.ArrayList;

import algorithm.First_Fit_Algorithm_Thread;
import memory_array_view.Display_Memory_Array_Node;
import model.Segment_Object;

public class FFA_To_MemArrView_Controller {
	
	private First_Fit_Algorithm_Thread ffat;
	private Display_Memory_Array_Node memArrayNode;
	
	public FFA_To_MemArrView_Controller(First_Fit_Algorithm_Thread ffat, Display_Memory_Array_Node memArrayNode) {
		this.ffat = ffat;
		this.memArrayNode = memArrayNode;
	}

	public void setMemBlockSizeTxt(ArrayList<Segment_Object> segmentList) {
		memArrayNode.setMemBlockSizeTxtFields(segmentList);
	}

}
