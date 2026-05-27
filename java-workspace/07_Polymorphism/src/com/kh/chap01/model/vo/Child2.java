package com.kh.chap01.model.vo;

public class Child2 extends Parent {
	private int z;
	public Child2() {}
	public Child2(int z) {
		this.z = z;
	}
	public void printChild2() {
		System.out.println("자식클래스 2 메소드입니다.");
	}
	@Override
	public void print() {
		System.out.println("Child2의 print메소드");
	}
	
}
