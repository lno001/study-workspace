package com.kh.chap03.model.vo;

public class MainChef extends Chef {

	public MainChef(String name) {
		super(name);
		}
	@Override
	public void cooking() {
		System.out.println(getName() + "(이)가 소고기 굽습니다~~");
	}
}
