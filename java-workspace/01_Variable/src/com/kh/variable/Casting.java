package com.kh.variable;

public class Casting {
	
	
	public void autoCasting() {
		
		//System.out.println("이 내용을 콘솔창에 출력해 보세요 실습 시작!");
		
		// int(정수, 4Byte) => double (실수, 8Byte)
		
		int num = 7;
		System.out.println(num);
		double doubleNum = (double)num;
		System.out.println(doubleNum);
		System.out.println(num);
		
		int bigNum = 120;
		long smallLong = bigNum;
		System.out.println(smallLong);
		
		// long (정수, 8byte) -> float(실수, 4byte) ** 특이케이스
		
		long longNumber = 1000L;
		float floatNumber = longNumber;
		System.out.println(floatNumber);
		
		// 4Byte float형이 long형보다 표현할 수 있는 값의 범위가 넓기 때문
		
		System.out.println("===============================");
		
		// char(2Byte, 문자) -> int(4Byte, 정수)
		
		char ch = '김';
		System.out.println(ch);
		int chNum = ch;
		System.out.println(chNum);
		char ch2 = 33;
		System.out.println(ch2);
		
		System.out.println("퀴즈퀴즈 시간~~~");
		System.out.println('a');		// -> a
		System.out.println((int)'a');	// -> 97
		System.out.println('a' + 3); 	// -> 100
		System.out.println('a' + '3');	// -> 148
		System.out.println((int)'3');	// -> 51
		System.out.println('a'+"3");	// -> a3
		
		System.out.println("===================================");
		
		System.out.println('3');		// -> 3
		System.out.println((char)3);	// -> 
		System.out.println((char)'3' + (char)3); // -> 54
		
		System.out.println("===================================");
		
		// 번외. byte 또는 short 간의 연산
		// byte 형은 -128 ~ 127 까지 표현 가능
		
		byte byteNum = (byte)128;
		
		System.out.println(byteNum);
		
		byte b2 = 126;
		byte b3 = 3;
		
		System.out.println(b2 + b3);
		
		// 결과값은 int형
		
		// 비교연산자 (==)
		
		System.out.println("비교 연산자를 사용해보자");
		System.out.println(1 == 2);				// false
		System.out.println('a' == 'b');			// false
		System.out.println(2 == (int)'2');		// false
		System.out.println((char)2 == '2');		// false
		// System.out.println((int)'2' == '2');	// true
		
		// 강제 형 변환 : 큰 크기의 자료형 -> 작은 크기의 자료형
		// 명시적 형변환이라고도 함
		
		double dNum = 10.123213;
		int iNum = (int)dNum;
		System.out.println(iNum);
		System.out.printf("%.2f \n", dNum);
		double ddNum = iNum;
		System.out.println(ddNum);
		
		
		
		
		
	}
	
	
	
	
}
