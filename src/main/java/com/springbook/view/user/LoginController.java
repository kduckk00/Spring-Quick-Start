package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	@RequestMapping(value="/login.do", method=RequestMethod.GET) // GET방식의 요청이 들어올 때, loginView호출
	public String loginView(UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		System.out.println("로그인 인증 처리");
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName()); // 로그인 성공시 사용자 이름을 세션에 저장
			return "getBoardList.do";
		}
		else return "login.jsp";
		
//		// 1. 사용자 입력 정보 추출 -  요청 받음(request)
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		
//		// 2. DB 연동처리 - 받은 id, pw를 vo에 세팅
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
//		
//		// 3. 화면 네비게이션 - 응답(response)
//		ModelAndView mav = new ModelAndView();
//		if(user != null) {
//			mav.setViewName("redirect:getBoardList.do");
//		} else {
//			mav.setViewName("redirect:login.jsp");
//		}
//		return mav;
//		if(user != null) {
//			return "getBoardList.do";
//		} else {
//			return "login"; // viewResolver와 관련, handleRequest() 메소드가 확장자 없는 문자열을 리턴하면 자동으로 .jsp확장자 붙어서 처리
//		}
	}
	
}
