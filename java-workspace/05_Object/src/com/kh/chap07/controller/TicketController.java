package com.kh.chap07.controller;

import com.kh.chap07.model.service.TicketService;
import com.kh.chap07.model.vo.Ticket;

public class TicketController {
	TicketService ts = new TicketService();
	public int saveTicket(Ticket ticket) {
		
	//	System.out.println("Controller : " + ticket);
		return ts.saveTicket(ticket);
	}
	
	public Ticket printTicket() {
		Ticket ticket = ts.printTicket();
		return ticket;
	}
	
	public Ticket[] findAll() {
		Ticket[] tickets = ts.findAll();
		return tickets;
	}

}
