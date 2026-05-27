package com.kh.vips.model.vo;

public class Ko {
	private String name;

	public Ko(String name) {
		this.name = name;
	}
	
	public void cooking() {
		System.out.println(name + " main 요리 시작~");
	}
	public void breakTime() {
		System.out.println(name + " 쉬는 시간!");
	}
}
