package com.kh.variable;

public class Variable {
	
	// 변수 : Memory(RAM)에 값을 저장하기 위한 "공간"
	
	// 변수 맛보기 --> 예시로 실제로 쓰지 말기
	public void 바지를저장하는기능() {
		String 옷장 = "긴바지";
		String 행거 = "반바지";
		System.out.println(옷장);
		System.out.println(행거);

		
	}

	// 변수를 사용했을 떄 장점!	
	// 점심메뉴 출력 프로그램(키오스크)
	public void findLunchMenu() {
		
		// 1. 메뉴들을 출력(메뉴명, 가격)
		// 2. 주문을 했을 때 가정
		// 3. 주문 금액을 출력
		
		System.out.println("--- 변수를 사용하기 전 ---");
		System.out.println("< 메뉴판 > ");
		System.out.println("1. 트리플 치즈버거 세트(15000)");
		System.out.println("2. 빅맥 세트(8397)");
		System.out.println("3. 슈슈버거 세트(9210)");
		
		// 트리플 치즈버거는		4명이 주문
		// 빅맥 세트는			9명이 주문
		// 1995 세트는	 	4명이 주문

		System.out.println("---------------------------------");
		System.out.print("트리플 치즈버거 4개 주문 ");
		System.out.println((15000*4) + "원 입니다.");
		System.out.print("빅맥 9개 주문 ");
		System.out.println((8397*9) + "원 입니다.");
		System.out.print("슈슈 버거 4개 주문 ");
		System.out.println((9210*4) + "원 입니다.");
		System.out.println("=================================");

		System.out.println("변수를 사용해 봅시다!");
		System.out.println("---------------------------------");
		// 메뉴명과 가격이라는 값을 담을 공간
		// 변수를 선언하고 변수공간에 값을 대입해서 사용!
		String setOne = "KH아카데미표 슈슈버거 세트";
		int setOnePrice = 9800;
		int setOneT =10;
		String setTwo = "KH아카데미표 비크매크 세트";
		int setTwoPrice	= 8800;
		int setTwoT = 4;
		String setThr = "KH아카데미표 치즈버거 세트";
		int setThrPrice = 7600;
		int setThrT = 7;
		
		System.out.println("< 메뉴판 >");
		System.out.println(setOne + ", 가격 : " + setOnePrice);
		System.out.println(setTwo + ", 가격 : " + setTwoPrice);
		System.out.println(setThr + ", 가격 : " + setThrPrice);
		
		System.out.println("---------------------------------");
		System.out.println(setOne + "를 " + setOneT + "개 시켰습니다.");
		System.out.println((setOnePrice * setOneT) + "원 입니다.");
		System.out.println(setTwo + "를 " + setTwoT + "개 시켰습니다.");
		System.out.println((setTwoPrice * setTwoT) + "원 입니다.");
		System.out.println(setThr + "를 " + setThrT + "개 시켰습니다.");
		System.out.println((setThrPrice * setThrT) + "원 입니다.");
	}
	
	// 변수를 사용하는 방법에 대해 알아보자
	public void declareVariable() {
		/*	변수 선언 방법
		 * 	int price;
		 * 	자료형(DataType) 변수식별자;
		 *	권장하는 방법은 아니지만 동일한 타입의 변수는 한번에 선언 할 수있음
		 *	int a,b,c;
		 */
				
		// 변수에 값을 대입하고 출력하기 위해서는 선언 및 초기화 작업이 필요함
		
		boolean isTrue; 	// 변수 선언
		isTrue = true;  	// 지역 변수 초기화
		System.out.println(isTrue);
		isTrue = false;		// 변수의 값을 대입
		System.out.println(isTrue);
		
		byte byteNumber = 1;	// 1Byte 0~255
		short shortNumber = 2;	// 2Byte 0~65535
		int intNumber = 3;		// 4Byte 0~4294967295
		long longNumber = 4L;	// 8Byte 
		
		float floatNumber = 2.22F;	// 4Byte
		double doubleNumber = 3.33;	// 8Byte
		
		char money = '돈';	// 2Byte
		
		String str = "문자열"; 
		
		System.out.println("논리 자료형 : " + isTrue);
		System.out.println("정수 자료형 : " + byteNumber);
		System.out.println("정수 자료형 : " + shortNumber);
		System.out.println("정수 자료형 : " + intNumber);
		System.out.println("정수 자료형 : " + longNumber);
		System.out.println("실수 자료형 : " + floatNumber);
		System.out.println("실수 자료형 : " + doubleNumber);
		System.out.println("(단일)문자 자료형 : " + money);
		System.out.println("문자열 자료형 : " + str);
	
		System.out.println("------------------------------");

		System.out.println("논리 자료형 : " + isTrue);
		System.out.println("정수 자료형 : " + byteNumber + ", " + shortNumber + ", " + intNumber + ", " + longNumber);
		System.out.println("실수 자료형 : " + floatNumber + ", " + doubleNumber);
		System.out.println("(단일)문자 자료형 : " + money);
		System.out.println("문자열 자료형 : " + str);
		
		System.out.println("------------------------------");
		
		System.out.printf("논리 자료형 : %b \n정수 자료형 : %d, %d, %d, %d", isTrue, byteNumber, shortNumber, intNumber, longNumber);
		System.out.printf("\ndoubleNum 값 : %.2f \n", doubleNumber);
		
		System.out.println("==============================");
		
		// 상수 => 프로그래밍 언어 => 값을 변경하지 않을 변수 공간
		
		int startYear = 1998;
		startYear = 2026;
		
		final int START_YEAR = 1998;
		
		System.out.println(startYear + START_YEAR);
	}
	
	// 출력문의 종류
	
	
	
	
	
	
	
	
	
	
	
}
