package Board.contoller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Board.dto.Board;
import Board.service.BoardService;
import Board.service.BoardServiceImpl;

public class BoardInsertProController {
	private BoardService boardService = new BoardServiceImpl();
	
	public String process(HttpServletRequest request) throws Exception {
		String titel = request.getParameter("title");
		String wirter = request.getParameter("wirter");
		String content = request.getParameter("content");
		
		Board board = new Board(titel, wirter, content);
		int result = boardService.insert(board);
		request.setAttribute("result", result);
		String view = "/board/list.do";
		return view;
	}
}
