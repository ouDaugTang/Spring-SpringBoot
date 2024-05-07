package com.aloha.board2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.board2.dto.Board;
import com.aloha.board2.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardMapper boardMapper;

    /**
     * 게시글 목록 조회
     */
    @Override
    public List<Board> list() throws Exception {

        List<Board> boardList = boardMapper.list();

        return boardList;
    }

    /**
     * 게사글 조회
     */
    @Override
    public Board read(int no) throws Exception {
        
        Board board = boardMapper.read(no);

        return board;
    }

    /**
     * 게시글 등록
     */
    @Override
    public int insert(Board board) throws Exception {
        
        int result = boardMapper.insert(board);
        if (result > 0) {
            log.info("게시글 등록 성공!");
        } else{
            log.info("게시글 등록 싫패 !!");
        }
        
        return result;
    }

    @Override
    public int update(Board board) throws Exception {
       
        int result = boardMapper.update(board);
        if (result > 0) {
            log.info("게시글 수정 성공!");
        } else{
            log.info("게시글 수정 싫패 !!");
        }
        
        return result;
    }

    @Override
    public int delete(int no) throws Exception {
       
        int result = boardMapper.delete(no);
        if (result > 0) {
            log.info("게시글 삭제 성공!");
        } else{
            log.info("게시글 삭제 싫패 !!");
        }
        
        return result;
    }
    
}
