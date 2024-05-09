package com.aloha.security5.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aloha.security5.dto.UserAuth;
import com.aloha.security5.dto.Users;

public interface UserService {
    
    // 로그인 (사용자 인증)
    public void login(Users user, HttpServletRequest request);
    // ✅ 회원 가입
    public int join(Users users) throws Exception;
    // 🐱‍👤 회원 권한 등록
    public int insertAuth(UserAuth userAuth) throws Exception;

    public List<Users> list() throws Exception;

    public Users read() throws Exception;

    public int update(Users users) throws Exception;

    public int delete(Users users) throws Exception;
}
