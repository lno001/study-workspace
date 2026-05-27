package com.kh.football.functional.model.dto;

public class Material {
	private String name;
	private int price;
	private String color;
	
	
	public Material() {
		super();
	}

	public Material(String name, int price, String color) {
		super();
		this.name = name;
		this.price = price;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Material [name=" + name + ", price=" + price + ", color=" + color + "]";
	}
	
	
	

}
