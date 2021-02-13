package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import com.springbook.view.controller.Controller;

public class LoginController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) { // Controller를 구현해야 함
		System.out.println("로그인 처리");
		
		// 1. 사용자 입력 정보 추출 -  요청 받음(request)
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동처리 - 받은 id, pw를 vo에 세팅
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. 화면 네비게이션 - 응답(response)
		if(user != null) {
			return "getBoardList.do";
		} else {
			return "login"; // viewResolver와 관련, handleRequest() 메소드가 확장자 없는 문자열을 리턴하면 자동으로 .jsp확장자 붙어서 처리
		}
	}
	
}
