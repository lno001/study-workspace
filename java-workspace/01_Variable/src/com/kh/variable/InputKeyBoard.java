package com.kh.variable;

import java.util.Scanner;

public class InputKeyBoard {
	
	public void inputTest() {
		
		Scanner sc = new Scanner(System.in);
		// System.in : 표준 입력 도구에서 입력하는 값들을 받겠음(바이트 단위)
		
		System.out.println("피자핫에 오신 것을 환영합니다.");
		System.out.println("------------ 피자핫 메뉴판 ------------");
		System.out.println("1. 피즈/페페로니 핏자");
		System.out.println("2. 블랙 BBQ 스테이크 뇨끼 핏자");
		System.out.println("3. 이재모 핏자");
		System.out.println("------------------------------------");
		System.out.print("주문하실 메뉴를 선택해주세요 > ");
		
		String select = sc.next();
		System.out.println(select + "를 주문하신게 맞습니까?");
		
		// 개수 : 몇 판이요?
		System.out.print("몇 판 주문하시겠습니까(숫자로 입력해주세요) > ");
		sc.nextLine();		
		int pizzaNumber = sc.nextInt();
		System.out.println(select + "를 " + pizzaNumber + "판을 주문하신게 맞습니까?");
		
		System.out.print("주소를 입력해주세요 > ");
		sc.nextLine();
		String address = sc.nextLine();
		
		System.out.println(address + "로 배달합니다.");
		
		
		sc.close();
		
	}
	
	
	
	
}
