package com.kh.chap02.model.vo;

public class Game {
	
	private String gameName;
	private String publisher;
	
	public Game() {
		super();
		System.out.println("나는 부모 클래스다.");
	}
	
	public Game(String gameName, String publisher) {
		super();
		this.gameName = gameName;
		this.publisher = publisher;
	}
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String info() {
		return "게임명 : " + gameName + ", 운영사 : " + publisher ;
	}
}
