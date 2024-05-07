package com.aloha.board3.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Board {

    public int no;
    public String title;
    public String writer;
    public String content;
    public Date regDate;
    public Date updDate;
    public int views;

    
}
