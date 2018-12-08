package model;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class creates a segment object which stores..
 * 				1. The Segment Id
 * 				2. The Segment Base
 * 				3. The Segment Limit
 * 				4. The Segment Process It's Holding.
 * 
 */
public class Segment_Object {

	private int base, limit, segmentId;
	private Process_Object obj;

	public Segment_Object(int segmentId, int base, int limit, Process_Object obj) {
		super();
		this.segmentId = segmentId;
		this.base = base;
		this.limit = limit;
		this.obj = obj;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(int segmentId) {
		this.segmentId = segmentId;
	}
	
	public Process_Object getObj() {
		return obj;
	}

	public void setObj(Process_Object obj) {
		this.obj = obj;
	}
	
}
