package com.lim.spring.chara.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lim.spring.chara.model.dto.CharaDto;

@Mapper
public interface CharaMapper {

	int SelectTotalCount();

	List<CharaDto> findAll(@Param(value = "pageNo") int pageNo, @Param(value = "boardLimit") int boardLimit);

}
