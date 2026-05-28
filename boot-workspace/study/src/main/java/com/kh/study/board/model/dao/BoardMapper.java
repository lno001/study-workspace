package com.kh.study.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.study.board.model.dto.BoardDto;

@Mapper
public interface BoardMapper {

	@Select("SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT, COUNT, CREATE_DATE FROM BOARD WHERE STATUS = 'Y' ORDER BY BOARD_NO DESC")
	List<BoardDto> findAll();

	@Select("SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT, COUNT, CREATE_DATE FROM BOARD WHERE STATUS = 'Y' AND BOARD_NO = #{boardNo}")
	BoardDto findByNo(String boardNo);
}
