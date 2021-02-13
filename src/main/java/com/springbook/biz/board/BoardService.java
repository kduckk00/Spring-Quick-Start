package com.springbook.biz.board;

import java.util.List;

// 여기에 있는 메소드들이 핵심 메소드, 이것을  BoardServiceImpl에서 구현해야 함
public interface BoardService { // 여기에 정의된 메소드들을 BoardServiceImpl에 전부 구현해야 함, 

	// CRUD 기능의 메소드 구현
	// 글 등록
	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 상세 조희
	BoardVO getBoard(BoardVO vo);

	// 글 목록 조회
	List<BoardVO> getBoardList(BoardVO vo);

}