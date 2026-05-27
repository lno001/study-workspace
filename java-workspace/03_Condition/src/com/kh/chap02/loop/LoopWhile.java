package com.kh.chap02.loop;

public class LoopWhile {
	
	public void method1() {
		// 초기식 조건식 증감식
		int i = 0; // 초기식
		while(i < 3 /*조건식*/) {
			i++; // 증감식
			System.out.println(i);
		}
	}
	
	public void method2() {
		// 1~ 10까지의 합계를 구해서 출력
		// System.out.println(1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10);
		
		int i = 1;
		int sum = 0;
		while(i <= 4) {
			sum += i;
			i++;
		}
		System.out.println(sum);
	}
	
	public void method3() {
		
		// 1부터 시작해서
		// 1 ~ 10 사이의 임의의 정수까지를 모두 더한 합계를 출력
		// random : 무작위
		// Random이라는 클래스가 존재하지만?
		// Math라는 클래스가 가지고 있는 random()를 호출해서 만들어 볼 예정
		
		double number = Math.random();
		
//		System.out.println(number);						// 0.0 ~ 0.9999999999999999 값이 나옴
//		System.out.println(number * 10);				// 0.0 ~ 9.999999999999999  값이 나옴
//		System.out.println((int)number * 10);			// 0	  의 정수 값이 나옴
//		System.out.println((int)(number * 10));			// 0 ~ 9  의 정수 값이 나옴
//		System.out.println((int)(number * 10) + 1);		// 1 ~ 10 의 정수 값이 나옴

		int randomNum = (int)(number * 10) + 1;
		
		int i = 1 ;
		int sum = 0;
		
		while(i <= randomNum) {
			sum += i;
			i++;
		}
		System.out.println(sum);
	}
	
	// 로또 번호 생성기
	public void lotto() {
		int num1 = (int)(Math.random() * 45) + 1;
		int num2 = (int)(Math.random() * 45) + 1;
		int num3 = (int)(Math.random() * 45) + 1;
		int num4 = (int)(Math.random() * 45) + 1;
		int num5 = (int)(Math.random() * 45) + 1;
		int num6 = (int)(Math.random() * 45) + 1;
		
		System.out.printf("오늘의 로또 번호 \n%d, %d, %d, %d, %d, %d" , num1, num2, num3, num4, num5, num6);
		
	}
	
	
	
}
