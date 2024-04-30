package com.aloha.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.dto.Board;
import com.aloha.spring.mapper.BoardMapper;

@Service // 비즈니스 로직을 처리하는 서비스 클래스로 빈 등록
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<Board> list() throws Exception {
		List<Board> boardList = boardMapper.list();
		return boardList;
	}
	
	@Override
	public Board select(int no) throws Exception {
		Board board = boardMapper.select(no);
		return board;
	}

	@Override
	public Integer insert(Board board) throws Exception {
//		int result = boardMapper.insert(board);
		String title = board.getTitle();
		String writer = board.getWriter();
		String content = board.getContent();
		
		int result = boardMapper.insert(title, writer, content);
		return result;
	}

	@Override
	public Integer update(Board board) throws Exception {
//		int result = boardMapper.update(board);
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", board.getTitle());
		map.put("writer", board.getWriter());
		map.put("content", board.getContent());
		map.put("no", board.getNo() + " ");
		int result = boardMapper.update(map);
		return result;
	}

	@Override
	public Integer delete(int no) throws Exception {
		int result = boardMapper.delete(no);
		return result;
	}

}