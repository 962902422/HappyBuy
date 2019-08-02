package com.mll.service;

import com.github.pagehelper.Page;
import com.mll.pojo.MLL_User;

import java.util.List;

public interface UserService {

    MLL_User login(String username, String password);

    MLL_User userinfo();

    Page<MLL_User> selAllUser(int pageIndex,int pageSize);
}
