package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	
	public static void main(String[] args) {
		// 1. Spring�����̳� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring�����̳ʷκ��� BoardServiceImpl ��ü�� Lookup
		BoardService boardService = (BoardService) container.getBean("boardService");
		
//		System.out.println("<aop:after> ��������");
		// 3. �� ��� ��� �׽�Ʈ
		BoardVO vo = new BoardVO();
		vo.setTitle("�׽�Ʈ ��--");
		vo.setWriter("������--");
		vo.setContent("AfterReturning,,");
		boardService.insertBoard(vo);
		
		// 4. �� ��� �˻� ��� �׽�Ʈ
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("===> " + board.toString());
		}
		// 5. Spring �����̳� ����
		container.close();
	}
}