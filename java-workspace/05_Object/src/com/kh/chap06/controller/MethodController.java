package com.kh.chap06.controller;

public class MethodController {
	// 정수 값 두 개를 받아서 더하기 결과를 반환해주는 기능을 만들고 싶다.
	public int add(int a, int b) {
		return a + b; // 반환값
	}
	
	// 1. 매개변수 X, 반환값 X
	public void method1() {
		System.out.println("출력용 메소드");
	}
	
	// 2. 매개변수 X, 반환값 O
	public String method2() {
		return "필드값";
	}
	public String method3() {
		return method2();
	}
	
	// 3. 매개변수 O, 반환값 X
	// public void setName(String name) {
	//		this.name = name;
	// }
	
	// 4. 매개변수 O, 반환값 O
	public int method4(int num) {
		return num +54;
	}
	
	
	
}
