package com.kh.chap04.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap04.model.vo.Sandwich;

public class Run {

	public static void main(String[] args) {
		
		// Map 
		
		Map<String, Sandwich> subway = new HashMap<String, Sandwich>();
		
		subway.put("에그마요", new Sandwich("담백한맛", "에그마요"));
		subway.put("K-바베큐", new Sandwich("자극적임", "폴드포크"));
		subway.put("스테이크 & 치즈", new Sandwich("고기!", "스테이크"));
		subway.put("스파이시쉬림프", new Sandwich("매콤", "쉬림프"));
		System.out.println(subway);
		subway.put("매콤쉬림프", new Sandwich("매콤", "쉬림프"));
		System.out.println(subway);
		subway.put("매콤쉬림프", new Sandwich("매운맛", "쉬림프"));
		System.out.println(subway);
		
		System.out.println(subway.get("매콤쉬림프"));
		System.out.println(subway.get("에그마요"));
		System.out.println(subway.get("단종"));
		
		System.out.println(subway.size());
		System.out.println(subway.isEmpty());
		
		subway.replace("에그마요", new Sandwich("아주맛있는맛", "에그랑마요"));
		System.out.println(subway);
		
		subway.remove("K-바비큐");
		System.out.println(subway);
		
		System.out.println("=================================================");
		
		subway.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		
		Set<String> subSet = subway.keySet();
		Iterator<String> itKey = subSet.iterator();
		
		while(itKey.hasNext()) {
			String key = itKey.next();
			System.out.println(key + "===" + subway.get(key));
		}
		
		Set<Entry<String, Sandwich>> entrySet = subway.entrySet();
		System.out.println(entrySet);

	}

}
