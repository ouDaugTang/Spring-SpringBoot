package com.aloha.springdi.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 빈 등록
 * @Component
 */
@Data
@Component("person")
public class Person {       // 이클래스를 스프링 빈으로 등록
    private String name;
    private int age;

    public Person() {
        this.name = "김조은";
        this.age = 20;
    }
}
