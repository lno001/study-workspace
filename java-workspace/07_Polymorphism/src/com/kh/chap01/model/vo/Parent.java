package com.kh.chap01.model.vo;

public class Parent {
	private int x;
	private int y;
	public Parent() {}
	public Parent(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public void printParent() {
		System.out.println("부모클래스 메소드입니다.");
	}
	
	public void print() {
		System.out.println("부모클래스의 print메소드");
	}
}
