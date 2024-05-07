package com.aloha.board3.service;

import java.util.List;

import com.aloha.board3.dto.Board;

public interface BoardService {
    // L
    public List<Board> list() throws Exception;
    // R
    public Board read(int no) throws Exception;
    // C
    public int insert(Board board) throws Exception;
    // U
    public int update(Board board) throws Exception;
    // D
    public int delete(int no) throws Exception;
}
