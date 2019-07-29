package com.mll.service.impl;

import com.mll.Mapper.UsersMapper;
import com.mll.pojo.MLL_User;
import com.mll.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;
    @Override

    public Integer ByMobileUpdatePwd(String mobile, String pwd) {
        return usersMapper.ByMobileUpdatePwd(mobile,pwd);
    }

    @Override
    public MLL_User ByMobileLoginOrReg(String mobile) {
        return usersMapper.ByMobileLoginOrReg(mobile);
    }

    @Override
    public MLL_User getUser(String username) {
        return usersMapper.getUser(username);
    }

    @Override
    public int resiterUser(MLL_User mll_user) {
        return usersMapper.resiterUser(mll_user);
    }

    @Override
    public int checkUserName(String username) {
        return usersMapper.checkUserName(username);
    }

    @Override
    public int checkMobile(String mobile) {
        return usersMapper.checkMobile(mobile);
    }
}
