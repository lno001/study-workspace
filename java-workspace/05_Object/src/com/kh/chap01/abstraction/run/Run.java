package com.kh.chap01.abstraction.run;

import com.kh.chap01.abstraction.model.vo.Puppy;
import com.kh.chap01.abstraction.view.PuppyCare;

public class Run {
	
	public static void main(String[] args) {
		
	//	Human 이현준 = new Human();
	//	이현준.친구와놀러가기();
		
		// 현실세계의 강아지 => 자바세상의 객체로 구현
		// 종 : 푸들, 이름 : 나폴레옹, 나이 : 5, 몸무게 : 8, 성별 : 암컷
		// 강아지 객체 생성해보기
		
		
		Puppy puppy = new Puppy();
		// new 라는 예약어를 사용
		
		// System.out.println(puppy);
		// 참조자료형은 기본값이 null
		// System.out.println(puppy.name);
		
		puppy.name = "나폴레옹";
		System.out.println(puppy.name);
		
		// 종 : 방하르, 이름 : 징기스칸, 나이 : 5, 몸무게 : 50, 성별 : 수
		Puppy khan = new Puppy();
		khan.name = "징기스칸";
		khan.species = "방하르";
		khan.age = 5;
		khan.weight = 50;
		khan.gender = "수컷";
		
		System.out.println(khan.name);
		
		// 정수값 => 정수자료형 int, short, byre, long
		// 실수값 => 실수자료형 float, double
		// 논리값 => ...
		
		// 현실 세계의 강아지의 값 => 개발자가 직접 강아지의 자료형을 만듬(class 생성)
		
		//System.out.print(puppy.name + "이 ");
		puppy.bark();
		khan.bark();
		
		puppy.weight = 8;
		puppy.age = 5;
		puppy.gender = "암컷";
		puppy.species = "푸들";
		System.out.println(khan.weight + "kg" );
		
		khan.sit();
		khan.sit();
		khan.sit();
		
		System.out.println(puppy.weight + "kg" );
	
		PuppyCare pc = new PuppyCare();
		pc.run();
	
	
	
	
	
	}
	
}
