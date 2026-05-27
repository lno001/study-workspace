package com.kh.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CheckedException {
	
	public void readString() {
		System.out.println("나는 체크드 인셉션");
		// 사용자에게 문자열을 하나만 입력받아서
		// 입력받은 문자열의 길이를 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		sc.close();
		try {
			String str = br.readLine();
			System.out.println(str.length());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
//	private void method() throws IOException{
//		System.out.println("아주아주아주아주위험한 코드");
//		throw new RuntimeException("예외발생");
//	}

}
