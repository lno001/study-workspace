package com.kh.vips.model.vo;

public class Chef {
	private String name;

	public Chef(String name) {
		super();
		this.name = name;
	}
	public void cooking() {
		System.out.println("요리시작~");
	}
	public void breakTime() {
		System.out.println("요리 끝~");
	}
	public String getName() {
		return name;
	}

}
