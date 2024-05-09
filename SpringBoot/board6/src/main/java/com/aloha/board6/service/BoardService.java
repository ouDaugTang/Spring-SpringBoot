package com.aloha.board6.service;

import java.util.List;

import com.aloha.board6.dto.Board;

public interface BoardService {

    public List<Board> list();
    public Board read(int no);
    public int insert(Board board);
    public int update(Board board);
    public int delete(int no);
    
}
