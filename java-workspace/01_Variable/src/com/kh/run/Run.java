package com.kh.run;

import com.kh.variable.Casting;
import com.kh.variable.Variable;

public class Run {
	//깃허브 업데이트 테스트용 주석
	
	public static void main(String[] args) {
		// 클래스 외부에 있는 메소드를 호출하려면?
		// 클래스이름 별명 = new 클래스이름();
		Variable v = new Variable();
		//햄버거 주문 호출메뉴
		v.findLunchMenu();
		//v.declareVariable();
		//InputKeyBoard ik = new InputKeyBoard();
		//ik.inputTest();
		Casting ca = new Casting();
		ca.autoCasting();
		
		
	}

}
