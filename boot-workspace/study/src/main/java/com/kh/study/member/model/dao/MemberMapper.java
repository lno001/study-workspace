package com.kh.study.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.study.member.model.dto.MemberDto;

@Mapper
public interface MemberMapper {

	@Select("SELECT USER_ID, USER_NAME, EMAIL, ENROLL_DATE FROM MEMBER WHERE STATUS = 'Y' ORDER BY ENROLL_DATE DESC")
	List<MemberDto> findAll();

	@Select("SELECT USER_ID, USER_NAME, EMAIL, ENROLL_DATE FROM MEMBER WHERE STATUS = 'Y' AND USER_ID = #{userId}")
	MemberDto findById(String userId);
}
