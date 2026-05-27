package com.kh.chap02.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap02.model.IntegerBox;
import com.kh.chap02.model.StringBox;
import com.kh.chap02.model.vo.Box;
import com.kh.chap02.model.vo.Plant;

public class GenericRun {

	public static void main(String[] args) {
		
//		List<String> list = new ArrayList<String>();
//		list.add("하하");
//		list.add("123");
//		list.add("true");
//		
//		
//		String text = list.get(0);
//		String text1 = list.get(1);
//		String text2 = list.get(2);
//		
//		System.out.println(text + text1 + text2);
		
		StringBox sb = new StringBox();
		sb.set("하하");
		System.out.println(sb.get());
		
		IntegerBox ib = new IntegerBox();
		ib.set(123);
		System.out.println(ib.get());
		
		Box<String> bs = new Box<String>();
		bs.set("하하");
		System.out.println(bs.get());
		Box<Integer> bi = new Box<Integer>();
		bi.set(1234);
		System.out.println(bi.get());
		Box<Plant> bp = new Box<Plant>();
		bp.set(new Plant("금전수", "동양화"));
		System.out.println(bp.get());
		
		List<Plant> plants = new ArrayList<Plant>();
		plants.add(new Plant("관엽", "폴리샤스"));
		plants.add(new Plant("관엽", "산세베리아"));
		plants.add(new Plant("과일", "딸기"));
		
		Plant p = plants.get(0);
		System.out.println(p);
		
		for(Plant plant : plants) {
			System.out.println(plant);
		}
		
		
		
		
	}

}
