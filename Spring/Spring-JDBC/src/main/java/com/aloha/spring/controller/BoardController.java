package com.aloha.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.spring.dto.Board;
import com.aloha.spring.service.BoardService;

@Controller							// 컨트롤러로 빈 등록
@RequestMapping("/board")			// 클래스 레벨 경로 /board 로 지정
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * 게시글 목록
	 * @param model
	 * @return
	 * @throws Exception
	 */
	/* @RequestMapping(value = "/list", method =RequestMethod.GET) */
	@GetMapping("list")						// Spring 4.3 버전 사용가능
	public String list(Model model) throws Exception {
		List<Board> boardList = boardService.list();
		model.addAttribute("boardList",boardList);
		return "board/list";				// board/list.jsp 화면 응답
	}
	
	/**
	 * 게시글 조회
	 * @param no
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/read")					// Spring 4.3 버전 사용가능
	public String read(int no, Model model) throws Exception {
		logger.info("no : " + no);
		
		Board board = boardService.select(no);
		model.addAttribute("board",board);
		return "board/read";				// board/list.jsp 화면 응답
	}
	
	// 게시글 등록					- /board/insert - [GET]
	@GetMapping("/insert")					// Spring 4.3 버전 사용가능
	public String insert(Model model) throws Exception {
		
		return "board/insert";				// board/list.jsp 화면 응답
	}
	// 게시글 등록 처리				- /board/insert - [POST]
	@PostMapping("/insert")					// Spring 4.3 버전 사용가능
	public String insert(String title, String writer, String content, Model model) throws Exception {
		Board board = new Board(title, writer, content); 
		int result = boardService.insert(board);
		if (result != 0) {
			logger.info("게시글 등록 성공");
		}
		return "redirect:/board/list";				// board/list.jsp 화면 응답
	}
	// 게시글 수정					- /board/update - [GET]
	@GetMapping("/update")					// Spring 4.3 버전 사용가능
	public String update(int no, Model model) throws Exception {
		Board board = boardService.select(no);
		model.addAttribute("board",board);
		return "board/update";		// board/list.jsp 화면 응답
	}
	// 게시글 수정 처리				- /board/update - [POST]
	@PostMapping("/update")					// Spring 4.3 버전 사용가능
	public String update(Board board) throws Exception {
		int result = boardService.update(board);
		if (result != 0) {
			logger.info("게시글 수정 성공");
		}
		return "redirect:/board/list";				// board/list.jsp 화면 응답
	}
	// 게시글 삭제 처리				- /board/delete - [POST]
	@PostMapping("/delete")					// Spring 4.3 버전 사용가능
	public String delete(int no) throws Exception {
		int result = boardService.delete(no);
		if (result != 0) {
			logger.info("게시글 삭제 성공");
		}
		return "redirect:/board/list";				// board/list.jsp 화면 응답
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}