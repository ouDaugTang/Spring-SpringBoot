package com.aloha.spring.dao;

import java.util.ArrayList;
import java.util.List;

import com.aloha.spring.dto.Board;

public class BoardDAO {	

	
	// 빈으로 등록 될 때, 생성 될 기본 생성자 정의
	private BoardDAO() {
		
	}
	
	public List<Board> list() {
		List<Board> boardList = new ArrayList<Board>();
		boardList.add(new Board("제목01","작성자01","내용01"));
		boardList.add(new Board("제목02","작성자02","내용02"));
		boardList.add(new Board("제목03","작성자03","내용03"));
		
		System.out.println("BoardDAO 실행됨...");
		
		return boardList;
	}
}
