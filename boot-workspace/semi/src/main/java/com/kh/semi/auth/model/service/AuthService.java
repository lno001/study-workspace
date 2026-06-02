package com.kh.semi.auth.model.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.kh.semi.auth.model.dto.LoginRequestDto;
import com.kh.semi.auth.model.vo.CustomUserDetails;
import com.kh.semi.exception.CustomAuthenticationException;
import com.kh.semi.token.model.service.TokenService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final AuthenticationManager authenticationManager;
	private final TokenService tokenService;

	public void login(LoginRequestDto lrd) {
		
		Authentication auth = null;
		try	{
			auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(lrd.getMemberId(), lrd.getMemberPwd()));
		} catch(AuthenticationException e){
			throw new CustomAuthenticationException("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		CustomUserDetails user = (CustomUserDetails)auth.getPrincipal();
		// log.info("로그인한 사용자의 정보 : {}", user);
		
		// Jwts.builder().subject(user.getUsername()).issuedAt(new Date()).expiration(new Date()).compact();
		
		tokenService.getTokens(user);
		
		
	}

}
