package com.kh.member.model.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.keeper.common.JdbcTemplate.*;
import com.kh.member.exception.DuplicateMemberIdException;
import com.kh.member.exception.MemberIdToLargeException;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.BoardDto;
import com.kh.member.model.dto.LoginResponse;
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

	public LoginResponse login(MemberDto member) {
		
		Connection conn = getConnerction();
		
		LoginResponse lr = new MemberDao().login(conn, member);
		
		if(lr != null) {
			int result = new MemberDao().loginCheck(conn, member.getMemberId());
			
			if(result > 0) {
				commit(conn);
			}
		}
		close(conn);
		return lr;
	}

	public int selectInsertCount(String memberId) {
		
		Connection conn = getConnerction();
		
		int result = new MemberDao().selectInsertCount(conn, memberId);
		
		close(conn);
		
		return result;
	}

	public int insertBoard(BoardDto board) {
		
		Connection conn = getConnerction();
		
		int result = new MemberDao().insertBoard(conn, board);
		
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
	}

	public List<BoardDto> selectBoardList() {
		
		Connection conn = getConnerction();
		
		List<BoardDto> boards = new MemberDao().selectBoardList(conn);
		
		close(conn);
		
		return boards;
	}

	public BoardDto selectBoard(String boardNo) {
		
		Connection conn = getConnerction();
		
		BoardDto board = new MemberDao().selectBoard(conn, Integer.parseInt(boardNo));
		
		close(conn);
		return board;
	}

	
	
	
	
	
	
	
	
	
	
}
