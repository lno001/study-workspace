package com.kh.football.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.football.controller.FootballController;
import com.kh.football.model.dto.FootballPlayerDto;
import com.kh.football.model.vo.FootballPlayer;

public class FootballView {
	private Scanner sc = new Scanner(System.in);
	private FootballController fc = new FootballController();
	private BoardView bv = new BoardView();
	// 프로그램 실행 시 보여줄 화면을 출력해주는 기능
	public void mainMenu() {
		// 축구선수 CRUD
		// CREATE : 사용자에게 축구선수의 이름, 포지션, 등번호를 입력받아 저장
		// READ : 만들어진 축구선수들을 조회
		// UPDATE : 기존에 존재하는 축구선수의 정보를 수정
		// DELETE : 기존에 존재하는 축구선수의 정보를 삭제
		while(true) {
			System.out.println();
			System.out.println("축구선수 관리 프로그램입니다.");
			System.out.println("1. 축구선수 전체 조회하기");
			System.out.println("2. 축구선수 추가하기");
			System.out.println("3. 축구선수 수정하기");
			System.out.println("4. 축구선수 삭제하기");
			System.out.println("5. 축구선수 정보 파일로 출력하기");
			System.out.println("6. 축구선수 검색하기");
			System.out.println("7. 축구 이야기 게시판");
			// 축구선수 검색하기, 축구선수 목록 파일로 저장하기
			System.out.println("0. 프로그램 종료하기");
			System.out.println();
			System.out.print("어떤 기능을 이용하시겠습니까? > ");
			int menu = 0;
			try {
			menu = sc.nextInt();
			sc.nextLine();
			} catch(InputMismatchException e) {
				System.out.println("숫자만 입력해주세요");
				sc.nextLine();
				continue;
			}
			switch(menu) {
			case 1 : selectAll(); break;
			case 2 : addFootballPlayer(); break;
			case 3 : updateFootballPlayer(); break;
			case 4 : deleteFootballPlayer(); break;
			case 5 : outputFootballPlayer(); break;
			case 6 : findFootballPlayer(); break;
			case 7 : bv.boardMenu();break;
			case 0 : System.out.println("프로그램을 종료합니다."); sc.close(); return;
			default : System.out.println("없는 메뉴 입니다. 다시 입력해주세요."); continue;
			}
		}
	}

	// 선수들의 정보를 출력해주는 기능
	private void selectAll() {
		//  사용자에게 값 입력받기, 모델에서 만든 값 출력하기
		List<FootballPlayer> list = fc.selectAll();
		
		// list의 필드로 있는 배열의 인덱스에 있는 VO의 주소값을 참조해서 필드 값을 출력
//		String name = list.get(0).getName();
//		String position = list.get(0).getPosition();
//		Integer backNumber = list.get(0).getBackNumber();
//		
//		System.out.println("선수의 정보");
//		System.out.println("이름 : " + name);
//		System.out.println("포지션 : " + position);
//		System.out.println("등번호 : " + backNumber);
		
		if(!list.isEmpty()) {
			// 축구선수가 한 명 이상 있다
			for(FootballPlayer fp : list) {
				System.out.println("선수의 정보");
				System.out.println("--------------");
				System.out.println("아이디 : " + fp.getId());
				System.out.println("--------------");
				System.out.println("이름 : " + fp.getName());
				System.out.println("--------------");
				System.out.println("포지션 : " + fp.getPosition());
				System.out.println("--------------");
				System.out.println("등번호 : " + fp.getBackNumber());
				System.out.println("--------------");
				System.out.println("");
			}
		} else {
			// 축구선수가 한명도 없다
			System.out.println("=====================================");
			System.out.println("아직 선수가 존재하지 않습니다.");
			System.out.println("새로운 선수를 추가해보세요!");
			System.out.println("추가하는데 비용은 없습니다!!!");
			System.out.println("=====================================");
		}
	}
	
