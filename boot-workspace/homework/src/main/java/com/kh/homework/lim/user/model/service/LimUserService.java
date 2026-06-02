package com.kh.homework.lim.user.model.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.homework.lim.user.model.dao.LimUserMapper;
import com.kh.homework.lim.user.model.dto.LimUserDto;
import com.kh.homework.lim.user.model.vo.LimUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LimUserService {

	private final LimUserMapper limUserMapper;
	private final PasswordEncoder passwordEncoder;
	
	@Transactional
	public void signUp(LimUserDto limUser) {
		
		
		
		LimUser limUserEntity = LimUser.builder().userId(limUser.getUserId())
												 .userPwd(passwordEncoder.encode(limUser.getUserPwd()))
												 .userName(limUser.getUserName())
												 .role("NOMAL")
												 .build();
		
		limUserMapper.signUp(limUserEntity);
	}
}
