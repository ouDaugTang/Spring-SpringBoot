package Board.contoller;

import javax.servlet.http.HttpServletRequest;

import Board.service.BoardService;
import Board.service.BoardServiceImpl;

public class BoardDeleteProController {
	private BoardService boardService = new BoardServiceImpl();
	
	public String process(HttpServletRequest request) throws Exception {
			
			String reqNo = request.getParameter("no");
			int no = reqNo == null ? 0 : Integer.parseInt(reqNo);
			int result = boardService.delete(no);
			request.setAttribute("result", result);
			String view = "/board/list.do";
			return view;
	}
}
