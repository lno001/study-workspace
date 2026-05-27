package com.kh.web.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.web.board.model.dto.BoardDto;
import com.kh.web.board.model.service.BoardService;
import com.kh.web.common.model.dto.PageInfo;

@WebServlet("/boards.do")
public class BoardListcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListcontroller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// -페이징 처리-
		// 필요한 변수들
		int listCount; // 현재 게시판의 총 게시글 개수
		// => WEB_BOARD테이블에서 COUNT(*) (STATUS='n') 조회
		int currentPage; // 현재 사용자가 요청한 페이지
		// => request.getParameter("page")로 뽑아서 씀
		int pageLimit; // 페이지 하단에 버튼을 몇 개 보여줄 것인지 => 5개
		int boardLimit; // 한 페이지에 보여질 게시글의 최대 개수 => 3개
		
		int maxPage; // 가장 마지막페이지 (총 페이지의 개수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작 값
		int endPage; // 페이지 하단에 보여질 페이징바의 끝 값
		
		listCount = new BoardService().selectBoardCount();
//		System.out.println(listCount);
		currentPage = Integer.parseInt(request.getParameter("page"));
		pageLimit = 3;
		boardLimit = 3;
		maxPage =  // ((listCount + boardLimit -1) / boardLimit) ;
				      (int) Math.ceil((double) listCount / boardLimit);
		
		// startPage == n * pageLimit + 1
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		int offset = (currentPage - 1) * boardLimit;
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, startPage, endPage, maxPage, offset);
		
//		System.out.println(pi);
		
		List<BoardDto> boards = new BoardService().selectBoardList(pi);
//		System.out.println(boards);
		
		
		request.setAttribute("pi", pi);
		request.setAttribute("boards", boards);
		
		request.getRequestDispatcher("/WEB-INF/views/board/boards.jsp").forward(request, response);
		
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
