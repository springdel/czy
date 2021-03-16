package com.czy.sboot.service.impl;


import com.czy.sboot.mapper.UserMapper;
import com.czy.sboot.entity.Users;
import com.czy.sboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Users findUser() {
        return userMapper.findUser();
    }
}
