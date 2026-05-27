package com.kh.chap07.view;

import java.util.Scanner;

import com.kh.chap07.controller.TicketController;
import com.kh.chap07.model.vo.Ticket;

public class TicketView {
	private Scanner sc = new Scanner(System.in);
	private TicketController tc = new TicketController();
	
	// 화면에 메인메뉴를 출력해주는 메소드
	public void mainMenu() {
		// 두 가지 기능 구현
		// 1. 티켓 추가하기
		// 2. 추가된 티켓 발급해주기
		while(true) {
			System.out.println("티켓 발권 서비스입니다~");
			System.out.println("0. 티켓 전체조회하기");
			System.out.println("1. 티켓 추가하기");
			System.out.println("2. 티켓 발급받기");
			System.out.println("3. 프로그램 종료");
			System.out.print("원하시는 메뉴를 선택해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();
			// System.out.println(menuNo);
			
			switch(menuNo) {
			case 0 : finalAll(); break;
			case 1 : saveView(); break;
			case 2 : printTicket(); break;
			case 3 : System.out.println("프로그램을 종료합니다."); sc.close(); return;
			default : System.out.println("없는 메뉴를 선택하셨습니다.");
			}
			
			
		}
	}
	
	// 티켓을 추가할 수 있는 화면을 출력해주는 기능
	
	private void saveView() {
		
		System.out.print("티켓 가격을 입력해주세요 > ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("기내식을 입력해주세요 > ");
		String meal = sc.nextLine();
		System.out.print("좌석번호를 입력해주세요 > ");
		String seatNumber = sc.nextLine();
		System.out.print("서비스를 입력해주세요 > ");
		String service = sc.nextLine();
		
		Ticket ticket = new Ticket(meal,service,seatNumber,price);
	//	System.out.println(ticket.info());
		// 등록된 티켓이 3장이 아니라면 어딘가에 저장해둬야지~
		// System.out.println("View : " + ticket);
		int result = tc.saveTicket(ticket);
		
		// 성공 실패 여부 출력
		if(result == 1) {
		System.out.println("성공");
		} else {
		System.out.println("실패");
		}		
	}
	
	private void printTicket() {
		
		// 컨트롤러야 서비스에게 티켓 정보 하나만 받아다 주지 않을래?
		Ticket ticket = tc.printTicket();
		if(ticket != null) {
		System.out.println(ticket.info());
		} else {
		System.out.println("티켓이 하나도 존재하지 않습니다.");
		}
	}
	
	private void finalAll() {
		
		Ticket[] tickets = tc.findAll();
		
//		if(tickets[0] != null) {
//			System.out.println(tickets[0].info());
//		}
//		if(tickets[1] != null) {
//			System.out.println(tickets[1].info());
//		}
//		if(tickets[2] != null) {
//			System.out.println(tickets[2].info());
//		}
		
		for(int i = 0; i < tickets.length; i++) {
			if(tickets[i] != null) {
				System.out.println(tickets[i].info());
			}
		}
		
	//	System.out.println(tickets[0].info());
	}

}
