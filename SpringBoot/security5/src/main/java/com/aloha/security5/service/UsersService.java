package com.aloha.security5.service;

import java.util.List;

import com.aloha.security5.dto.Users;

public interface UsersService {
    
    public List<Users> list() throws Exception;
    public Users read() throws Exception;
    public int insert(Users users) throws Exception;
    public int update(Users users) throws Exception;
    public int delete(Users users) throws Exception;
}
