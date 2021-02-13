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
	
	public void init() throws ServletException { // �� �޼ҵ尡 ȣ��� ��, handlerMapping, ViewResolver ��ü ����
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
		// 1. Ŭ���̾�Ʈ�� ��û path������ �����Ѵ�.
		String uri = request.getRequestURI(); // Ŭ���̾�Ʈ�� ��û URI
		String path = uri.substring(uri.lastIndexOf("/")); // "/"�� ǥ���� index�� ���� ������ = /xxx.do
		
		// 2. HandlerMapping�� ���� path�� �ش��ϴ� Controller�� �˻�
		Controller ctrl = handlerMapping.getController(path); // Ŭ���̾�Ʈ�� ��û path�� �ش��ϴ� Controller�� �˻��ϱ� ���� HandlerMapping��ü�� getController�޼ҵ� ȣ��
		
		// 3. �˻��� Controller�� handleRequest()�޼ҵ� ȣ���Ͽ� ����
		// ��û�� �ش��ϴ� ���� ó��, �̵��� ȭ�� ���� ����
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver�� ���� viewName�� �ش��ϴ� ȭ���� �˻�
		// Controller�� ������ View�̸��� �̿��Ͽ� ����� View�� ã�� �ش�ȭ������ �̵�
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		
		// 5. �˻��� ȭ������ �̵�
		response.sendRedirect(view);
		
		
	}

}
