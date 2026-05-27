package com.kh.football.run;

import com.kh.football.view.FootballView;

public class Run {

	public static void main(String[] args) {
		
		// 축구선수 CRUD 구현
		// Create(생성) : View에서 만들어진 데이터를 축구선수모양으로 만들고 저장
		// Read(조회) : 저장된 축구선수 테이터들을 조회해서 출력
		// Update(수정) : 저장되어 있는 축구선수 데이터들의 값을 갱신
		// Delete(삭제) : 저장되어 있는 축구선수 데이터를 삭제
		
		// 공지사항(C : 게시글작성, R : 게시판, U : 게시글수정, D : 게시글삭제)
		// 회원(C : 회원가입, R : 마이페이지(내정보조회), U : 내정보수정, D : 회원탈퇴)
		
		new FootballView().mainMenu();
		
	}

}
