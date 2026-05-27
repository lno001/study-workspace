package com.kh.football.functional.model.service;

import com.kh.football.functional.model.dto.Material;

public class RedFilter implements BinFilter {

	@Override
	public boolean test(Material m) {
		return m.getColor().equals("빨간색");
	}

}
