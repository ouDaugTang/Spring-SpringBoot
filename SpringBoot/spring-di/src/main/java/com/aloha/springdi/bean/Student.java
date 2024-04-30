package com.aloha.springdi.bean;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class Student extends Person {

    private int studentId;
    private String grade;

    public Student() {
        super();
        this.studentId = 1001;
        this.grade = "1";
    }
    


    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", grade=" + grade + ", getAge()=" + getAge() + ", getName()="
                + getName() + "]";
    }
    
    
        
}
