package com.kh.chap01.condition;

import java.util.Scanner;

public class ConditionIf {
	
	public void method1() { 
		
		//System.out.println("method1의 메소드입니다.");
		//System.out.println("=====================================================");
		
		if(0 < 1) {
			System.out.println("0이 1보다 작습니다.");
		}
		if(true) {
			System.out.println("이 코드는 if문을 만나면 무조건 수행되는 코드");
		}
//		if(false) {
//			System.out.println("이 코드는 if문을 만나면 절대 동작하지 않는 코드");
//		}
	}

	public void quiz() {
		// 문제를 출력해준 뒤
		int q = 0;
		int count = 0;
		int wrongCount = 0;
		System.out.println("문제 : 고양이는 호랑이과 일까요?");
		q++;
		// 사용자에게 o 또는 x를 입력받아서
		Scanner sc = new Scanner(System.in);
		System.out.print("정답을 o또는 x로 입력해주세요 > ");
		char answer = sc.nextLine().charAt(0);

		// 정답입니다~ / 오답입니다~
		if(answer == 'x' || answer == 'X') {
			System.out.println("와아 대단해요! 정답입니다~");
			count++;
		}
		if(answer == 'o' || answer == 'O') {
			System.out.println("아쉽게 틀렸네요... 오답입니다");
			wrongCount++;
		}
		if(answer != 'x' && answer != 'o' && answer != 'X' && answer != 'O') {
			System.out.println("정답은 o또는 x로 입력해주세요.");
			wrongCount++;
		}
		System.out.println("문제 : 여우는 개과 일까요?");
		q++;
		System.out.print("정답을 o또는 x로 입력해주세요 > ");
		answer = sc.nextLine().charAt(0);
		
		if(answer == 'o' || answer == 'O') {
			System.out.println("와아 대단해요! 정답입니다~");
			count++;
		}
		if(answer == 'x' || answer == 'X') {
			System.out.println("아쉽게 틀렸네요... 오답입니다");
			wrongCount++;
		}
		if(answer != 'x' && answer != 'o' && answer != 'X' && answer != 'O') {
			System.out.println("정답은 o또는 x로 입력해주세요.");
			wrongCount++;
		}
		
		System.out.println(q + "개의 문제를 푸셨습니다.");
		System.out.printf("%d개 문제의 정답을 맞추고 %d개 문제의 정답을 틀리셨습니다.", count, wrongCount);
		sc.close();
	}
}
