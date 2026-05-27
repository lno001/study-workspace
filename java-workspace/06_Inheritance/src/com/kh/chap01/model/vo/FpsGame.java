package com.kh.chap01.model.vo;

public class FpsGame {
	private String gameName;
	private String publisher;
	private double stress;
	
	public FpsGame() {
		super();
	}
	
	public FpsGame(String gameName, String publisher, double stress) {
		super();
		this.gameName = gameName;
		this.publisher = publisher;
		this.stress = stress;
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
	public double getStress() {
		return stress;
	}
	public void setStress(double stress) {
		this.stress = stress;
	}
	
	public String info() {
		return "게임정보 [게임명 : " + gameName + ", 운영사 : " + publisher + ", 스트레스지수 : " + stress + "]";
	}
	

}
