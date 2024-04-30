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

        // MyService 객체를 생성
        MyService myService1 = new MyService();
				// ★ 의존성 주입 - 세터 주입
        // BoardDAO 객체를 세터 메서드를 통해 주입
        myService1.setBoardDAO(boardDAO);

        // MyService 객체를 생성
        MyService myService2 = new MyService();
				// ★ 의존성 주입 - 세터 주입
        // CommentDAO 객체를 세터 메서드를 통해 주입
        myService2.setCommentDAO(commentDAO);

        // MyService를 사용하여 selectAll() 메소드 호출
        List<Board> boardList = myService1.selectBoardAll();
        List<Comment> commentList = myService2.selectCommentAll();
    }
}
