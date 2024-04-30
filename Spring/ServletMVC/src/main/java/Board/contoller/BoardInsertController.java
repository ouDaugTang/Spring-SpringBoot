package Board.contoller;


import javax.servlet.http.HttpServletRequest;

import Board.service.BoardService;
import Board.service.BoardServiceImpl;

public class BoardInsertController {
	private BoardService boardService = new BoardServiceImpl();
	
	public String process(HttpServletRequest request) throws Exception {
		String view = "/board/insert.jsp";
		return view;
	}
}
