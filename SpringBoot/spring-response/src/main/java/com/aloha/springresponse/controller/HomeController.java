package com.aloha.springresponse.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @Controller
 * spring MVC 의 HTTP 요청에 응답하는 컨트롤러 클래스로 지정하는 어노테이션
 * 🔵 컨트롤러 메소드로 주로 View 를 반환
 */
@Slf4j      // 로그 사용을 위한 어노테이션
@Controller
public class HomeController {
    
    /**
     * 🚀 void
     * - URL 과 동일한 경로의 뷰로 응답한다.
     */
    @GetMapping("/login")
    public void login() {
        log.info("[GET] - /login - 로그인 페이지");;
    }
    
    /**
     * 🚀 String
     * - 문자열로 응답할 뷰 경로를 지정한다.
     */
    @GetMapping(value = {"/", ""})  // {"/A", "/B"} - 여러 경로 매핑
    public String home() {  
        log.info("[GET] - / - 메인 페이지") ;
        return "index";
    }

    /**
     * 🟢 @ResponseBody
     * 🚀 String
     * - 문자열 응답 메시지를 반환한다.
     * @return
     */
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        log.info("[GET] - /hello - 뷰가 아닌 문자열 본문을 응답합니다.");
    return "Hello Spring Boot~!";
    }
    
    
}
