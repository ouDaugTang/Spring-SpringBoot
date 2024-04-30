package com.aloha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.dao.BoardDAO;
import com.aloha.spring.dto.Board;


// 서비스 역할을 하는 빈으로 등록
@Service
public class BoardServiceImpl implements BoardService {
	
	// 의존성 자동 주입
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<Board> list() {
		return boardDAO.list();
	}
}
