package com.aloha.board5.service;

import java.util.List;

import com.aloha.board5.dto.Board;

public interface BoardService {
    
    public List<Board> list() throws Exception;
    public Board read(int no) throws Exception;
    public int insert(Board board) throws Exception;
    public int update(Board board) throws Exception;
    public int delete(int no) throws Exception;
}
