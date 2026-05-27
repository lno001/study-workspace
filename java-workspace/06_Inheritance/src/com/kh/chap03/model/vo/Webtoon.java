package com.kh.chap03.model.vo;

public class Webtoon {
	private String title;
	private String author;
	private String day;

	public Webtoon() {
		super();
	}
	
	public Webtoon(String title, String author, String day) {
		super();
		this.title = title;
		this.author = author;
		this.day = day;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	public String info() {
		return "웹툰 정보 \n[ 제목 : " + title + ", 작가 : " + author + ", 요일 : " + day;
	}
	
}
