package com.kh.chap06.run;

import com.kh.chap06.controller.MethodController;
import com.kh.chap06.controller.OverloadingController;

public class Run {
	
	
	public static void main(String[] args) {
		
	//	int result = new MethodController().add(5, 4);
	//	System.out.println(result);
		
		MethodController result = new MethodController();
//		int a = result.add(1, 2);
//		int b = result.add(3, 4);
//		int c = result.add(a, b);
//		int d = result.add(c, a);
//		System.out.printf("%d, %d, %d, %d", a, b, c, d);
//		System.out.println();
		result.method1();
//		String str = result.method2();
//		System.out.println(str);
//		System.out.println(result.method2());
//		System.out.println(result.method3());
//		int e = result.method4(46);
//		System.out.println(e);
		
		OverloadingController oc= new OverloadingController();
		
		oc.method();
		oc.method(0);
		oc.method("0");
		oc.method('0');
		oc.method(0,"0");
		oc.method("0",0);
		
		
		
		
	}
}
