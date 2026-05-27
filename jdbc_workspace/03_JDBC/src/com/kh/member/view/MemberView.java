package com.kh.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.member.controller.MemberController;
import com.kh.member.exception.DuplicateMemberIdException;
import com.kh.member.exception.MemberIdToLargeException;
import com.kh.member.model.dto.BoardDto;
import com.kh.member.model.dto.LoginResponse;
import com.kh.member.model.dto.MemberDto;

public class MemberView {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	private LoginResponse lr = null;
	
	public void mainMenu() {
		while(true) {
			System.out.println("=======================");
			System.out.println("회원서비스에 오신것을 환영합니다.");
			System.out.println("-----------------------");
			if(lr != null) {
				System.out.println("1. 로그아웃");
				System.out.println("2. 게시판 이동");
			} else {
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
			}
			System.out.println("0. 프로그램 종료");		
			System.out.print("원하시는 메뉴를 선택해주세요 > ");
			String menu = sc.nextLine();
			if(lr != null) {
				switch(menu) {
				case "1" : logout(); break;
				case "2" : boardMenu(); break;
				case "0" : return;
				default  : System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
				}
			} else {
				switch(menu) {
				case "1" : signUp(); break;
				case "2" : login(); break;
				case "0" : return;
				default  : System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
				}
			}
		}
	}
	
	private void boardMenu() {
		while(true) {
			System.out.println("=======================");
			System.out.println("게시판 서비스입니다.");
			System.out.println("-----------------------");
			System.out.println("1. 게시글 작성");
			System.out.println("2. 게시글 전체 조회");
			System.out.println("3. 게시글 상세 조회");
			System.out.println("0. 이전 메뉴로 돌아가기");
			System.out.print("원하시는 메뉴를 선택해주세요 > ");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : insertBoard(); break;
			case "2" : selectBoardList(); break;
			case "3" : selectBoard(); break;
			case "0" : return;
			default  : System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
		}
	}

	private void signUp() {
		System.out.println("=======================");
		System.out.println("회원가입 서비스입니다.");
		System.out.println("-----------------------");
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
		System.out.println("-----------------------");

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

	private void login() {
		System.out.println("=======================");
		System.out.println("로그인 화면 입니다.");
		System.out.println("-----------------------");
		System.out.print("아이디를 입력해주세요 > ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 > ");
		String memberPwd = sc.nextLine();
		
		MemberDto loginMember = new MemberDto();
		loginMember.setMemberId(memberId);
		loginMember.setMemberPwd(memberPwd);
		LoginResponse lr = mc.login(loginMember);
		
		if(lr != null) {
			System.out.println("로그인 성공");
			this.lr= lr;
		} else {
			System.out.println("로그인 실패");
		}
	}

	private void logout( ) {
		lr = null;
		System.out.println("=======================");
		System.out.println("로그아웃 성공");
	}
	
	private void insertBoard() {
		
		int result = mc.selectInsertCount(lr.getMemberId());
		
		if(5 > result) {
			System.out.println("게시글 작성 권한이 없습니다.");
			return;
		}
		
		System.out.println("게시글 작성 서비스입니다.");
		System.out.print("게시글 제목을 입력하세요 > ");
		String title = sc.nextLine();
		System.out.print("게시글 내용을 입력하세요 > ");
		String content = sc.nextLine();
		
		int insertResult = mc.insertBoard(new BoardDto(title, content, lr.getMemberId()));
		
		if(insertResult > 0) {
			System.out.println("게시글 작성 성공");
		} else {
			System.out.println("게시글 작성 실패");
		}
	}
	
	private void selectBoardList() {
		System.out.println("=======================");
		System.out.println("게시글 전체 조회 서비스입니다.");
		System.out.println("-----------------------");
		
		List<BoardDto> boards = mc.selectBoardList();
		
		if(boards.isEmpty()) {
			System.out.println("게시글이 아직 존재하지 않습니다.");
		} else {
			for(BoardDto board : boards) {
				System.out.println("글 번호 : " + board.getBoardNo() + " | 제목 : " + board.getBoardTitle() + " | 작성자 : " + board.getBoardWriter());
			}
		}
	}
	
	private void selectBoard() {
		System.out.println("=======================");
		System.out.println("게시글 상세 조회 서비스입니다.");
		System.out.println("-----------------------");
		System.out.print("상세 조회 할 게시글 번호를 입력해주세요 > ");
		String boardNo = sc.nextLine();
		
		BoardDto board = mc.selectBoard(boardNo);
		
		if(board != null) {
			System.out.println(board.getBoardNo() + "번 게시글");
			System.out.println("=======================");
			System.out.println("제목 : " + board.getBoardTitle());
			System.out.println("-----------------------");
			System.out.println("내용 : " + board.getBoardContent());
			System.out.println("-----------------------");
			System.out.println("작성자 : " + board.getBoardWriter());
		} else {
			System.out.println("해당 게시글 번호의 게시글은 없습니다.");
		}
		
	}
}