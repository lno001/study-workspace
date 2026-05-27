package com.kh.operator.controller;

import java.util.Scanner;


public class CookieStudent {

	public void presentToStudent() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1. 나눠줄 학생의 수 : ");
		int st = sc.nextInt();
		System.out.println(st + "명의 학생이 있습니다.");
		
		System.out.print("2. 쿠키 갯수 : ");
		int co = sc.nextInt();
		System.out.print(co + "개의 쿠키가 있습니다.");
		
		sc.close();
		
	}
	
}
