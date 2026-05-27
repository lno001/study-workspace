package com.kh.chap01.condition;

import java.util.Scanner;

public class ConditionSwitch {

	public void method0() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 층 가세요? (B1 / B2 / B3) > ");
		String floor = sc.nextLine();
		int a = 0;
		
		switch(floor) {
		case "B1" : a = 1;
		break;
		case "B2" : a = 2;
		break;
		case "B3" : a = 3;
		break;
		default : System.out.println("잘못된 층 수입니다. 다시 입력해주세요.");
		sc.close();
		return;
		}
		
		System.out.printf("지하 %d층입니다. 문이 열립니다.", a);
		sc.close();
	}	
	
	public void findByName() {
		
		// 사용자에게 사람이름을 입력받아서
		// 사람의 정보를 출력해줄 것
		
		// 고길동, 짱구, 둘리, 도라에몽
		
		// 고길동		: 성별 : 남성, 주소 : 서울특별시 도봉구 쌍문동,	좋아하는 것 : 술,		싫어하는 것 : 둘리 일당
		// 짱구		: 성별 : 남성, 주소 : 서울특별시 초록구 떡잎마을,	좋아하는 것 : 가족, 	싫어하는 것 : 피망
		// 둘리		: 성별 : 수컷, 주소 : 서울특별시 도봉구 쌍문동,	좋아하는 것 : 장난치기,	싫어하는 것 : 고길동
		// 도라에몽	: 성별 : 없음, 주소 : 도쿄도 네리마구 츠키미다이,	좋아하는 것 : 노진구,	싫어하는 것 : 쥐
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름을 입력해주세요 > ");
		String name = sc.nextLine();
		//System.out.println(name);
		/*
		switch(name) {
		case "고길동" : System.out.println("고길동 : 성별 : 남성, 주소 : 서울특별시 도봉구 쌍문동, 좋아하는 것 : 술, 싫어하는 것 : 둘리 일당");
		break;
		case "짱구" : System.out.println("짱구 : 성별 : 남성, 주소 : 서울특별시 초록구 떡잎마을, 좋아하는 것 : 가족, 싫어하는 것 : 피망");
		break;
		case "둘리" : System.out.println("둘리 : 성별 : 수컷, 주소 : 서울특별시 도봉구 쌍문동, 좋아하는 것 : 장난치기, 싫어하는 것 : 고길동");
		break;
		case "도라에몽" : System.out.println("도라에몽 : 성별 : 없음, 주소 : 도쿄도 네리마구 츠키미다이, 좋아하는 것 : 노진구, 싫어하는 것 : 쥐");
		break;
		default : System.out.println("현재 등록된 이름은 고길동, 짱구, 둘리, 도라에몽 입니다.");
		}
		*/
		String address = switch(name) {
		case "고길동" , "둘리" -> "서울특별시 도봉구 쌍문동";
		case "짱구" -> "서울특별시 초록구 떡잎마을";
		case "도라에몽" -> "도쿄도 네리마구 츠키미다이";
		default -> "주소지 없음";
		};

		
		String favorite = "";
		switch(name) {
		case "고길동" : favorite = "술";
		break;
		case "둘리" : favorite = "장난치기"; 
		break;
		case "도라에몽" : favorite = "노진구"; 
		break;
		case "짱구" : favorite = "가족"; 
		break;
		default : System.out.println("그런 사람은 존재하지 않습니다.");
		sc.close();
		return;
		}
		
		System.out.println(name + " = 거주지 : " + address + ", 좋아하는것 : " + favorite);
		sc.close();
	}
	
	public void login() {
		// 구현한다
		// 기획 / 설계
		// 기획 -> 뭘 만들지?
		// 설계 -> 어떻게 만들지?
		
		// 로그인 구현 시 필요한 값
		// 1. 사용자가 입력한 아이디 값	-> 문자열
		// 2. 사용자가 입력한 비밀번호 값	-> 문자열
		
		// 로그인을 위해서 필요한 선행작업 : 회원가입
		// 회원가입은 다음의 정보로 했다고 가정
		String id = "user01";
		String password = "1234";
		String name = "김춘식";
		
		// 1. 사용자에게 로그인 화면을 출력
		// 2. 사용자에게 아이디와 패스워드를 입력받음
		// 3. 가입 시 입력했던 아이디와 비밀번호를 둘 다 정확히 입력한다면 로그인 성공 화면 출력
		// 4. 가입 시 입력했던 아이디 또는 비밀번호가 하나라도 일치하지 않을 경우 로그인 실패 화면 출력
		
		System.out.println("배달의 KH");
		System.out.println("-------------------------------------");
		System.out.println("로그인 서비스 입니다.");
		System.out.println("-------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("사용자의 아이디를 입력해 주세요 > ");
		String userId = sc.nextLine();
		System.out.println("=======================================");
		System.out.print("사용자의 비밀번호를 입력해 주세요 > ");
		String userPW = sc.nextLine();
		System.out.println("=======================================");

		// 만약에 사용자가 로그인 시 입력한 아이디 값과 회원가입 시 입력한 아이디 값이 동일하고
		// 사용자가 로그인 시 입력한 패스워드 값과 회원가입시 입력한 패스워드 값이 동일하다면
		
		if(id.equals(userId) && password.equals(userPW)) {
			System.out.println(name + "님 환영합니다.");
		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
	
		sc.close();
	}
}
