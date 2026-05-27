package com.kh.chap03.model.vo;

import java.util.Objects;

public class Shop {
	private String name;
	private String menu;
	private int price ;
	public Shop(String name, String menu, int price) {
		super();
		this.name = name;
		this.menu = menu;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Shop [name=" + name + ", menu=" + menu + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(menu, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		return Objects.equals(menu, other.menu) && Objects.equals(name, other.name) && price == other.price;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//	//	System.out.println(this);
//	//	System.out.println(obj);
//		Shop shop = (Shop)obj;
//		if(this.price == shop.price && this.name.equals(shop.name) && this.menu.equals(shop.menu)) {
//			return true;
//		}
//		return false;
//	}
//	
//	@Override
//	public int hashCode() {
//		return (name + menu + price).hashCode();
//	}
	
	
 }
