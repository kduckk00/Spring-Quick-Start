package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	@RequestMapping(value="/login.do", method=RequestMethod.GET) // GET����� ��û�� ���� ��, loginViewȣ��
	public String loginView(UserVO vo) {
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ� �մϴ�.");
		}
		System.out.println("�α��� ���� ó��");
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName()); // �α��� ������ ����� �̸��� ���ǿ� ����
			return "getBoardList.do";
		}
		else return "login.jsp";
		
//		// 1. ����� �Է� ���� ���� -  ��û ����(request)
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		
//		// 2. DB ����ó�� - ���� id, pw�� vo�� ����
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
//		
//		// 3. ȭ�� �׺���̼� - ����(response)
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
//			return "login"; // viewResolver�� ����, handleRequest() �޼ҵ尡 Ȯ���� ���� ���ڿ��� �����ϸ� �ڵ����� .jspȮ���� �پ ó��
//		}
	}
	
}
