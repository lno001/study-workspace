package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
	
	public void method1() {
		// 다섯 개의 정수를 변수에 대입한 뒤 정수값을 모두 더한 값을 출력
//		int num1 =6 ;
//		int num2 =84 ;
//		int num3 =1 ;
//		int num4 =23 ;
//		int num5 =34 ;
//		int sum = num1 + num2 + num3 + num4 + num5;
//		
//		System.out.println(sum);
		
		// 변수 선언!
		// int num = 0;
		
		// 배열 선언!
		// int[] nums;
		// nums = new int[2];
		
		int[] nums = new int[2] ;
		// nums라는 정수형 배열을 선언하고 2칸 할당받음
		// nums에는 배열의 주소값이 저장된다
		// 배열에 값 대입 => index개념
		// System.out.println(nums);
		
		nums[0] = 45;
		nums[1] = 53;

		System.out.println(nums[0] + " " + nums[1]);
		
		int sum = 0;
		for(int i = 0; i < 2; i++) {
			sum += nums[i];
		}
		System.out.println("배열 요소의 값 합계 : " + sum);
		
	}
	
	public void method2() {
		
		// 1. 배열 선언 및 할당
		
		int i;
		i = 2;
		int[] integers = new int[3];  // 0, 1, 2
		// integers = 3;
		
		// 배열식별자.length : 배열의 크기(길이) => 정수
		System.out.println(integers.length);
		
		 System.out.println(i);
		// localvariable == 초기화를 진행하지 않으면 사용할 수 없음
		System.out.println(integers[0]);
		
//		String[] KH정보교육원종로점 = new String[5];
//		System.out.println(KH정보교육원종로점);
//		KH정보교육원종로점[0] = "301강의실";
//		KH정보교육원종로점[1] = "302강의실";
//		KH정보교육원종로점[2] = "501강의실";
//		KH정보교육원종로점[3] = "502강의실";
//		KH정보교육원종로점[4] = "사무실";
//		
//		System.out.println(KH정보교육원종로점[2]);
		
		int number1 = 3;
		int number2 = 3;
		System.out.println(number1 == number2);
		
		int[] numbers1 = new int[3];
		int[] numbers2 = new int[3];
		System.out.println(numbers1 == numbers2);

		// 해시코드 : 주소값을 10진수(int형)형태로 나타낸 것
		System.out.println(numbers1.hashCode());
		System.out.println(numbers2.hashCode());
		
		
		
	}
	
	public void createLottoNumber() {
		
		// 로또 번호 생성기 ver 0.2
		
		int[] lottoNumbers = new int[6];
		
//		lottoNumbers[0] = (int)(Math.random() * 45) + 1;
//		lottoNumbers[1] = (int)(Math.random() * 45) + 1;
//		lottoNumbers[2] = (int)(Math.random() * 45) + 1;
//		lottoNumbers[3] = (int)(Math.random() * 45) + 1;
//		lottoNumbers[4] = (int)(Math.random() * 45) + 1;
//		lottoNumbers[5] = (int)(Math.random() * 45) + 1;
		
		for(int i = 0; i < 6; i++) {
			lottoNumbers[i] = (int)(Math.random() * 45) + 1;
		}
		
		// Arrays.toString(배열식별자) => 배열의 요소를 이쁘게 출력해줌
		System.out.println("이번 로또 당첨번호는 " + Arrays.toString(lottoNumbers) +"입니다.");
		
	}
	
	public void method3() {
		// 구구단을 담는 9칸 짜리 배열을 선언 및 할당
		
		String[] gugudan = new String[9];
		
//		gugudan[0] = "2 X 1 = 2";
//		gugudan[1] = "2 X 2 = 4";
//		gugudan[2] = "2 X 3 = 6";
//		gugudan[3] = "2 X 4 = 8";
//		gugudan[4] = "2 X 5 = 10";
//		gugudan[5] = "2 X 6 = 12";
//		gugudan[6] = "2 X 7 = 14";
//		gugudan[7] = "2 X 8 = 16";
//		gugudan[8] = "2 X 9 = 18";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("구구단에서 보고 싶은 단의 수를 입력하세요. (1 ~ 9) > ");
		int num = sc.nextInt();
		
		if (1 <= num && num <= 9) {
			for (int i = 0; i < 9; i++) {
				gugudan[i] = num + " X " + (i+1) + " = " + num*(i+1);
			}
			
			System.out.println(Arrays.toString(gugudan));
		} else {
			System.out.println("1에서 9까지의 정수만 입력해주세요.");
		}
		sc.close();
	}
	
	public void method4() {
		
		char[] love = new char[4];
		System.out.println(love);
		love[0] = 'L';
		love[1] = 'O';
		love[2] = 'V';
		love[3] = 'E';
		
		char[] apple = {'a','p','p','l','e'};
		
		System.out.println(Arrays.toString(love));
		System.out.println(love.length);
		love[1] = 'I';
		System.out.println(Arrays.toString(love));
		System.out.println(Arrays.toString(apple));
		System.out.println(love);
		System.out.println(love.hashCode());
		love = new char[5];
		love[4] = 'R';
		System.out.println(Arrays.toString(love));
		System.out.println(love.hashCode());
		
		love = null;
		// System.out.println(love);
	}
	
	public void method5() {
		
		int[] arr = {100, 200, 300};
		System.out.println(Arrays.toString(arr));
		System.out.println(arr);
		
						
	}
	
	public void method6() {
		int[] origin = {1, 2, 3};
		// new int[3];
		// origin[0]= 1; origin[1]= 2; origin[2]= 3;
		System.out.println(Arrays.toString(origin));
		
		// 얕은 복사로 배열을 복사
		int[] copy = origin;
		System.out.println(Arrays.toString(copy));
		
		origin[2] = 33;
		System.out.println(Arrays.toString(origin));
		System.out.println(Arrays.toString(copy));
		
	}
	
	public void method7() {
		
		int[] origin = {1, 2, 3};
		int[] copy = new int[6];
		System.out.println(Arrays.toString(origin));
		
//		copy[0] = origin[0];
//		copy[1] = origin[1];
//		copy[2] = origin[2];
		
//		for(int i = 0; i < origin.length; i++) {
//			copy[i] = origin[i];
//		}
		
		System.out.println(Arrays.toString(copy));
		int[] copy2 = new int[10];
		
		System.arraycopy(origin, 0, copy2, 0, 3);
		System.out.println(Arrays.toString(copy2));
		
		int[] copy3 = Arrays.copyOf(origin, 15);
		System.out.println(Arrays.toString(copy3));
		
		int[] copy4 = origin.clone();
		System.out.println(Arrays.toString(copy4));
	}
	
}
