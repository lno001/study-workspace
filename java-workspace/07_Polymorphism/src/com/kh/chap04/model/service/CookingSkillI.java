package com.kh.chap04.model.service;

public interface CookingSkillI {
	
	int NUM = 1;
	
	void makeDopbap();
	
	default void close() {
		System.out.println("가게 문 닫습니다~");
	}

}
