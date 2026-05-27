package com.kh.chap02.model.vo;

public class Plant {
	private String Name;
	private String Type;
	
	public Plant(String type, String name) {
		super();
		Name = name;
		Type = type;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	@Override
	public String toString() {
		return "Plant [Name=" + Name + ", Type=" + Type + "]";
	}
	
	

}
