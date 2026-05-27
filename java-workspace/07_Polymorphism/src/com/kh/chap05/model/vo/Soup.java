package com.kh.chap05.model.vo;

public class Soup {
	private String name;
	private String mainMenu;
	private int price;
	
	public Soup(String name, String mainMenu, int price) {
		this.name = name;
		this.mainMenu = mainMenu;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(String mainMenu) {
		this.mainMenu = mainMenu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Soup [name=" + name + ", mainMenu=" + mainMenu + ", price=" + price + "]";
	}
	
	
	

}
