package com.aloha.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aloha.board.dto.Board;
import com.aloha.board.dto.Option;
import com.aloha.board.dto.Page;

/**
 * %%%%%@Repository%%%%%%%
 * DAO = DB 직접 접근
 * Mapper = interface로 접근
 */
@Mapper //[@Mapper <-- mybitis의 매퍼 인터페이스로 지정!]
public interface BoardMapper { // Mapper.java = interface!! 

    // 게시글 목록
    public List<Board> list(@Param("page") Page page
                            ,@Param("option") Option option) throws Exception;
    // 게시글 조회
    public Board select(int no) throws Exception;
    // 게시글 등록
    public int insert(Board board) throws Exception;
    // 게시글 수정
    public int update(Board board) throws Exception;
    // 게시글 삭제
    public int delete(int no) throws Exception;
    
    // 게시글 번호(기본키) 최댓값
    public int maxPk() throws Exception;

    // 게시글 데이터 개수 조회
    public int count(@Param("option") Option option) throws Exception;

    // 게시글 목록 - [검색]
    public List<Board> search(@Param("option") Option option) throws Exception;

    // 뷰 증가
    public int views(@Param("no") int no) throws Exception;

    
}