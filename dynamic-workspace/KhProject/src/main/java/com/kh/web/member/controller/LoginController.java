package com.kh.web.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.web.member.model.dto.MemberDto;
import com.kh.web.member.model.service.MemberService;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		MemberDto member = new MemberDto();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		MemberDto loginMember = new MemberService().login(member);
		HttpSession session = request.getSession();
	
		if(loginMember != null) {
			
//			request.setAttribute("userInfo", loginMember);
//			response.sendRedirect("/kh");
			session.setAttribute("alertMsg", "로그인에 성공했습니다.");
			session.setAttribute("userInfo", loginMember);
			response.sendRedirect("/kh");
		} else {
			session.setAttribute("message",	"로그인에 실패했습니다.");
			// request.getRequestDispatcher("/WEB-INF/views/common/fail_page.jsp").forward(request, response);
			response.sendRedirect("/kh/fail.do");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
