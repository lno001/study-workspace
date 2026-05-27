package com.kh.chap03.model.vo;

public abstract class Chef {
	private String name;

	public Chef(String name) {
		super();
		this.name = name;
	}
	
//	public void cooking() {
//		System.out.println("요리해야지~~");
//	}
	
	public abstract void cooking();
	
	public void breakTime() {
		System.out.println("쉬는시간입니다~~");
	}
	
	public String getName() {
		return name;
	}
}
