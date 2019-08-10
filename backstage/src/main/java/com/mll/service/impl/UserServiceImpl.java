package com.mll.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mll.mapper.UserMapper;
import com.mll.pojo.MLL_User;
import com.mll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public int updEmail(int uid, String email) {
        return userMapper.updEmail(uid,email);
    }

    @Override
    public int updMobile(int uid, String mobile) {
        return userMapper.updMobile(uid,mobile);
    }

    @Override
    public int updAddress(int uid, String address) {
        return userMapper.updAddress(uid,address);
    }

    @Override
    public int updName(int uid, String name) {
        return userMapper.updName(uid,name);
    }

    @Override
    public int updCode(int uid, int code) {
        return userMapper.updCode(uid,code);
    }

    @Override
    public int updUser(String password, String email, String mobile) {
        return userMapper.updUser(password,email,mobile);
    }

    @Override
    public int updUserInfo(String name, String address, String addressInfo, String code) {
        return userMapper.updUserInfo(name,address,addressInfo,code);
    }

    @Override
    public int updHerdImage(String name) {
        return userMapper.updHerdImage(name);
    }
}
