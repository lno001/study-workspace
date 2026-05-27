package com.kh.chap03.escape;

import java.util.Scanner;

public class EscapeBreak {
	
	public void method1() {
		// 무한 반복을 돌리면서
		// 매 번 사용자에게 문자열을 입력받은 후
		// 해당 문자열의 길이를 출력
		// 단, 사용자가 입력한 문자열 "exit"과 같다면 반복을 종료
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("글자수 체크 프로그램(종료하고 싶으시면 'exit'을 입력하세요.)");
			String keyword = sc.nextLine();
			
			if(keyword.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			System.out.println(keyword + "은(는) " + keyword.length() + "글자 입니다!");
			
			System.out.print("계속하고 싶으면 엔터를 눌러주세요.(종료하고 싶으시면 'exit'을 입력하세요.)");
			sc.nextLine();
			
			
		}
		
		 System.out.println("다음에 또 오세요 ~~~");
		 sc.close();
	}
	
	public void checkId() {
		System.out.println("회원가입 서비스입니다.");
		Scanner sc = new Scanner(System.in);
		
		// 사용자에게 아이디 값을 입력 받을 것인데 10글자가 넘으면 다시 입력하게 할 것
		//								  10글자가 넘지 않으면 다음 파트로 진행 할 것
		
		while(true) {
			System.out.print("아이디를 입력해주세요 (10글자 이하) > ");
			String userId = sc.nextLine();
			
			if(userId.length() <= 10) {
				System.out.println("사용 가능한 아이디 입니다.");
				break;
			} else {
				System.out.println("아이디는 10자 이하만 사용 가능합니다.");
				continue;
			}
			
		}
		
		System.out.println("비밀번호를 ~");
		sc.close();
	}
	
	
}
