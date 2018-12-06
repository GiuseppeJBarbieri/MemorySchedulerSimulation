package model;

public class Segment_Object {

	private int base, limit;
	private Waiting_Process_Obj obj;

	public Segment_Object(int base, int limit, Waiting_Process_Obj obj) {
		super();
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

	public Waiting_Process_Obj getObj() {
		return obj;
	}

	public void setObj(Waiting_Process_Obj obj) {
		this.obj = obj;
	}

}