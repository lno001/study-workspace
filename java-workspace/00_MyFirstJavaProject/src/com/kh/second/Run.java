package com.kh.second;

public class Run {

	
	public static void main(String[] args) {
		
		//	printMyName();
		// 외부 클래스에 존재하는 메소드를 호출하고싶다.
		
		/*	외부 클래스의 메소드를 호출할 떄는 메소드가 존재하는 클래스를 생성(new) 해줘야한다
		 * 	[표현법]
		 * 	"클래스이름" "클래스이름을 대신한 별칭" = new "클래스이름()"; 
		 */
		
		PrintController pc = new PrintController();
		
		pc.printMyName();

		
	}

}
