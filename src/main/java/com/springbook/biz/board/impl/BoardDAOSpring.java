package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOSpring  {
	// DataSource ���� - JdbcTemplateŬ���� <bean>���, ������ ����
//	@Autowired
//	public void setSuperDataSource(DataSource dataSource) {
//		super.setDataSource(dataSource);
//	}
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL��ɾ��
//	private final String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) VALUES(?, ?, ?, ?)";
	private final String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) VALUES((SELECT NVL(MAX(SEQ), 0)+1 FROM BOARD), ?, ?, ?)";
	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
	private final String BOARD_DELETE = "DELETE BOARD WHERE SEQ=?";
	private final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ=?";
	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC"; // �ֽ� �ۺ��� ��ȸ
	private final String BOARD_LIST_T = "SELECT * FROM BOARD WHERE TITLE LIKE '%' ||?|| '%' ORDER BY SEQ DESC";
	private final String BOARD_LIST_C = "SELECT * FROM BOARD WHERE CONTENT LIKE '%' ||?|| '%' ORDER BY SEQ DESC";
	
	// CRUD ����� �޼ҵ� ����
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� insertBoard() ��� ó��");
//		jdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
//		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� updateBoard() ��� ó��");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
//		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� deleteBoard() ��� ó��");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
//		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}
	
	// �� �� ����
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� getBoard() ��� ó��");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
//		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring DBC�� getBoardList() ��� ó��");
		Object[] args = {vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper()); // ���� ���			
		} else if (vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		} 
		return null;
//		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper()); // ���� ���
	}
	
	// DataSource ���� - DAOŬ���� ������� - JdbcDaoSupport Ŭ���� ���(extends JdbcDaoSupport)
	// SQL��ɾ��
//	private final String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) VALUES((SELECT NVL(MAX(SEQ), 0)+1 FROM BOARD), ?, ?, ?)";
//	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
//	private final String BOARD_DELETE = "DELETE BOARD WHERE SEQ=?";
//	private final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ=?";
//	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC"; // �ֽ� �ۺ��� ��ȸ
//	
//	@Autowired
//	public void setSuperDataSource(DataSource dataSource) {
//		super.setDataSource(dataSource);
//	}
//	
//	// CRUD ����� �޼ҵ� ����
//	// �� ���
//	public void insertBoard(BoardVO vo) {
//		System.out.println("===> Spring JDBC�� insertBoard() ��� ó��");
//		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
//	}
//	
//	// �� ����
//	public void updateBoard(BoardVO vo) {
//		System.out.println("===> Spring JDBC�� updateBoard() ��� ó��");
//		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
//	}
//	
//	// �� ����
//	public void deleteBoard(BoardVO vo) {
//		System.out.println("===> Spring JDBC�� deleteBoard() ��� ó��");
//		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
//	}
//	
//	// �� �� ����
//	public BoardVO getBoard(BoardVO vo) {
//		System.out.println("===> Spring JDBC�� getBoard() ��� ó��");
//		Object[] args = {vo.getSeq()};
//		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
//	}
//	
//	// �� ��� ��ȸ
//	public List<BoardVO> getBoardList(BoardVO vo) {
//		System.out.println("===> Spring DBC�� getBoardList() ��� ó��");
//		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper()); // ���� ��
//	}
}
