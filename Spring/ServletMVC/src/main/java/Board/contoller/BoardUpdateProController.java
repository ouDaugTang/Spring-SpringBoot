package Board.contoller;

import javax.servlet.http.HttpServletRequest;

import Board.dto.Board;
import Board.service.BoardService;
import Board.service.BoardServiceImpl;

public class BoardUpdateProController {
	private BoardService boardService = new BoardServiceImpl();
	
	public String process(HttpServletRequest request) throws Exception {
		
		String reqNo = request.getParameter("no");
		int no = reqNo == null ? 0 : Integer.parseInt(reqNo);
		
		String titel = request.getParameter("title");
		String wirter = request.getParameter("wirter");
		String content = request.getParameter("content");
		
		Board board = new Board(titel, wirter, content);
		board.setNo(no);
		
		int result = boardService.insert(board);
		request.setAttribute("result", result);
		String view = "/board/list.do";
		return view;
	}
}
