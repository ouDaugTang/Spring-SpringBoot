package com.aloha.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.dao.BoardDAO;
import com.aloha.spring.dto.Board;

@Service         // 비즈니스 로직을 처리하는 서비스 클래스로 빈 등록
public class BoardServiceImpl implements BoardService {
   
   private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
   
   @Autowired
   private BoardDAO boardDAO;

   @Override
   public List<Board> list() throws Exception {
      List<Board> boardList = boardDAO.list();
      int count = boardList.size();
      return boardList;
   }

   @Override
   public Board select(int boardNo)  {
      Board board = boardDAO.select(boardNo);
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
   public int delete(int boardNo) throws Exception {
      int result = boardDAO.delete(boardNo);
      return result;
   }

}