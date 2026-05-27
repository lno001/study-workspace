package com.kh.first; // 패키지 선언부 이 클래스 파일의 위치를 알려주는 명령어 

// 보라색의 오묘한 색의 글자는 키워드로 기본으로 내장 되어 있는 예악어
/*을 치고 엔터를 누르면 여러줄 주석을 쓸 수있다
 * 
 * 주석은 프로그램을 실행하는데 있어서 아무런 영향을 끼치지 않음
 * 코드를 작성한 후 작성한 코드를 쉽게 이해하기 위함
 * 주석을 달아놓으면 유지보수 시간을 줄일 수있음
 * 
 * 주석의 종류는 3가지가 있음
 * 
 */

public class HelloWorld { //클래스명은 HelloWorld라고 지었음 { Scope / Block }
	
	public static void main(String[] args) {
		
		printMyName();
		
		System.out.print("Hello World~!");
	
		printMyName();
		
		apple();
	}
	
	public static void printMyName() { // 메소드 선언
		// 안녕하세요. 제 이름은 이일섭입니다. 반갑습니다~
		System.out.print("안녕하세요. 제 이름은 이일섭입니다. 반갑습니다~");
		
	}  // 메소드 영역 끝!
	
	public static void apple() {
		
		System.out.print("사과");
	}
}