	private void addFootballPlayer() {
		System.out.println("축구선수 추가하기에 오신걸 환영합니다.");
		while(true) {
			System.out.println("축구선수에 대한 정보를 순서에 맞게 추가해주세요");
			System.out.print("1. 선수 이름을 등록해주세요 > ");
			String name = sc.nextLine();
			System.out.print("2. 포지션의 정보를 등록해주세요 > ");
			String position = sc.nextLine();
			System.out.println("3. 선수의 등번호를 입력해주세요 > ");
			int backNumber = 0;
			try {
				backNumber = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("등 번호는 숫자만 입력이 가능합니다.");
				return;
			}
			System.out.println("입력한 축구선수의 값이 맞으신가요? 맞으면 1번, 틀리면 2번, 다시 메뉴로 돌아기는 0번입니다.");
			System.out.println("선수 이름 : " + name + ", 포지션 : " + position + ", 등번호 : " + backNumber);
			System.out.println("맞으면 1번, 틀리면 2번, 다시 메뉴로 돌아가기는 0번입니다.");
			int menu = 0;
			try {
			menu = sc.nextInt();
			sc.nextLine();
			} catch(InputMismatchException e) {
				System.out.println("숫자만 입력해주세요");
				sc.nextLine();
				continue;
			}
			switch(menu) {
			case 1 : fc.addFootballPlayer(new FootballPlayerDto(name, position, backNumber));
					 FootballPlayer fp = fc.addFootballPlayer(new FootballPlayerDto(name, position, backNumber));
					 if(fp != null) {
						 System.out.println("축구 선수 정보가 정상적으로 등록되었습니다.");
						 System.out.println("선수 이름 : " + name + ", 포지션 : " + position + ", 등번호 : " + backNumber);
					 } else {
						 System.out.println("축구 선수 정보를 제대로 입력해주세요.");
						 System.out.println("1. 이름은 두글자 이상으로 입력해주세요.");
						 System.out.println("2. 포지션은 공격수/미드필더/수비수/골기퍼로만 입력해주세요.");
						 System.out.println("3. 등번호는 0 이상의 정수값을 입력해주세요.");
						 continue;
					 }
					 return;
			case 2 : continue;
			case 0 : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("없는 메뉴 입니다. 다시 입력해주세요."); continue;
			}
		}
	}
	
	private void updateFootballPlayer() {
		// 이름만 바꾸는 기능
		// 포지션만 바꾸는 기능
		// 등번호만 바꾸는 기능
		
		// 이름하고 포지션만 바꾸는 기능
		// 이름하고 등번호만 바꾸는 기능
		// 포지션하고 등번호만 바꾸는 기능
		
		// 이름하고 포지션하고 등번호를 바꾸는 기능 *
		
		// 선수를 어떻게 식별할 것인가?
		// 이름이 일치하면
		// 포지션이 일치하면
		// 등번호가 일치하면
		
		// 이름과 포지션이 일치하면
		// 이름과 등번호가 일치하면
		// 포지션과 등번호가 일치하면
		
		// 이름과 포지션과 등번호가 일치하면
		// ID값이 일치하면 *
		
		selectAll();
		// 1. 아이디를 받음 
		// 2. 이름, 포지션, 등번호
		System.out.println("어떤 선수의 정보를 갱신하시겠습니까?");
		System.out.print("선수의 아이디를 숫자로 입력하세요 > ");
		try {
		int id = Integer.parseInt(sc.nextLine());
		
		// 1. 입력받은 id값을 가지고 서비스까지 가서 id가 있는지 확인
		//    있으면 아래코드 수행 없으면 return 해버리기
		boolean result = fc.idCheck(id);
		
		if(!result) {
			System.out.println("존재하지 않는 아이디 입니다.");
			return;
		}
		
		
		// 2. 입력받은 id값이 있던지 없던지 그냥 다 받아버라기
		//    그리고 서비스가서 있는지 없는지 판별 후 작업 수행
		System.out.print("변경하실 이름을 입력해주세요 > ");
		String name =  sc.nextLine();
		System.out.print("변경하실 포지션을 입력해주세요 > ");
		String position = sc.nextLine();
		System.out.print("변경하실 등번호를 입력해주세요 > ");
		int backNumber = Integer.parseInt(sc.nextLine());
		
		fc.updateFootballPlayer(id, new FootballPlayerDto(name, position, backNumber));
		
		
		
		} catch(NumberFormatException e) {
			System.out.println("올바른 값을 입력해주세요.");
			System.out.println("메인 메뉴로 돌아갑니다.");
		}
		
	}
	
	private void deleteFootballPlayer() {
		System.out.println();
		System.out.println("등록된 축구선수를 해지하겠습니다.");
		selectAll();
		System.out.print("해지할 선수의 아이디를 입력해주세요 > ");
		int id = 0;
		
		try {
			id = sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("아이디 값은 숫자만 입력 가능합니다.");
			sc.nextLine();
			return;
		}
		
		String result = fc.deleteFootballPlayer(id);
		
		if(result != null) {
			System.out.println(result + " 선수의 정보가 삭제되었습니다!");
		} else {
			System.out.println("삭제할 선수의 id가 아닙니다.");
		}
	}
	
	public void outputFootballPlayer() {
		fc.outputFootballPlayer();
	}
	
	private void findFootballPlayer() {
		
		System.out.println("선수 검색 서비스입니다.");
		
		System.out.print("찾고 싶은 이름의 키워드를 입력해주세요 > ");
		String keyword = sc.nextLine();
		List <FootballPlayer> players = fc.findByKeyword(keyword);
		
		if(players.isEmpty()) {
			System.out.println("====================================");
			System.out.println("검색결과가 존재하지 않습니다.");
			System.out.println("====================================");
		} else {
			System.out.println();
			System.out.println(keyword + " 검색결과 입니다.");
			for(FootballPlayer player : players) {
				System.out.println("이름 : " + player.getName() +", 포지션 :"
						+ player.getPosition() + ", 등번호 : " + player.getBackNumber());
			}
			System.out.println();
		}
		
	}


}
