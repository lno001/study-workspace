package com.kh.semi.member.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.semi.auth.model.vo.CustomUserDetails;
import com.kh.semi.member.model.dto.MemberDto;
import com.kh.semi.member.model.dto.UpdatePasswordDto;
import com.kh.semi.member.model.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	@PostMapping
	public ResponseEntity<Void> signUp(@RequestBody @Valid MemberDto member){
		// log.info("body 이쁘게 잘 넘어오나? > {}", member);
		memberService.signUp(member);
		return ResponseEntity.status(201).build();
	}
	
	// 비밀번호 변경 기능
	@PatchMapping						 // SpringSecurity => @AuthenticationPrincipalArgumentsResolver
	public ResponseEntity<Void> changePassword(@AuthenticationPrincipal CustomUserDetails user,
											@RequestBody @Valid UpdatePasswordDto upd) {
		// 아이디, 변경전 비밀번호, 변경후 비밀번호
		// 비밀번호 값에 대한 유효성 검증
		// 지금 요청을 보낸 사용자가 입력한 기존의 비밀번호가 DB에 저장된거랑 매칭이 잘 되는지 확인
		// 새로 입력한 비밀번호에 대한 암호화 작엄
		// DB에 가서 UPDATE
		log.info("요청이 잘 넘어오는가? 그런데 너는 누구인가 : {} / {}", user, upd);
		
		memberService.changePassword(user, upd);
		
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteByPassword(@RequestBody Map<String, String> password,
												 @AuthenticationPrincipal CustomUserDetails user){
		memberService.deleteByPassword(password.get("password"), user);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
