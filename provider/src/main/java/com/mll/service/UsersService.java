package com.mll.service;

import com.mll.pojo.MLL_User;
import org.apache.ibatis.annotations.Param;

public interface UsersService {
    //登录
    MLL_User getUser(String username);
    //验证名字是否存在
    int checkUserName( String username);
    //验证手机号是否注册
    int checkMobile( String mobile);
    //注册用户
    int resiterUser(MLL_User mll_user);
    //根据手机号判断用户登录注册
    MLL_User ByMobileLoginOrReg(String mobile);
    //根据手机号修改密码
    Integer ByMobileUpdatePwd( String mobile,String pwd);
}
