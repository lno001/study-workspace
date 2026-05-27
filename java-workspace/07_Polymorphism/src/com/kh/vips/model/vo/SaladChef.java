package com.kh.vips.model.vo;

public class SaladChef {
	private String name;

	public SaladChef(String name) {
		super();
		this.name = name;
	}
	
	public void saladCooking() {
		System.out.println(name + " 샐러드 요리 시작~");
	}
	public void breakTime() {
		System.out.println(name + " 쉬는 시간!");
	}

}
