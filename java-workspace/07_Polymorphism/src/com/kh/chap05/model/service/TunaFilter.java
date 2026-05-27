package com.kh.chap05.model.service;

import com.kh.chap05.model.vo.Soup;

public class TunaFilter implements SoupFilter {

	@Override
	public boolean test(Soup s) {
		return s.getMainMenu().contains("참치");
	}

}
