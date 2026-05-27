package com.kh.member.view;

import java.util.Scanner;

import com.kh.member.controller.MemberController;
import com.kh.member.exception.DuplicateMemberIdException;
import com.kh.member.exception.MemberIdToLargeException;
import com.kh.member.model.dto.MemberDto;

public class MemberView {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		while(true) {
			System.out.println();
			System.out.println("회원서비스에 오신것을 환영합니다.");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 프로그램 종료");		
			System.out.print("원하시는 메뉴를 선택해주세요 > ");
			String menu = sc.nextLine();
			switch(menu) {
			case "1" : signUp(); break;
			case "0" : return;
			default  : System.out.println("잘못된 번호 입니다. 다시 입력해주세요.");
			}
		}
	}

	private void signUp() {
		System.out.println("회원가입 서비스입니다.");
		
		String memberId;
		while(true) {
			System.out.print("사용하실 아이디를 입력해주세요 > ");
			memberId = sc.nextLine();
			
			if(!mc.checkId(memberId)) {
				break;
			}
			System.out.println("이미 존재하는 아이디 입니다.");
		}
		System.out.print("사용하실 비밀번호를 입력해주세요 > ");
		String memberPwd = sc.nextLine();
		System.out.print("사용하실 이름을 입력해주세요 > ");
		String memberName = sc.nextLine();
		MemberDto member = new MemberDto(memberId, memberPwd, memberName);
		
		try {
			int result = mc.signUp(member);
			
			if(result > 0) {
				System.out.println("회원가입 성공");
			} else {
				System.out.println("회원가입 실패");
			}
		} catch(MemberIdToLargeException e) {
			System.out.println("아이디가 너무 길어요.");
		} catch (DuplicateMemberIdException e) {
			System.out.println("중복된 아이디입니다.");
		}
		
		
		
		
	}















}