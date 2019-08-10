package com.mll.service;

import com.github.pagehelper.Page;
import com.mll.pojo.MLL_User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface UserService {

    MLL_User login(String username, String password);

    MLL_User userinfo();

    Page<MLL_User> selAllUser(int pageIndex,int pageSize);

    int updEmail(int uid,String email);

    int updMobile(int uid,String mobile);

    int updAddress(int uid,String address);

    int updName(int uid,String name);

    int updCode(int uid,int code);

    int updUser(String password,String email,String mobile);

    int updUserInfo(String name,String address,String addressInfo,String code);

    int updHerdImage(String name);
}
