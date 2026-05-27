package com.kh.chap01.abstraction.model.vo;
/*
 * pblic class 클래스식별자 {
 * 
 * [ 필드부 ]
 * 
 * 
 * [ 생성자부 ]
 * 
 * 
 * [ 메소드부 ]
 * 
 * 
 * }
 */
public class Puppy {
	
	// [ 필드부 ]
	
	// 이름, 종, 성별, 몸무게, 나이
	
	public String name;		// 강아지의 이름을 저장할 필드
	public String species;	// 강아지의 종을 저장할 필드
	public String gender;	// 강아지의 성별을 저장할 필드
	public int weight;		// 강아지의 몸무게를 저장할 필드
	public int age;			// 강아지의 나이를 저장할 필드
	
	// [ 생성자부 ]	==> Puppy가 수행할 수 있는 행위(기능)
	// 짖기, 앉기
	public void bark() {
		System.out.println(name + "이(가) 멍멍하고 짖습니다.");
	}
	
	public void sit() {
		System.out.println(name + "이(가) 앉습니다.");
		weight--;
	}
	

}
