package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.board.DeleteBoardController;
import com.springbook.view.board.GetBoardController;
import com.springbook.view.board.GetBoardListController;
import com.springbook.view.board.InsertBoardController;
import com.springbook.view.board.UpdateBoardController;
import com.springbook.view.user.LoginController;
import com.springbook.view.user.LogoutController;

public class HandlerMapping { // 모든 Controller 객체들 저장했다가 요청이 들어오면 Controller검색 해서 리턴 
	private Map<String, Controller> mappings; // Map타입의 컬렉션을 멤버변수로 가짐
	
	public HandlerMapping() { // Controller등록하는 메소드
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController()); // LoginController클래스 등록
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	public Controller getController(String path) { // path에 해당하는 Controller객체를 HashMap컬렉션으로부터 검색하여 리턴
		return mappings.get(path);
	}
}
