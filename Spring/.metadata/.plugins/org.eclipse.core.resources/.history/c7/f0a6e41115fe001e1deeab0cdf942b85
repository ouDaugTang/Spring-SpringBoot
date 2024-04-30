package com.aloha.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.dao.BoardDAO;
import com.aloha.spring.dto.Board;

@Service // 비즈니스 로직을 처리하는 서비스 클래스로 빈 등록
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<Board> list() throws Exception {
		List<Board> boardList = boardDAO.list();
		return boardList;
	}
	
	@Override
	public Board select(int no) {
		Board board = boardDAO.select(no);
		return board;
	}

	@Override
	public Integer insert(Board board) throws Exception {
		int result = boardDAO.insert(board);
		return result;
	}

	@Override
	public Integer update(Board board) throws Exception {
		int result = boardDAO.update(board);
		return result;
	}

	@Override
	public Integer delete(int no) throws Exception {
		int result = boardDAO.delete(no);
		return result;
	}

}