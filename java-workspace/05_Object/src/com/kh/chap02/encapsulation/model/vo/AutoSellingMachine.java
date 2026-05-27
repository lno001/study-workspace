package com.kh.chap02.encapsulation.model.vo;


// 필드부, 생성자부, 메소드부
public class AutoSellingMachine { // 단 한개의 제품을 파는 자판기
	// 필드부
	private String name;
	private int price;
	private int amount;
	
	
	// 메소드부
	
//	private void checkAmount() {
//		System.out.println("현재 남은 재고는 " + amount + "개 입니다.");
//	}
//	
//	private void sellingProduct() {
//		amount -= 1;
//	}
//	
//	private void insertAmount() {
//		amount += 3;
//		
//		
//	}
	
//	public void openMachine() {
//		checkAmount();
//		insertAmount();
//		sellingProduct();
//		checkAmount();
//	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		if (price > 0) {
			this.price = price;
		} else {
			System.out.println("가격은 음수가 될 수 없습니다.");
		}
	}
	
	public void setAmount(int amount) {
		if (amount > 0) {
			this.amount = amount;
		} else {
			System.out.println("재고는 음수가 될 수 없습니다.");
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String info() {
		String info = "자판기 = [제품명 : " + name + ", 가격 : " + price + ", 재고 : " + amount + "]";
		return info;
	}
	
	public void check() {
		if (price > 0 && amount > 0) {
		System.out.println("현재 자판기에 들어있는 제품은 " + name + "입니다.");
		System.out.println("설정 되어있는 가격은 " + price + "원 입니다.");
		System.out.println("현재 재고는 " + amount + "개 남아있습니다.");
		}
	}
}
