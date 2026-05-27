package com.kh.chap03.model.vo;

public class NateWebtoon {
	
	private String title;
	private String author;
	private String day;
	
	public NateWebtoon() {
		super();
	}

	public NateWebtoon(String title, String author, String day) {
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

	@Override
	public String toString() {
		return "네이트 웹툰 정보 \n[ 제목 : " + title + ", 작가 : " + author + ", 요일 : " + day + " ]";
	}
	
	

}
