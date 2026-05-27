package com.kh.chap02.model.vo;

public class FpsGame extends Game {
	
	private double stress;

	public FpsGame() {
		super();
	}

	public FpsGame(String gameName, String publisher, double stress) {
	//	this.getGameName() = gameName;
	//	super.getGameName = gameName;
	//	setGameName(gameName);
	//	setPublisher(publisher);
 		super(gameName, publisher);
		this.stress = stress;
	}

	public double getStress() {
		return stress;
	}

	public void setStress(double stress) {
		this.stress = stress;
	}
	
	public String info() {
		return super.info() + ", 불쾌지수 : " + stress;
	}

}
