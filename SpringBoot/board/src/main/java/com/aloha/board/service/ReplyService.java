package com.aloha.board.service;

import java.util.List;

import com.aloha.board.dto.Reply;

public interface ReplyService {

    
        // 댓글 목록
        public List<Reply> list() throws Exception;

        // ⭐댓글 목록
        public List<Reply> listByBoardNo(int boardNo) throws Exception;
    
        // 댓글 조회
        public Reply read(int no) throws Exception;
        
        // 댓글 등록
        public int insert(Reply reply) throws Exception;
        
        // 댓글 수정
        public int update(Reply reply) throws Exception;
        
        // 댓글 삭제
        public int delete(int no) throws Exception;
} 
    

