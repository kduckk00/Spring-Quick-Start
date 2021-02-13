package com.springbook.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() throws ServletException { // 이 메소드가 호출될 때, handlerMapping, ViewResolver 객체 생성
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트의 요청 path정보를 추출한다.
		String uri = request.getRequestURI(); // 클라이언트의 요청 URI
		String path = uri.substring(uri.lastIndexOf("/")); // "/"로 표현된 index중 가장 마지막 = /xxx.do
		
		// 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색
		Controller ctrl = handlerMapping.getController(path); // 클라이언트의 요청 path에 해당하는 Controller를 검색하기 위해 HandlerMapping객체의 getController메소드 호출
		
		// 3. 검색된 Controller의 handleRequest()메소드 호출하여 실행
		// 요청에 해당하는 로직 처리, 이동할 화면 정보 리턴
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색
		// Controller가 리턴한 View이름을 이용하여 실행될 View를 찾아 해당화면으로 이동
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		
		// 5. 검색된 화면으로 이동
		response.sendRedirect(view);
		
		
	}

}
