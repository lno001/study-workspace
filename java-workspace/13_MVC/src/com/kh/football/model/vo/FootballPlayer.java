package com.kh.football.model.vo;

import java.util.Objects;

// 우리가 UPDATE를 구현해하는데 record로 구현하면
// 필드에 final키워드가 붙어 수정이 불가능하기 떄문에
public class FootballPlayer {
	private int id;// 식별값을 저장할 필드 => 자료형 => 실제 들어갈 값
	private String name;
	private String position;
	private Integer backNumber;
	
	
	public FootballPlayer(int id, String name, String position, Integer backNumber) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.backNumber = backNumber;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Integer getBackNumber() {
		return backNumber;
	}

	public void setBackNumber(Integer backNumber) {
		this.backNumber = backNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(backNumber, id, name, position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FootballPlayer other = (FootballPlayer) obj;
		return Objects.equals(backNumber, other.backNumber) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(position, other.position);
	}

	@Override
	public String toString() {
		return "FootballPlayer [id=" + id + ", name=" + name + ", position=" + position + ", backNumber=" + backNumber
				+ "]";
	}

	
	
	
}
