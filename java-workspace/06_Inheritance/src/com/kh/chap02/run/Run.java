package com.kh.chap02.run;

import com.kh.chap02.model.vo.AosGame;
import com.kh.chap02.model.vo.FpsGame;
import com.kh.chap02.model.vo.RpgGame;

public class Run {
	
	public static void main(String[] args) {
		
		FpsGame fg = new FpsGame("배틀그라운드", "크래프톤", 50);
		
		RpgGame rg = new RpgGame("와우", "블리자드", 80);
		
		AosGame ag = new AosGame("롤", "라이엇", 172);
		
		System.out.println(fg.info());
		System.out.println(rg.info());
		System.out.println(ag.info());
		
		
		
		
		
	}

}
