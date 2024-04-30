package com.aloha.springresponse.dto;
import java.util.Date;
import lombok.Data;
/**
 * Board 
 * - 게시글 정보
 */
@Data
public class Board {
    private int no;        
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
    private int views;
    
    /* 기본 생성자 */
    public Board() {
        this.regDate = new Date();
        this.updDate = new Date();
    }
    
    public Board(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = new Date();
        this.updDate = new Date();
    }

    public Board(int no, String title, String writer, String content) {
        this.no = no;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = new Date();
        this.updDate = new Date();
    }
    
}