package com.kh.sw.model.vo;

public class Switch {
	private boolean on;

	public Switch(boolean on) {
		super();
		this.on = on;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	@Override
	public String toString() {
		return "Switch [on=" + on + "]";
	}
	
	

}
