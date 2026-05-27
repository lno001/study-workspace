package com.kh.operator.controller;

import java.util.Scanner;

public class OperatorController {

	public void arithmetic() {
		// 산술연산자

		int num1 = 10;
		int num2 = 3;

		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		// test();

		System.out.println("num1 + num2 : " + num1 + num2);
		// 결과값은 num1 + num2 : 103
		System.out.println("num1 + num2 : " + (num1 + num2));
		int sum = num1 + num2;
		System.out.println("num1 + num2 : " + sum);
		System.out.print("num1 + num2 : ");
		System.out.println(num1 + num2);
		System.out.printf("num1 + num2 : %d\n", num1 + num2);
		System.out.println("num1 - num2 : " + (num1 - num2));
		System.out.println("num1 X num2 : " + (num1 * num2));
		System.out.println("num1 / num2 : " + (num1 / num2));
		System.out.println("num1 mod num2 : " + (num1 % num2));

		// 나눌 때 0으로 나눌 수없음
		// System.out.println(10 / 0);

	}

	public void test() {
		System.out.println("메소드를 호출 할 떄 꼭 메인에서만 불러야하는 것은 아닙니다!");
	}

	public void presentToStudent() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1. 나눠줄 학생의 수 : ");
		int st = sc.nextInt();
		System.out.println(st + "명의 학생이 있습니다.");

		System.out.print("2. 사탕 개수 : ");
		int ca = sc.nextInt();
		System.out.println(ca + "개의 사탕이 있습니다.");

		System.out.println("1인당 받을 수 있는 사탕의 갯수 : " + (ca / st) + "개");
		System.out.println("남은 사탕의 갯수 : " + (ca % st) + "개");
		sc.close();
	}

	public void inDecresase() {

	//	int num = 10;
	//	System.out.println(num); // 10
	//	num++;
	//	System.out.println(num); // 11
	//	num--;
	//	System.out.println(num); // 10
	//	System.out.println(num++); // 10
	//	System.out.println(num++); // 11
	//	System.out.println(num); // 12
		int num = 10;
		int number = num++;
		
		System.out.println("num : " + num);
		System.out.println("number : " + number);
		
		int a = 20;
		int b = a--;
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
		int c = 20;
		int d = c++ * 3;
		
		System.out.println(c);
		System.out.println(d);
		
		int e = 10;
		int f = e;
		
		System.out.println(e);
		System.out.println(f);
		
	}

	public void compound() {
		
		int endDay = 128;
		System.out.println(endDay);
		endDay = endDay -1;
		System.out.println(endDay);
		endDay -= 1;
		System.out.println(endDay);
		
		long veryBigNumberCount = 100000000000L;
		
		veryBigNumberCount = veryBigNumberCount + 1287 ;
		veryBigNumberCount += 1287 ;
				
		
	}
	
	public void logicalNagation () {
		
		System.out.println(!!!true);
		
	}
	
	public void comparison() {
		
		int firstNumber = 10;
		int secondNumber = 25;
		
		System.out.println(firstNumber < secondNumber);
		System.out.println(firstNumber == secondNumber);
		
		System.out.println("fitstNumber가 짝 수 입니까?");
		System.out.println((firstNumber % 2) == 0);		
		
		
	}
	
	public void logical() {
		
		// 1. 사용자에게 한 개의 정수값을 입력받음
		// 2. 입력한 정수 값이 0보다 크면서 짝수인지 연산
		// 3. 그리고나서 결과를 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 값을 입력해 주세요. : ");
		int a = sc.nextInt();
		System.out.println("입력한 정수의 값은 " + a + "입니다.");
		boolean b = (a > 0);
		System.out.println("입력한 값은 0보다 큰가요? : " + b);
		boolean c = (a % 2 == 0);
		System.out.println("입력한 값은 짝수인가요? : " + c);
		System.out.println(b && c);
		boolean result = (a > 0) && (a % 2 == 0);
		System.out.println(result);
		sc.close();
	}
	
	public void andOper() {
		
		// 사용자에게 정수값을 하나 입력받아서
		// 입력받은 정수값을 변수에 대입한 뒤
		// 콘솔창에 출력해보세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아무 정수값을 입력해주세요 : ");
		int num = sc.nextInt();
		System.out.println("입력한 정수값은 " + num + "입니다.");
		boolean a = ((num % 2) == 0);
		System.out.println("입력한 정수값은 짝수입니까? : " + a );
		
		// 사용자가 입력한 정수가 1 ~ 10 사이의 값인지 확인하기
		
		// boolean result = (num >= 1) && (num <= 10);
		boolean result = (1 <= num) && (num <= 10);
		System.out.println("입력한 정수값은 1~10사이의 값입니까? : " + result);	
		
		sc.close();
	}
	
	public void orOper() {
		
		// 사용자에게 한 글자를 입력 받아서
		// 입력받은 글자가 'A' 또는 'a'인지 확인해서 출력하기

		Scanner sc = new Scanner(System.in);
		
		System.out.print("꼭 한 글자만 입력해주세요 > ");
		char letter = sc.nextLine().charAt(0);
		System.out.println("입력한 글자는 " + letter + "입니다.");
		boolean result = (letter == 'a') || (letter == 'A');
		System.out.println("입력한 글자가 a나 A가 맞습니까? : " + result);
		
		
		
		sc.close();
		
	}
	
	public void tip() {
	//	int num = 10 ;
		
	//	boolean result = false && (num > 0);
	//	boolean result2 = num < 0 && num == 10;
		
	}
	
	public void triple() {
		System.out.println("깐부치킨에 오신것을 환영합니다.");
		System.out.println("1. 회장님의 입맛 그대로 AI치킨");
		System.out.println("2. 바삭한 식스팩 치킨");
		System.out.println("3. 치킨의 근본 후라이드 치킨");

		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴 번호를 입력해주세요 > ");
		int menuNo = sc.nextInt();
		
		/*	계획
		 *  사용자가 메뉴번호로
		 *  1번을 입력하면 회장님의 입맛 그대로 AI치킨을 주문하셨습니다.
		 *  2번을 입력하면 바삭한 식스팩 치킨을 주문하셨습니다.
		 *  3번을 입력하면 치킨의 근본 후라이드 치킨을 주문하셨습니다.
		 *  1번, 2번, 3번이 아니면 없는 메뉴를 주문하셨습니다.
		 * ↑ 이렇게 출력하고 싶음
		 */
		// System.out.println(menuNo);
		 
		// 메뉴번호가 1번일 시 AI치킨 머시기가 나오게 하고 1번이 아닐 시 없는 메뉴입니다 하고 출력
		
		String selected = menuNo == 1 ? "회장님의 입맛 그대로 AI치킨을 주문하셨습니다." 
						: menuNo == 2 ? "바삭한 식스팩 치킨을 주문하셨습니다."
						: menuNo == 3 ? "치킨의 근본 후라이드 치킨을 주문하셨습니다."
						: "없는 메뉴를 주문하셨습니다.";
		
		System.out.println(selected);
		sc.close();
	}
	
	
	
	
}
