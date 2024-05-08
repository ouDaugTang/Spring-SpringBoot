package com.aloha.security5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.security5.dto.Users;
import com.aloha.security5.mapper.UserMapper;

@Service
public class UserServiceImpl implements UsersService{

    @Autowired
    UserMapper userMapper;

    @Override
    public List<Users> list() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public Users read() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public int insert(Users users) throws Exception {
        int result = userMapper.insert(users);
        return result;
    }

    @Override
    public int update(Users users) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Users users) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
