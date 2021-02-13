package com.springbook.biz.board;

import java.util.List;

// ���⿡ �ִ� �޼ҵ���� �ٽ� �޼ҵ�, �̰���  BoardServiceImpl���� �����ؾ� ��
public interface BoardService { // ���⿡ ���ǵ� �޼ҵ���� BoardServiceImpl�� ���� �����ؾ� ��, 

	// CRUD ����� �޼ҵ� ����
	// �� ���
	void insertBoard(BoardVO vo);

	// �� ����
	void updateBoard(BoardVO vo);

	// �� ����
	void deleteBoard(BoardVO vo);

	// �� �� ����
	BoardVO getBoard(BoardVO vo);

	// �� ��� ��ȸ
	List<BoardVO> getBoardList(BoardVO vo);

}