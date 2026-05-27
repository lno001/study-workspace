package com.kh.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
	
	public void divZero() {
		// 사용자에게 두 개의 정수값을 입력받아서 나눗셈을 한 뒤 결과를 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나누기 프로그램입니다.");
		System.out.print("첫 번째 정수를 입력해주세요 > ");
		int num1 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("두 번째 정수를 입력해주세요 > ");
		int num2 = sc.nextInt();
		
//		if(num2 != 0) {
//		System.out.println("연산 결과 : " + (num1 / num2));
//		} else {
//			System.out.println("0은 나누기 연산을 수행할 수 없습니다.");
//		}
		
		try {
			System.out.println("연산 결과 : " + (num1 / num2));
		} catch (ArithmeticException e) {
			System.out.println("두 번째 정수에 0을 입력하시면 나누기 연산을 수행할 수 없습니다.");
		}
				
		sc.close();
	}
	
	public void code() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1. 추가하기");
			System.out.println("2. 삭제하기");
			System.out.println("3. 종료하기");
			System.out.print("1번 또는 2번을 입력해주세요. > ");
			int menu = 0;
			try {
			menu = sc.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.");
			}
			sc.nextLine();
			System.out.println(menu + "번 메뉴를 선택하셨습니다.");
			
			sc.close();
		}
	}
	
	public void multiCatch() {
		Scanner sc = new Scanner(System.in);
		// 사용자에게 정수값을 하나 입력받아서
		// 100을 사용자가 입력한 정수값으로 나눈 결과를 출력
		
		System.out.print("정수를 입력해주세요 > ");
		try {
		int num = sc.nextInt(); // 자료형이 int형이 아닌 값이 들어올 시 InputMismatchException이 발생
		sc.nextLine();
		System.out.println("결과 : " + (100/ num)); // num에 대입된 값이 0일 시 ArithmeticException이 발생
		} catch(InputMismatchException e) {
			System.out.println("숫자값을 입력해주세요.");
		} catch(ArithmeticException e) {
			System.out.println("0이 아닌 정수값을 입력해주세요.");
		} finally {
			sc.close();
		}
	}
	
	public void orderByCatch() {
		// 배열
		// 사용자에게 정수값을 입력받아서
		// 입력받은 만큼의 크기를 가진 배열을 생성 및 할당하고
		// 이 배열의 100번째 인덱스에 대입되어있는 기본값을 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력해주세요 > ");
		// InputMismatchException : 스캐너 메소드의 자료형과 일치하지 않는다면
		// NegativeArraySizeException : 배열의 크기를 음수로 할당하려고 하면
		// ArrayIndexOutOfBoundsException : 배열의 크기보다 큰 인덱스에 접근하면
		try {
		int size = sc.nextInt(); 
		sc.nextLine();
		int[] arr = new int[size];
		System.out.println(arr[100]);
		} catch(RuntimeException e) {
			e.printStackTrace(); // 개발단계에서만 사용
			System.out.println("정수값을 입력해주세요");
		} finally {
			sc.close();
		}
		
	}
}
