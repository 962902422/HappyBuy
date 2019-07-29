package com.mll.Mapper;

import com.mll.pojo.MLL_User;
import org.apache.ibatis.annotations.Param;


public interface UsersMapper {
    //登录
    MLL_User getUser(@Param("username") String username);
    //验证名字是否存在
    int checkUserName(@Param("username") String username);
    //验证手机号是否注册
    int checkMobile(@Param("mobile") String mobile);
    //注册用户
    int resiterUser(MLL_User mll_user);
    //根据手机号判断用户登录注册
    MLL_User ByMobileLoginOrReg(@Param("mobile") String mobile);
    //根据手机号修改密码
    Integer ByMobileUpdatePwd(@Param("mobile") String mobile,@Param("pwd")String pwd);
}
