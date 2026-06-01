package com.kh.semi.member.model.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.semi.exception.DuplicateMemberIdException;
import com.kh.semi.exception.FailSignUpException;
import com.kh.semi.member.model.dao.MemberMapper;
import com.kh.semi.member.model.dto.MemberDto;
import com.kh.semi.member.model.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberMapper membermapper;
	private final PasswordEncoder passwordEncoder;

	@Transactional
	public void signUp(MemberDto member) {
		
		// 아이디 중복검사
		int count = membermapper.countByMemberId(member.getMemberId());
		
		if(count > 0) {
			throw new DuplicateMemberIdException("이미 존재하는 아이디입니다.");
		}
		
		// 비밀번호 암호화
		Member memberEntity = Member.builder().memberId(member.getMemberId())
											  .memberPwd(passwordEncoder.encode(member.getMemberPwd()))
											  .memberName(member.getMemberName())
											  .role("ROLE_USER")
											  .build();
		// log.info("만들어진 맴버 : {}", memberEntity);
		int result = membermapper.signUp(memberEntity);
		
		// 일반적으로 Mapper에서 성공실패 여부를 정수값으로 반환
		// result = 0;
		if(1 > result) {
			throw new FailSignUpException("잠시 후 다시 시도해주세요.");
		}
	}
	
	
	
}
