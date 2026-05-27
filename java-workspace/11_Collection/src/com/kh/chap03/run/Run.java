package com.kh.chap03.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.kh.chap03.model.vo.Shop;
import com.kh.chap03.model.vo.Shop2;

public class Run {

	public static void main(String[] args) {
		
		// 문자열만 담을 수 있는 HashSet
		Set<String> set = new HashSet<String>();
		
		set.add("가");
		set.add("나");
		set.add("다");
		set.add("라");
		set.add("마");	
		set.add("바");
		set.add("사");
		set.add(new String("사"));
		set.add("아");
		set.add("아");

		System.out.println(set);
		
		System.out.println(set.size());
		
		Set<Shop> shops = new HashSet<Shop>();
		
		Shop bosam = new Shop("잭아저씨족발보쌈","족발(중)",45000);
		Shop bager = new Shop("버거킹","갈릭불고기 세트",11800);
		Shop fish = new Shop("속초오징어어시장","대방어(소)",59000);
		
		shops.add(bosam);
		shops.add(bager);
		shops.add(fish);
		shops.add(new Shop("잭아저씨족발보쌈","족발(중)",45000));
		shops.add(new Shop("잭아저씨족발보쌈","튀김족발(대)",55000));
		shops.add(new Shop("잭아저씨족발보쌈","물냉면",9000));
		shops.add(new Shop("버거킹","갈릭불고기 세트",11800));
		shops.add(new Shop("버거킹","큐브스테이크 세트",11600));
		shops.add(new Shop("버거킹","와퍼주니어 세트",8700));
		shops.add(new Shop("속초오징어어시장","대방어(소)",59000));
		shops.add(new Shop("속초오징어어시장","광어회 1인",23000));
		
		System.out.println(shops);
		System.out.println("ABC".equals(new String("ABC")));
		
		bosam.equals(new Shop("잭아저씨족발보쌈","족발(중)",45000));
		
		Shop2 s2 = new Shop2("","",0);
		System.out.println(s2);
		System.out.println(s2.hashCode());
		
		System.out.println("=========================================================");
		
		/*
		for(int i = 0, i < shops.size(); i++) {
			System.out.println(shops.get); // get()가 존재하지 않음
		}
		*/

		for(Shop shop : shops) {
			System.out.println(shop);
		}
		
		System.out.println("=========================================================");
		
	//	List<E> list = new ArrayList();
	//	list.addAll(shops);
		
		List<Shop> list = new ArrayList<Shop>(shops);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("=========================================================");
		
		Iterator<Shop> it = shops.iterator();		
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
	}

}
