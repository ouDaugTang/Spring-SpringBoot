package com.aloha.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.board.dto.Reply;
import com.aloha.board.mapper.ReplyMapper;


@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public List<Reply> list() throws Exception {
        List<Reply> replyList = replyMapper.list();
        
        return replyList;
    }

    @Override
    public Reply read(int no) throws Exception {
        Reply reply = replyMapper.read(no);

        return reply;
    }

    @Override
    public int insert(Reply reply) throws Exception {
        int result = replyMapper.insert(reply);
        return result;
    }

    @Override
    public int update(Reply reply) throws Exception {
        int result = replyMapper.update(reply);
        return result;
    }

    @Override
    public int delete(int no) throws Exception {
        int result = replyMapper.delete(no);
        return result;
    }

    @Override
    public List<Reply> listByBoardNo(int boardNo) throws Exception {

        List<Reply> replyList = replyMapper.listByBoardNo(boardNo);
        return replyList;
    }
    
}
