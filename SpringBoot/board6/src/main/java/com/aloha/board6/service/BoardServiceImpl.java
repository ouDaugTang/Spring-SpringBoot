package com.aloha.board6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.board6.dto.Board;
import com.aloha.board6.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardMapper boardMapper;

    @Override
    public List<Board> list() {
        List<Board> boardList = boardMapper.list();
        return boardList;
    }

    @Override
    public Board read(int no) {
        Board board = boardMapper.read(no);
        return board;
    }

    @Override
    public int insert(Board board) {
        int result = boardMapper.insert(board);
        return result;
    }

    @Override
    public int update(Board board) {
        int result = boardMapper.update(board);
        return result;
    }

    @Override
    public int delete(int no) {
        int result = boardMapper.delete(no);
        return result;
    }
    
}
