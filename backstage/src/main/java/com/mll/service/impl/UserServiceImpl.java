package com.mll.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mll.mapper.UserMapper;
import com.mll.pojo.Details;
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
    public Page<MLL_User> selAllUser(int pageIndex,int pageSize) {
        Page<MLL_User> page=PageHelper.startPage(pageIndex, pageSize);
        userMapper.selAllUser();
        return page;
    }
}
