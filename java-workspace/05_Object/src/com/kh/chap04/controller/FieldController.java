package com.kh.chap04.controller;

public class FieldController {
	
	public static String str = "static";
	public static final String JAVA_VERSION = "21";
	public int global;
	
	public void checkVarialbe(int parameter) {
		
		int local = 1; // 지역변수
		
		System.out.println(global);		// 필드
		System.out.println(local);		// 지역변수
		System.out.println(parameter);	// 매개변수(지역변수)
		
		
		
		
		
	}
	
	
	
	
	
	
}
