package com.kh.homework.lim.user.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.kh.homework.lim.user.model.vo.LimUser;

@Mapper
public interface LimUserMapper {

	@Insert("INSERT INTO LIM_USER (USER_ID, USER_PWD, USER_NAME, ROLE) VALUES(#{userId}, #{userPwd}, #{userName}, #{role})")
	int signUp(LimUser limUser);
	
}
