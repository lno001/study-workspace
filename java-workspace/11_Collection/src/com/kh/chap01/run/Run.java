package com.kh.chap01.run;

import com.kh.chap01.Integers;

public class Run {

	public static void main(String[] args) {
		
		// 정수값을 여러 개 다루고 싶음
		// 몇 개를 쓸지 모르겠지만 많이 쓰고 싶음
		
		Integers i = new Integers();
		i.add(1);
		i.add(2);
		i.add(3);
		i.add(5);
		i.add(8);
		i.add(13);
		i.add(21);
		i.add(34);
		
		System.out.println(i.get(3));
		System.out.println(i.get(7));
		System.out.println(i.get(2));
		System.out.println(i.get(4));
		System.out.println(i.get(5));
		
		
		

	}

}
