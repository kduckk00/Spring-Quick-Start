package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController { // �� ��Ʈ�ѷ� �ϳ��� ������ ��Ʈ�ѷ� ��ü����, ������ �����ص� ����
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public BoardListVO dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
	}
	
	// �� ���
	@RequestMapping("/insertBoard.do")
//	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
	public String insertBoard(BoardVO vo) throws IOException {
		// ���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/" +fileName));
		}
		boardService.insertBoard(vo);
//		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	// �� ����
	@RequestMapping("/updateBoard.do")
//	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
//		System.out.println("��ȣ : " + vo.getSeq());
//		System.out.println("���� : " + vo.getTitle());
//		System.out.println("�ۼ��� : " + vo.getWriter());
//		System.out.println("���� : " + vo.getContent());
//		System.out.println("����� : " + vo.getRegDate());
//		System.out.println("��ȸ�� : " + vo.getCnt());
//		boardDAO.updateBoard(vo);
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// �� ����
	@RequestMapping("/deleteBoard.do")
//	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
//		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// �� �� ��ȸ
	@RequestMapping("/getBoard.do")
//	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
//		model.addAttribute("board", boardDAO.getBoard(vo)); // Model���� ����
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo)); // Model���� ����
		return "getBoard.jsp"; // View�̸� ����
	}
	
	// �˻� ���� ��� ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}
	
//	@RequestMapping("/getBoard.do")
//	public String getBoard(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
//			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword, BoardVO vo, BoardDAO boardDAO, Model model) {
//		System.out.println("�˻� ���� : " + condition);
//		System.out.println("�˻� �ܾ� : " + keyword);
//		model.addAttribute("board", boardDAO.getBoard(vo)); // Model���� ����
//		return "getBoard.jsp"; // View�̸� ����
//	}
	
	// �� ��� �˻�
	@RequestMapping("/getBoardList.do")
//	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
//		model.addAttribute("boardList", boardDAO.getBoardList(vo)); // Model���� ����
	public String getBoardList(BoardVO vo, Model model) {
		// Null Check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model���� ����
		return "getBoardList.jsp"; // View�̸� ����
	}
}
