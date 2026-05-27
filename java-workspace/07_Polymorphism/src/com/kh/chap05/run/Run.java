package com.kh.chap05.run;

import com.kh.chap05.model.service.ExpensiveFilter;
import com.kh.chap05.model.service.SoupFilter;
import com.kh.chap05.model.service.TunaFilter;
import com.kh.chap05.model.vo.Soup;

public class Run {

	public static void main(String[] args) {
		
		Soup[] soups = {
				new Soup("김치찌개", "돼지고기", 5000),
				new Soup("순두부김치찌개", "순두부", 7000),
				new Soup("쭈꾸미김치찌개", "쭈꾸미", 12000),
				new Soup("참치김치찌개", "참치", 9000),
				new Soup("꽁치김치찌개", "꽁치", 10000),
				new Soup("총합김치찌개", "돼지, 순두부, 쭈꾸미, 참치, 꽁치", 15000)				
		};
		
		// 재료에 참치가 들어가는 김치찌개를 골라줘
		SoupFilter filter = new TunaFilter();
		
		for(int i = 0; i < soups.length; i++) {
			if(filter.test(soups[i])) {
				System.out.println(soups[i].getName());
			}
		}
		
		for(Soup s : soups) {
			if(filter.test(s)) {
				System.out.println(s.getName());
			}
		}
		
		// 10000원 보다 비싼 김치찌개만 골라주세요
		
		SoupFilter ef =new ExpensiveFilter();
		
		for(Soup s : soups) {
			if(ef.test(s)) {
				System.out.println("만원 넘는 찌개 : " + s.getName());
			}
			
		}
		
		// 요구사항이 늘어난다 
		// 김치찌개 이름이 네글자 이하인 김치찌개만 찾는거 만들어주세요~~
		// 9000원 이하인 김치찌개 찾는거 만들어주세요
		
		SoupFilter sheapFilter = new SoupFilter() {
			@Override
			public boolean test(Soup s) {
				return s.getPrice() <= 9000;
			}
		};
		
		for(Soup s : soups) {
			if(sheapFilter.test(s)) {
				System.out.println("9000원 이하인 찌개 : " + s.getName());
			}
		}
		
		SoupFilter shortNameSoupFilter = new SoupFilter() {
			@Override
			public boolean test(Soup s) {
				return s.getName().length() <= 4;
			}
		};

		for(Soup s : soups) {
			if(shortNameSoupFilter.test(s)) {
				System.out.println("이름이 짧은 찌개 : " + s.getName());
			}
		}
		// 1단계 : 익명클래스
//		SoupFilter filter1 = new SoupFilter() {
//			@Override
//			public boolean test(Soup s) {
//				return s.getMainMenu().contains("치");
//			}
//		};
		
		// 2단계 : 인터페이스명, 애노테이션, 접근제한자, 반환형, 메소드명 싹 날리고 (매개변수) -> {실행문}
//		SoupFilter filter2 = (Soup s) -> {
//			return s.getMainMenu().contains("치");
//		};
		
		// 3단계 : 매개변수 자료형 제거 : 타입추론 + 매개변수가 한 개라면 괄호도 생략
//		SoupFilter filter3 = s -> {
//			return s.getMainMenu().contains("치");
//		};
		
		// 4단계 : 중괄호 안 실행문이 한 줄 이라면 중괄호 + return문 생략
		SoupFilter filter4 = s -> s.getMainMenu().contains("치");
		
		for(Soup s : soups) {
			if(filter4.test(s)) {
				System.out.println("재료에 치가 들어간 찌개 : " + s.getName());
			}
		}
	}

}
