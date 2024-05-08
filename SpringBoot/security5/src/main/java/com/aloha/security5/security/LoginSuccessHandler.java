package com.aloha.security5.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.aloha.security5.dto.CustomUser;

import lombok.extern.slf4j.Slf4j;

/**
 * ✅ 로그인 성공 처리 클래스
 */
@Slf4j
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
    

    /**
     * 인증 성공 시 실행되는 메소드
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {

        log.info("로그인 인증 성공...");

        // 인증 된 사용자 정보 - (아이디/패스워드/권한)
        // User user = (User) authentication.getPrincipal();

        CustomUser user = (CustomUser) authentication.getPrincipal();

        log.info("아이디 : " + user.getUsername());
        log.info("비밀번호 : " + user.getPassword());       // 보안상 노출X
        log.info("권한 : " + user.getAuthorities());


        super.onAuthenticationSuccess(request, response, authentication);
    }
    
}
