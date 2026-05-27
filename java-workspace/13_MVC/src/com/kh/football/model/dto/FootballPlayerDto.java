package com.kh.football.model.dto;

public class FootballPlayerDto {
	private String name;
	private String position;
	private int backNumber;
	
	public FootballPlayerDto() {
		super();
	}

	public FootballPlayerDto(String name, String position, int backNumber) {
		super();
		this.name = name;
		this.position = position;
		this.backNumber = backNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getBackNumber() {
		return backNumber;
	}

	public void setBackNumber(int backNumber) {
		this.backNumber = backNumber;
	}
	
	
	
}
