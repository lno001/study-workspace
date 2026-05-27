package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.keeper.common.JdbcTemplate.*;
import com.kh.member.exception.DuplicateMemberIdException;
import com.kh.member.exception.MemberIdToLargeException;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.MemberDto;

public class MemberService {

	public boolean checkId(String memberId) {
		Connection conn = getConnerction();
		
		boolean result = new MemberDao().checkId(conn, memberId);
		close(conn);
		return result;
	}

	public int signUp(MemberDto member) {
		if(member.getMemberId().length() > 30) {
			throw new MemberIdToLargeException("아이디가 너무 길어요");
		}
		if(member.getMemberPwd().length() > 30) {
			throw new MemberIdToLargeException("비밀번호가 너무 길어요");
		}
		if(member.getMemberName().length() > 30) {
			throw new MemberIdToLargeException("이름이 너무 길어요");
		}
		Connection conn = getConnerction();
		
		MemberDao md = new MemberDao();
		if(md.checkId(conn, member.getMemberId())) {
			throw new DuplicateMemberIdException("중복된 아이디입니다.");
		}
		int result = new MemberDao().signUp(conn, member);
		if(result > 0) {
			commit(conn);
		}
		close(conn);

		
		
		return result;
	}

}
