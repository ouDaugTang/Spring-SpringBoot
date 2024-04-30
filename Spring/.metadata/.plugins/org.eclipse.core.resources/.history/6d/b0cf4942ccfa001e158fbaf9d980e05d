package DI;

import java.util.List;

import DI.DAO.BoardDAO;
import DI.DAO.CommentDAO;
import DI.DTO.Board;
import DI.DTO.Comment;
import DI.Service.MyService;

public class Main {
    public static void main(String[] args) {
        // BoardDAO 객체를 생성
        BoardDAO boardDAO = new BoardDAO();
				// CommentDAO 객체를 생성
        CommentDAO commentDAO = new CommentDAO();

				// ★ 의존성 주입 - 생성자 주입
        // MyService 객체를 생성하고 BoardDAO 객체를 생성자를 통해 주입
        MyService myService1 = new MyService(boardDAO);

				// ★ 의존성 주입 - 생성자 주입
        // MyService 객체를 생성하고 commentDAO 객체를 생성자를 통해 주입
        MyService myService2 = new MyService(commentDAO);

        // MyService를 사용
        List<Board> boardList = myService1.selectBoardAll();
        List<Comment> commentList = myService2.selectCommentAll();
    }
}