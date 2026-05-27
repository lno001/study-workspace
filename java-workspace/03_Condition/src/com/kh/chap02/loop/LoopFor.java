package com.kh.chap02.loop;

import java.util.Scanner;

import com.kh.chap01.condition.ConditionIf;

public class LoopFor {
	
	public void method0() {
	/*	
		System.out.println("자자자 여러분 곧 마지막시간입니다. 힘냅시다.");
		System.out.println("자자자 여러분 곧 마지막시간입니다. 힘냅시다.");
		System.out.println("자자자 여러분 곧 마지막시간입니다. 힘냅시다.");
	*/	
		for(int i = 0; i < 3768; i++) {
			System.out.println((i+1) + "번 반복시키고 싶은 코드를 작성해주세요~");
		}
		
		
	}
	
	public void method1() {
		// 1,2,3을 출력하고 싶을때

//		System.out.println(1);
//		System.out.println(2);
//		System.out.println(3);
		// System.out.println("1\n2\n3");
	
//		for(/* 1 */ int i = 1;/* 2 */ i <= 10;/* 4 */ i++) {
//			/* 3 */	System.out.println(i + "번 반복");
	
		for(int i = 0; i < 10; i += 2) {
			//if(i % 2 == 0) {
			System.out.println(i);
			//}
		}
		
		for(int i = 100; i >= 1; i--) {
			
			System.out.println(i);
		}
		
		
	}

	public void gugudan() {
		
		// 구구단 프로그램
		// 사용자에게 정수를 입력받아서
		
		// * 구구단을 외우자 *
		// 몇 단을 출력하시겠습니까? > (입력)
		// 4단을 출력하겠습니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("구구단을 외우자");
		System.out.print("몇 단을 출력하시겠습니까? > ");
		int num = sc.nextInt();
		
		/*
		int i = 1;
		System.out.println(num + "단을 출력하겠습니다.");
		
		System.out.println(num + " X " + i + " = " + (num * i++));
		System.out.println(num + " X " + i + " = " + (num * i++));
		System.out.println(num + " X " + i + " = " + (num * i++));
		System.out.println(num + " X " + i + " = " + (num * i++));
		System.out.println(num + " X " + i + " = " + (num * i++));
		System.out.println(num + " X " + i + " = " + (num * i++));
		System.out.println(num + " X " + i + " = " + (num * i++));
		System.out.println(num + " X " + i + " = " + (num * i++));
		System.out.println(num + " X " + i + " = " + (num * i++));
		*/
		
		if (1 <= num && num <= 9) {
			System.out.println(num + "단을 출력하겠습니다.");
			for(int i = 1; i < 10; i++) {
			System.out.println(num + " X " + i + " = " + (num * i));
			}
		} else {
			System.out.println("1부터 9까지의 정수만 입력해주세요.");
		}
		
		sc.close();
		
	}

	public void mainMenu() {
		
		for(;;) {
			System.out.println("메인메뉴입니다.");
			System.out.println("1. 구구단 놀이 시작하기");
			System.out.println("2. O/X퀴즈 시작하기");
			System.out.println("3. 프로그램 종료하기");
			Scanner sc = new Scanner(System.in);
			System.out.print("메뉴를 선택해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();
		//	System.out.println(menuNo);
			
			if(menuNo == 1) {
				System.out.println("구구단 놀이 시작합니다.");
				gugudan();
				System.out.print("구구단 놀이가 끝났습니다. \n아무 키나 누르면 메인메뉴로 넘어갑니다.");
				sc.nextLine();
			} else if(menuNo == 2) {
				System.out.println("O/X퀴즈 시작합니다.");
				ConditionIf ci = new ConditionIf();
				ci.quiz();
				System.out.println();
				System.out.print("O/X퀴즈가 끝났습니다. \n아무 키나 누르면 메인메뉴로 넘어갑니다.");
				sc.nextLine();
			} else if(menuNo == 3) {
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;
			} else {
				System.out.println("없는 메뉴를 선택하셨습니다. 다시 선택해주세요.");
			}
			System.out.println();
			sc.close();
		}
	}
}
