package com.kh.chap06.controller;

public class OverloadingController {
	// 메소드명은 method로 통일
	public void method() {
		System.out.println("메소드 오버로딩 1");
	}
	
	public void method(int num) {
		System.out.println("메소드 오버로딩 2");
	}

	public void method(String str) {
		System.out.println("메소드 오버로딩 3");
	}

	public void method(char num) {
		System.out.println("메소드 오버로딩 4");
	}

	public void method(int num, String str) {
		System.out.println("메소드 오버로딩 5");
	}

	public void method(String str, int num) {
		System.out.println("메소드 오버로딩 6");
	}
	
	
	
	
	
	

}
