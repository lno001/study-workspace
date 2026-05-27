package com.kh.chap03.model.vo;

public class SaladChef extends Chef {

	public SaladChef(String name) {
		super(name);
	}
	@Override
	public void cooking() {
		System.out.println(getName() + "(이)가 샐러드 요리합니다~");
	}

}
