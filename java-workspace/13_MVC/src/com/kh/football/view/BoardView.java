package com.kh.football.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.football.controller.BoardController;
import com.kh.football.model.dto.BoardDto;
import com.kh.football.model.vo.Board;

public class BoardView {
	private BoardController bc = new BoardController();
	private Scanner sc = new Scanner(System.in);
	
	public void boardMenu() {
		while(true) {
			System.out.println("\n\n\n\n\n");
			findAll();
			System.out.println();
			System.out.println("축구이야기 게시판입니다.");
			System.out.println("1. 게시글 상세보기");
			System.out.println("2. 게시글 작성");
			System.out.println("3. 게시글 수정");
			System.out.println("4. 게시글 삭제");
			System.out.println("5. 축구메뉴로 돌아가기");
			System.out.println();
			
			System.out.print("원하시는 메뉴를 선택해주세요 > ");
			String menu = sc.nextLine();
		
			switch(menu) {
			case "1" : findById(); 
			break;
			case "2" : saveBoard(); 
			break;
			case "3" : updateBoard();
			break;
			case "4" : deleteBoard();
			break;
			case "5" : 
			return;
			default : System.out.println("메뉴를 다시 선택해주세요!");
			}
		}
	}

	private void findAll() {
		List<Board> boards = bc.findAll();
		
		if(boards.isEmpty()) {
			System.out.println("========================================");
			System.out.println("아직 게시글이 존재하지 않습니다.");
			System.out.println("첫 글의 주인공이 되어보세요~");
			System.out.println("========================================");
		} else {
			System.out.println("게시물 목록 :");
			System.out.println();
			System.out.println("========================================");
			boards.stream().map(b -> b.getBoardNo() + " || " 
								+ b.getBoardTitle() + " || " 
								+ b.getBoardWriter() + " || " 
								+ b.getCreateDate()).forEach(System.out::println);
			
			System.out.println("========================================");
			
			for(Board board : boards) {
				System.out.println(board.getBoardNo() + " || " 
									+ board.getBoardTitle()	+ " || " 
									+ board.getBoardWriter() + " || " 
									+ board.getCreateDate());
			}
			System.out.println("========================================");
		}
	}
	
	private void findById() {
		
		findAll();
		while(true) {
		System.out.print("상세보기를 하실 게시글 번호를 입력해주세요. > ");
		int boardNo = 0;
		
		try {
			boardNo = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e){
			System.out.println("게시글 번호는 숫자만 입력가능합니다.");
			sc.nextLine();
			return;
		}
		Board board = bc.findById(boardNo);
			if(board != null) {
				System.out.println("-------------------------");
				System.out.println(boardNo + "번 게시글");
				System.out.println();
				System.out.println("제목 : ");
				System.out.println("-------------------------");
				System.out.println(board.getBoardTitle());
				System.out.println("본문 : ");
				System.out.println("-------------------------");
				System.out.println(board.getBoardContent());
				System.out.println();
				System.out.println("-------------------------");
				System.out.println("작성자 : " + board.getBoardWriter() 
									+ " | 작성일 : " + board.getCreateDate());
				System.out.println("-------------------------");
			
			} else {
				System.out.println("존재하지 않는 게시글 번호입니다.");
			}
			
			System.out.print("메뉴로 돌아가시려면 돌아가기를 입력하세요. > ");
			String exit = sc.nextLine();
			
			if("돌아가기".equals(exit)) {
				return;
			}
		}
		
	}
	
	private void saveBoard() {
		
		// 입력값을 뭘 받아야하지?
		// 제목, 내용, 작성자, 비밀번호
		System.out.println("게시글 작성 서비스입니다.");
		System.out.print("게시글의 제목을 입력해주세요 > ");
		String title = sc.nextLine();
		System.out.print("게시글의 내용을 입력해주세요 > ");
		String content = sc.nextLine();
		System.out.print("게시글의 작성자를 입력해주세요 > ");
		String writer = sc.nextLine();
		System.out.print("게시글의 비밀번호를 입력해주세요 > ");
		String password = sc.nextLine();
		bc.saveBoard(new BoardDto(title, content, writer, password));
	}

	private void updateBoard() {
		findAll();
		
		System.out.println("게시글 수정 서비스입니다.");
		System.out.print("수정하실 게시글 번호를 입력해주세요 > ");
		int boardNo = 0;
		try {
			boardNo = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("게시글 번호는 숫자만 가능합니다.");
			sc.nextLine();
			return;
		}
		
		Board b = bc.findById(boardNo);
		
		if(b != null) {
			System.out.print("게시글 작성자를 입력해주세요 > ");
			String writer = sc.nextLine();
			System.out.print("게시글 비밀번호를 입력해주세요 > ");
			String password = sc.nextLine();
			System.out.print("수정할 제목을 입력해주세요 > ");
			String title = sc.nextLine();
			System.out.print("수정할 내용을 입력해주세요 > ");
			String content = sc.nextLine();
			
			Board updatedBoard = bc.updateBoard(boardNo, new BoardDto(title, content, writer, password));
			
			
			if(updatedBoard != null) {
				System.out.println("-------------------------");
				System.out.println(boardNo + "번 게시글");
				System.out.println();
				System.out.println("제목 : ");
				System.out.println("-------------------------");
				System.out.println(updatedBoard.getBoardTitle());
				System.out.println("본문 : ");
				System.out.println("-------------------------");
				System.out.println(updatedBoard.getBoardContent());
				System.out.println();
				System.out.println("-------------------------");
				System.out.println("작성자 : " + updatedBoard.getBoardWriter() 
									+ " | 작성일 : " + updatedBoard.getCreateDate());
				System.out.println("-------------------------");
			
			} else {
				System.out.println("존재하지 않는 게시글 번호입니다.");
			}
			
			System.out.print("메뉴로 돌아가시려면 돌아가기를 입력하세요. > ");
			String exit = sc.nextLine();
			
			if("돌아가기".equals(exit)) {
				return;
			}
		
			
		} else {
			System.out.println("존재하지 않는 게시글 번호입니다.");
		}
		
	}
	
	private void deleteBoard() {
		findAll();
		// 게시글 번호
		System.out.println("게시글 삭제 서비스입니다.");
		System.out.print("삭제하실 게시글 번호를 입력해주세요 > ");
		
		int boardNo = 0;
		try {
			boardNo = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("게시글 번호는 숫자만 가능합니다.");
			sc.nextLine();
			return;
		}
		
		int result = bc.deleteBoard(boardNo);
	//	Board b = bc.findById(boardNo);
		
		if(result > 0) {
			System.out.println("게시글 삭제에 성공했습니다!");
		} else {
			System.out.println("게시글 삭제에 실패했습니다...");
		}
		
	}
}
