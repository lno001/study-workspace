package com.kh.el.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.el.model.dto.Person;

@WebServlet("/el.do")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ElServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// requestScope
		request.setAttribute("classRoom", "501강의장");
		request.setAttribute("student", new Person("홍길동", 15, "한양"));
		
		// sessionScope
		HttpSession session = request.getSession();
		session.setAttribute("academy", "KH아카데미");
		session.setAttribute("lecture", new Person("고길동", 50, "마포"));
		
		
		// 동일한 key
		request.setAttribute("key", "request Scope");
		session.setAttribute("key", "session Scope");
		
		// 숫자
		request.setAttribute("small", 3);
		request.setAttribute("big", 10);
		
		// 문자열
		request.setAttribute("strOne", "안녕");
		request.setAttribute("strTwo", new String("안녕"));
		
		// 객체
		request.setAttribute("obj", new Person("콩쥐", 20, "콩쥐네"));
		
		// 리스트
		request.setAttribute("list", new ArrayList<Object>());
		
		// 응답 뷰 배정 -> 포워딩
		request.getRequestDispatcher("/WEB-INF/views/01_el.jsp").forward(request, response);
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
