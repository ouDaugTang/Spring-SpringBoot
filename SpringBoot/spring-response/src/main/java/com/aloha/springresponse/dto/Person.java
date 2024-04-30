package com.aloha.springresponse.dto;

import lombok.Data;

@Data
public class Person {

    private String name;
    private int age;

    // 기본 생성자
    public Person() {
        this.name = "김조은";
        this.age = 20;
    }
    
}
