package com.kh.football.functional.model.service;

import com.kh.football.functional.model.dto.Material;

@FunctionalInterface
public interface BinFilter {
	boolean test(Material m);
}
