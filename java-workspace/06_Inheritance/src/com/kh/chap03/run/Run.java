package com.kh.chap03.run;

import com.kh.chap03.model.vo.KakaoWebtoon;
import com.kh.chap03.model.vo.NateWebtoon;
import com.kh.chap03.model.vo.NaverWebtoon;
import com.kh.chap03.model.vo.Webtoon;

public class Run {
	
	public static void main(String[] args) {
		
		Webtoon w = new Webtoon("화산귀환", "LICO", "수요일");
		NaverWebtoon nw = new NaverWebtoon("전지적독자시점","UMI","수요일","현금");
		KakaoWebtoon kw = new KakaoWebtoon("수린당 성군전","일랑스","수요일",true);
		
		System.out.println(w.info());
		System.out.println(nw.info());
		System.out.println(kw.info());
		
	//	System.out.println(w);
	//	System.out.println(w.toString());
		
		NateWebtoon nwt = new NateWebtoon("재미있는 웹툰", "작가" ,"수요일");
		System.out.println(nwt);
		
		
	}

}
