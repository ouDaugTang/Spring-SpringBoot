package com.aloha.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aloha.spring.dto.Board;

@Configuration      // 스프링 설정 빈으로 등록
public class Config {
   // 1. 객체를 반환하는 메소드를 정의
   // 2. 메소드에 @Bean 어노테이션 정의
   
   @Bean         // IoC 컨테이너에 빈으로 등록
   public Board board() {
      return new Board("제목", "작성자", "내용");
   }
   
}