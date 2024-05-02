package com.aloha.board.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reply {
    private int no;
    private int boardNo;
    private int parentNo;
    private String writer;
    private String content;
    private Date regDate; 
    private Date updDate; 
}
