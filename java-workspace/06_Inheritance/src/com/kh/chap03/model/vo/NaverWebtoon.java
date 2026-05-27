package com.kh.chap03.model.vo;

public class NaverWebtoon extends Webtoon{
	
	private String payment;

	public NaverWebtoon() {
		super();
	}

	public NaverWebtoon(String title, String author, String day, String payment) {
		super(title, author, day);
		this.payment = payment;
		}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String info() {
		return "네이버 " + super.info() + ", 결제방식 : " + payment +" ]";
	}
	
	

}
