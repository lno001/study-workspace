package com.kh.chap04.view;

import java.util.Arrays;

import com.kh.chap04.controller.FieldController;

public class FieldView {
	
	public void check() {
		FieldController fc = new FieldController();
		System.out.println(fc.global);

		fc.checkVarialbe(5);
		
		System.out.println(fc.global);
		fc = null; // global은 접근 불가능
		// System.out.println(fc.global); // fc의 값이 null이라서 global의 변수 위치를 찾을 수 없음
		
		System.out.println(Math.PI);
		System.out.println(FieldController.JAVA_VERSION);
		System.out.println(Math.random());
		System.out.println(Arrays.toString(new int[2]));
	}

}
