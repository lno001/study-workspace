package com.kh.chap02.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kh.chap02.model.vo.Plant;

public class Run {

	public static void main(String[] args) {
		
		ArrayList<Object> plants = new ArrayList<>(3);
		Plant[] plantss = new Plant[3];
		
	//	System.out.println(plantss);
	//	System.out.println(plants);
		
		plantss[0] = new Plant("서양란", "호접란");
		plantss[1] = new Plant("동양란", "황룡관");
		plantss[2] = new Plant("관엽", "금전수");
	//	plantss[3] = new Plant("꽃", "개나리");
		System.out.println(Arrays.toString(plantss));
		
		
	//	plants.add(1);
		plants.add(new Plant("서양란", "호접란"));
		plants.add(new Plant("동양란", "황룡관"));
		plants.add(new Plant("관엽", "금전수"));
		plants.add(new Plant("꽃", "벛꽃"));
		plants.add("식물 끝!");		
		System.out.println(plants);
		
	//	LinkedList list;
		plants.add(0, "식물시작");
		plants.add(3, new Plant("관엽", "홍콩야자"));
		System.out.println(plants);
		
		plants.set(0, "시이이이자악!");
		System.out.println(plants);
		
		plants.remove(0);
		String end = (String) plants.remove(5);
		System.out.println(plants);
		System.out.println(end);
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		System.out.println(plants.size());
		
		System.out.println(plants.toString());
		Plant p = (Plant)plants.get(0);
		System.out.println(p);
		
		// 2번 인덱스에 위치한 식물의 타입 값을 스트링형 변수에 대입해서 활용하고 싶다
		String hongkongTree = ((Plant)plants.get(2)).getType();
		System.out.println(hongkongTree);
		
		for(int i = 0; i < plants.size(); i++) {
			System.out.println("식물 종류 : " + ((Plant)(plants.get(i))).getName());
		}
		
		for(Object plant : plants) {
			System.out.println(plant.toString());
		}
		
		List<Object> sub = plants.subList(0, 2);
		System.out.println(sub);
		
		plants.addAll(sub);
		System.out.println(plants);
		
		System.out.println(plants.isEmpty());
		
		plants.clear();
		
		System.out.println(plants);
		System.out.println(plants.isEmpty());
	}

}
