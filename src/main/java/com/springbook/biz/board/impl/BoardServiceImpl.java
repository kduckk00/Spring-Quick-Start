package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
//	private BoardDAO boardDAO;
	
//	private Log4jAdvice log;
	
//	public BoardServiceImpl() { // BoardServiceImpl 기본 생성자, 이 생성자 호출할 때 LogAdvice 객체도 같이 생성되게끔
//		log = new Log4jAdvice();
//	}
	
	
	public void insertBoard(BoardVO vo) {
//		if(vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다."); // After-throwing어드바이스 발생 여부 확인 위함
//		}
//		log.printLogging();
		boardDAO.insertBoard(vo);
		boardDAO.insertBoard(vo);
	}
	
	public void updateBoard(BoardVO vo) {
//		log.printLogging();
		boardDAO.updateBoard(vo);
	}
	
	public void deleteBoard(BoardVO vo) {
//		log.printLogging();
		boardDAO.deleteBoard(vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
//		log.printLogging();
		return boardDAO.getBoard(vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
//		log.printLogging();
		return boardDAO.getBoardList(vo);
	}

}
