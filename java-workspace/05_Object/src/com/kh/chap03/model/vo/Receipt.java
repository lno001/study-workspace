package com.kh.chap03.model.vo;

public class Receipt {
	// 가격, 결제방법, 상점명, 날짜
	
	private int price;
	private String payment;
	private String storeName;
	private String date;
	
	// 생성자부
	
	// 메소드부
	// getter() / setter() / info() 
	
	public int getPrice() {
		return price;
	}
	public String getPayment() {
		return payment;
	}
	public String getStoreName() {
		return storeName;
	}
	public String getDate() {
		return date;
	}
	
	
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String info() {
		String info = "[상점명 : " + storeName + ", 청구 가격 : " + price + "원, 결제 방법 : " + payment + ", 결제 날짜 : " + date + "]";
		return info;
	}
	
	
	
	
	
	
}
