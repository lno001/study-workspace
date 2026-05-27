package com.kh.chap07.model.vo;

public class Ticket {
	// 티켓을 세개까지 추가할 수 있음
	// 이용자는 추가되어있는 티켓을 발급받을 수 있음
	// 이코노미 티켓
	// 가격, 좌석번호, 서비스, 기내식
	private String meal;
	private String service;
	private String seatNumber;
	private int price;
	
	public Ticket() {}
	
	public Ticket(String meal, String service, String seatNumber, int price) {
		this.meal = meal;
		this.service = service;
		this.seatNumber = seatNumber;
		this.price = price;
	}
	
	public String getMeal() {
		return meal;
	}
	public String getService() {
		return service;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public int getPrice() {
		return price;
	}
	
	public String info() {
		return "기내식: " + meal + ", 서비스 : " + service + ", 좌석 : " + seatNumber + ", 비용 : " + price;
	}
	
	
}
