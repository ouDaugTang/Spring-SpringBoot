package com.aloha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.board.BoardDAO;
import com.aloha.spring.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO = new BoardDAO();

	@Override
	public List<Board> list() throws Exception {
		List<Board> boardList = boardDAO.list();
		int count = boardList.size();
		return boardList;
	}

	@Override
	public Board select(int no)  {
		Board board = boardDAO.select(no);
		return board;
	}

	@Override
	public int insert(Board board) throws Exception {
		int result = boardDAO.insert(board);
		return result;
	}

	@Override
	public int update(Board board) throws Exception {
		int result = boardDAO.update(board);
		return result;
	}

	@Override
	public int delete(int no) throws Exception {
		int result = boardDAO.delete(no);
		return result;
	}

}
