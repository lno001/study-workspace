package com.kh.chap01.condition;

import java.util.Scanner;

public class ConditionElse {

	public void method1() {
		
		// 핸드폰 번호 뒷자리를 입력받아서
		// 당첨자 번호랑 같으면 추카포카 아니면 다음기회에
		
		// 당첨 핸드폰 번호 뒷자리는 7777
		
		// 사용자에게 핸드폰 번호 뒷자리를 입력받아서
		// 당첨 핸드폰번호와	일치한다면 추카포카를 출력해주고
		// 				일치하지 않는다면 다음기회에를 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("핸드폰 번호 뒷자리 4개의 숫자를 입력해주세요 > ");
		String phoneNumber = sc.nextLine();
		// System.out.println(phoneNumber);
		
		if(phoneNumber.equals("7777")) {
			System.out.println("축하합니다~ 당첨되셨습니다~");
		} else {
			System.out.println("아쉽게 되었어요... 다음 기회를 노려보아요.");
		}
		// if (!(phoneNumber.equals("7777"))) { System.out.println("아쉽게 되었어요... 다음 기회를 노려보아요."); }
		sc.close();
	}
	
	public void method2() {
		// 핸드폰 뒷자리를 입력받아서 1등, 2등, 3등, 아쉽지만 미당첨을 출력해보기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("핸드폰 번호 뒷자리 4개를 입력해주세요 > ");
		String phoneNumber = sc.nextLine();
		System.out.print("고객님이 입력한 핸드폰 번호 뒷자리는 " + phoneNumber + "입니다.");
		
		String message = "등 당첨 축하드립니다 ☆*: .｡. o(≧▽≦)o .｡.:*☆";
		// 1등은 7777, 2등은 1111, 3등은 9999
		if(phoneNumber.equals("7777")) {
			System.out.println("1" + message);
		} else if(phoneNumber.equals("1111")) {
			System.out.println("2" + message);
		} else if(phoneNumber.equals("9999")) {
			System.out.println("3" + message);
		} else {
			System.out.println("아쉽지만 다음 기회에...");
		}
		sc.close();
	}
	
	public void ageCheck() {
		
		// 사용자에게 나이(정수)를 입력받고
		// 입력받은 나이에 따라서 각기 다른 내용을 출력해주세요.
		//  1 ~ 12 : 어린이입니다.
		// 13 ~ 17 : 청소년입니다.
		// 18 ~    : 성인입니다.
		//  0,-    : 잘 못 입력하셨습니다.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("당신의 나이를 입력해주세요. > ");
		int age = sc.nextInt();
		String message = "입니다.";
		
	//	if(1 <= age && age <= 12) {
	//		System.out.println("어린이" + message);
	//	} else if(13 <= age && age <= 17) {
	//		System.out.println("청소년" + message);
	//	} else if(18 <= age) {
	//		System.out.println("성인" + message);
	//	} else {
	//		System.out.println("잘 못 입력하셨습니다.");
	//	}
		
		if(age >= 18) {
			System.out.println("성인" + message);
		} else if (age >= 13) {
			System.out.println("청소년" + message);
		} else if (age >= 1) {
			System.out.println("어린이" + message);
		} else {
			System.out.println("잘 못 입력하셨습니다.");
		}
		sc.close();
	}
}
