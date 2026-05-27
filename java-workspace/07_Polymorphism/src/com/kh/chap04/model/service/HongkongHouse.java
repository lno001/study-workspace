package com.kh.chap04.model.service;

public class HongkongHouse implements CookingSkill, CookingSkillI {
	
	int NUM = 2;
	@Override
	public void makeDopbap() {
		System.out.println("홍콩식 치킨 덮밥만들기");
	}
	
}
