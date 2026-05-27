package com.kh.member.controller;

import com.kh.member.model.dto.MemberDto;
import com.kh.member.model.service.MemberService;

public class MemberController {

	public boolean checkId(String memberId) {
		return new MemberService().checkId(memberId);
	}

	public int signUp(MemberDto member) {
		return new MemberService().signUp(member);
	}

}
