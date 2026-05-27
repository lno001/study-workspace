package com.lim.spring.chara.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lim.spring.chara.model.dao.CharaMapper;
import com.lim.spring.chara.model.dto.CharaDto;
import com.lim.spring.exception.InvalidPageException;
import com.lim.spring.util.PageInfo;
import com.lim.spring.util.Pagination;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CharaService {
	
	private final CharaMapper mapper;
	private final Pagination pagination;
	
	public Map<String, Object> findAll(String page) {
		
		int pageNo = checkPage(page);
		
		int totalCount = mapper.SelectTotalCount();
		
		int boardLimit = 10;
		
		PageInfo pi = pagination.getPageInfo(totalCount, pageNo, boardLimit, 10);
		
		List<CharaDto> charas = mapper.findAll(pageNo, boardLimit);
		
		return Map.of("charas", charas, "pi", pi);
	}

	
	
	
	
	
	
	private int checkPage(String page) {
		if(page == null || page.isBlank()) {
			throw new InvalidPageException("페이지의 값이 존재하지 않습니다.");
		}
		
		try {
			int pageNo = Integer.parseInt(page.trim());
			if(pageNo < 1) {
				throw new InvalidPageException("페이지의 값이 1보다 작습니다.");
			}
			return pageNo; 
		} catch (NumberFormatException e) {
			throw new InvalidPageException("페이지의 값이 정수가 아닙니다.");
		}
	}



}