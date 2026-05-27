package com.kh.chap02.encapsulation.run;

import com.kh.chap02.encapsulation.model.vo.AutoSellingMachine;

public class Run {

	// 캡슐화
	
	public static void main(String[] args) {
		
	//	new AutoSellingMachine();
		AutoSellingMachine asm = new AutoSellingMachine();
		
	//	asm.name = "신라면";
	//	System.out.println(asm.name);
	//	asm.price = 1200;
	//	System.out.println(asm.price + "원");
	//	asm.amount = 5;
	//	System.out.println(asm.quantity + "개");
		
//		asm.checkAmount();
//		asm.insertAmount();
//		asm.sellingProduct();
//		asm.checkAmount();

	//	asm.openMachine();
		
		// 라면 가격 1500으로 세팅하고 싶다.
		
		asm.setName("신라면");
		asm.setPrice(1500);
		asm.setAmount(10);
		
//		String name = asm.getName();
//		int price = asm.getPrice();
//		int amount = asm.getAmount();
//		
//		if (price > 0 && amount > 0) {
//		System.out.println("현재 자판기에 들어있는 제품은 " + name + "입니다.");
//		System.out.println("설정 되어있는 가격은 " + price + "원 입니다.");
//		System.out.println("현재 재고는 " + amount + "개 남아있습니다.");
//		}
		
		System.out.println(asm.info());
		
		asm.check();
		
		
		
		
		
	}

}
