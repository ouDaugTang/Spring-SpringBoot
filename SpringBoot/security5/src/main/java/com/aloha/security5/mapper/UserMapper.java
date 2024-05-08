package com.aloha.security5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.security5.dto.Users;

@Mapper
public interface UserMapper {
    
    // 로그인 (사용자 인증)
    public Users login(String username);

    
    public List<Users> list() throws Exception;
    public Users read() throws Exception;
    public int insert(Users users) throws Exception;
    public int update(Users users) throws Exception;
    public int delete(Users users) throws Exception;

}
