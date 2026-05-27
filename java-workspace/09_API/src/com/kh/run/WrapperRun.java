package com.kh.run;

public class WrapperRun {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 15;
		
//		Integer i1 = new Integer(num1);
//		System.out.println(i1);
		
		Integer i1 = num1;
		Integer i2 = num2;
		
		System.out.println(i1 + i2);
		System.out.println(num1 + num2);
		System.out.println(i1.equals(i2));
		System.out.println(i1.compareTo(i2));
		
		String str1 = "11";
		String str2 = "1.1";
		System.out.println(str1 + str2);
		
		int i = Integer.parseInt(str1);
		double d = Double.parseDouble(str2);
		System.out.println(i + d);
		
		String intNum = String.valueOf(i);
		System.out.println(intNum);
		
		
	}

}
