package com.kh.chap07.model.service;

import com.kh.chap07.model.vo.Ticket;

public class TicketService {
//	private int ticketCount;
//	private Ticket firstTicket;
//	private Ticket secondTicket;
//	private Ticket thirdTicket;
	private Ticket[] tickets = new Ticket[3];
	
//	public int getTicketCount() {
//		return ticketCount;
//	}
//	
//	public void saveTicket() {
//		ticketCount++;
//		System.out.println();
//	}
	
	public int saveTicket(Ticket ticket) {
		
		// 1. 티켓 개수 확인
		
		// 2. 티켓 개수가 2 이하라면 티켓 등록
//		if (ticketCount < 3) {
//			ticketCount++;
//			this.ticket = ticket;
//			return 1;
//		}
//		return 0;
		
	/*	if (firstTicket == null) {
		//	ticketCount++;
			this.firstTicket = ticket;
			return 1;
		} else if (secondTicket == null) {
		//	ticketCount++;
			this.secondTicket = ticket;
			return 1;
		} else if (thirdTicket == null) {
		//	ticketCount++;
			return 1;
		}
		return 0;
	*/	
		
	/*	if (tickets[0] == null) {
			this.tickets[0] = ticket;
			return 1;
		} 
		if (tickets[1] == null) {
			this.tickets[1] = ticket;
			return 1;
		} 
		if (tickets[2] == null) {
			this.tickets[2] = ticket;
			return 1;
		} 
		return 0;
	*/	
		for(int i = 0; i < tickets.length; i++) {
			if(tickets[i] == null) {
				tickets[i] = ticket;
				return 1;
			}
		}
		return 0;
		
		
		
	}
	
	public Ticket printTicket() {
		// 뷰로부터 시작된 요청이 컨트롤러를 거쳐서 도달함
		// 1. 티켓이 발금된게 있나 없나 확인 후 
		// 2. 발급된게 있으면 티켓의 주소값을 반환해주고
		// 3. 주서값을 담은 필드 비워주기
//		if (firstTicket != null) {
//			Ticket ticket = firstTicket;
//			firstTicket = null;
//			return ticket;
//		} else if (secondTicket != null) {
//			Ticket ticket = secondTicket;
//			return ticket;
//		} else if (thirdTicket != null) {
//			Ticket ticket = thirdTicket;
//			return ticket;
//		}
		
//		if(tickets[0] != null) {
//			Ticket ticket = tickets[0];
//			tickets[0] = null;
//			return ticket;
//		}
//		if(tickets[1] != null) {
//			Ticket ticket = tickets[0];
//			tickets[1] = null;
//			return ticket;
//		}
//		if(tickets[2] != null) {
//			Ticket ticket = tickets[0];
//			tickets[2] = null;
//			return ticket;
//		}
		
		for(int i = 0; i < tickets.length; i++) {
			if(tickets[i] != null) {
				Ticket ticket = tickets[i];
				tickets[i] = null;
				return ticket;
			}
		}
		return null;
	}
	
	public Ticket[] findAll() {
		return tickets;
	}
}
