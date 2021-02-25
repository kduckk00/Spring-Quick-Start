package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOSpring  {
	// DataSource 설정 - JdbcTemplate클래스 <bean>등록, 의존성 주입
//	@Autowired
//	public void setSuperDataSource(DataSource dataSource) {
//		super.setDataSource(dataSource);
//	}
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL명령어들
//	private final String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) VALUES(?, ?, ?, ?)";
	private final String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) VALUES((SELECT NVL(MAX(SEQ), 0)+1 FROM BOARD), ?, ?, ?)";
	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
	private final String BOARD_DELETE = "DELETE BOARD WHERE SEQ=?";
	private final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ=?";
	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC"; // 최신 글부터 조회
	private final String BOARD_LIST_T = "SELECT * FROM BOARD WHERE TITLE LIKE '%' ||?|| '%' ORDER BY SEQ DESC";
	private final String BOARD_LIST_C = "SELECT * FROM BOARD WHERE CONTENT LIKE '%' ||?|| '%' ORDER BY SEQ DESC";
	
	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
//		jdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
//		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
//		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
//		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}
	
	// 글 상세 조희
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
//		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring DBC로 getBoardList() 기능 처리");
		Object[] args = {vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper()); // 여러 결과			
		} else if (vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		} 
		return null;
//		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper()); // 여러 결과
	}
	
	// DataSource 설정 - DAO클래스 구현방법 - JdbcDaoSupport 클래스 상속(extends JdbcDaoSupport)
	// SQL명령어들
//	private final String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) VALUES((SELECT NVL(MAX(SEQ), 0)+1 FROM BOARD), ?, ?, ?)";
//	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
//	private final String BOARD_DELETE = "DELETE BOARD WHERE SEQ=?";
//	private final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ=?";
//	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC"; // 최신 글부터 조회
//	
//	@Autowired
//	public void setSuperDataSource(DataSource dataSource) {
//		super.setDataSource(dataSource);
//	}
//	
//	// CRUD 기능의 메소드 구현
//	// 글 등록
//	public void insertBoard(BoardVO vo) {
//		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
//		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
//	}
//	
//	// 글 수정
//	public void updateBoard(BoardVO vo) {
//		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
//		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
//	}
//	
//	// 글 삭제
//	public void deleteBoard(BoardVO vo) {
//		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
//		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
//	}
//	
//	// 글 상세 조희
//	public BoardVO getBoard(BoardVO vo) {
//		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
//		Object[] args = {vo.getSeq()};
//		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
//	}
//	
//	// 글 목록 조회
//	public List<BoardVO> getBoardList(BoardVO vo) {
//		System.out.println("===> Spring DBC로 getBoardList() 기능 처리");
//		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper()); // 여러 결
//	}
}
