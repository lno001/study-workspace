package com.kh.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringController {
	
	public void method1() {
		
	//	String abc = "abc";
	String str1 = new String("hello");
	String str2 = new String("hello");
	
	System.out.println(str1);
	System.out.println(str1.equals(str2));
	
	System.out.println(str1.hashCode());
	System.out.println(str2.hashCode());
	System.out.println("hello".hashCode());
	
	System.identityHashCode(str1);
	System.identityHashCode(str2);
	System.out.println(System.identityHashCode(str1));
	System.out.println(System.identityHashCode(str2));
	
	System.out.println(str1 == str2);
	}
	
	public void method2() {
		
		String str1 = "hello";
		String str2 = "hello";
		
		// toString()
		System.out.println(str1);
		System.out.println(str2);
		
		// eqauls()
		System.out.println(str1.equals(str2));
		
		// hashCode()
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		// identityHashCode()
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(str1 == str2);
	}
	
	public void method3() {
		
		String str1 = new String("hello");
		String str2 = "hello";
		
		System.out.println(str1);
		System.out.println(System.identityHashCode(str2));
		str2 += "bye";
		
		System.out.println(System.identityHashCode(str2));
		System.out.println(str2);
	}
	
	public void method4() {
		
		StringBuffer sb = new StringBuffer();
		String str = "Hello" + "World";
		sb.append("Hello");
		sb.append("world");
		System.out.println(str);
		System.out.println(sb);
		
		StringBuilder sr = new StringBuilder();
		sr.append("Hello");
		sr.append("world");
		System.out.println(sr);
	}
	
	public void method() {
		
		String str1 = "은총알은 없다";
		
		System.out.println("str1의 길이 : " + str1.length());
		
		String userId = "sdfsㄹㄴㅇㄴㅇㄹ";
		// 아이디 8자 ~ 20자
		if(!(8 <= userId.length() && userId.length() <= 20)) {
			throw new RuntimeException("아이디 글자수 어쩌고저쩌고~~");
		}
		
		char ch = userId.charAt(0);
		System.out.println(ch);
		String phoneNumber = "010-1234-5678";
		System.out.println(phoneNumber.substring(4));
		System.out.println(phoneNumber.substring(4,8));
		
		System.out.println(str1.indexOf("없다"));
		
		String[] emails = {"hong@kh.com", "kansui@kh.com", "don@kh.com", "knokeuhskj@kh.com" };
		int emailnum = emails[0].indexOf("@");
		System.out.println(emails[0].substring(0, emailnum));
		
		for(int i = 0; i < emails.length; i++) {
			System.out.println(emails[i].substring(0, emails[i].indexOf("@")));
		}
		
		String flieName = "sdfsdfs.jpg";
		System.out.println(flieName.substring(flieName.indexOf(".") + 1));
		
		String fileName2 = "sds.dew.fsd.fs.df.sf.ew.png";
		System.out.println(fileName2.substring(fileName2.lastIndexOf(".") + 1));
		
		String chi = "배열로만들문자열";
		char[] chArr = chi.toCharArray();
		for(int i = 0; i < chArr.length; i++) {
			System.out.println(chArr[i]);
		}
		for(char i : chArr) {
			System.out.println(i);
		}
		System.out.println(String.valueOf(chArr));
		
		LocalDate now = LocalDate.now();
		System.out.println(now);
		
		String replaceStr = "KH 아카데미";
		System.out.println(replaceStr.replace("KH", "더조은"));
		
		String str = "abCD";
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		
		String split = "갈비,갈비찜,곽만근갈비찜,곽만근얼큰갈비탕";
		
		String[] galubi = split.split(",");
		System.out.println(Arrays.toString(galubi));
		
		StringTokenizer stn = new StringTokenizer(split, ",");
		
//		System.out.println(stn.nextToken());
//		System.out.println(stn.nextToken());
//		System.out.println(stn.nextToken());
//		System.out.println(stn.nextToken());
		
		while(stn.hasMoreTokens()) {
			System.out.println(stn.nextToken());
		}
		
		
		
		
	}
	
}
