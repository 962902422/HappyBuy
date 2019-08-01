package com.mll.service.impl;

import com.mll.mapper.UserMapper;
import com.mll.pojo.MLL_User;
import com.mll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public MLL_User login(String username, String password) {
        return userMapper.login(username,password);
    }

    @Override
    public MLL_User userinfo() {
        return userMapper.userinfo();
    }

    @Override
    public List<MLL_User> selAllUser() {
        return userMapper.selAllUser();
    }
}
