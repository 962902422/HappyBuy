package com.mll.controller;

import com.mll.pojo.MLL_User;
import com.mll.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/login/User/{username}")
    public MLL_User login(@PathVariable("username") String username,String mobile) {
        System.out.println("8001Mobile"+mobile);

        return usersService.getUser(username);
    }

    @GetMapping("/getUser")
    public String getUser(HttpServletRequest request, HttpSession session) {

        String user = (String) session.getAttribute("user");
        if (user==null || user.isEmpty()) {
            user = "session:" + System.currentTimeMillis();
            session.setAttribute("user", user);
        }
        System.out.println("访问端口：" + request.getServerPort());
        return user;
    }

    @RequestMapping("/User/checkusername/{username}")
    public int checkUserName(@PathVariable("username") String username) {
        return usersService.checkUserName(username);
    }

    @RequestMapping("/User/checkmobile/{mobile}")
    public int checkMobile(@PathVariable("mobile") String mobile) {
        return usersService.checkMobile(mobile);
    }

    @RequestMapping("/User/RegisterUser")
    public int resiterUser(@RequestBody MLL_User mll_user) {
        return usersService.resiterUser(mll_user);
    }

    @RequestMapping("/User/ByMobileLoginOrReg/{mobile}")
    public MLL_User ByMobileLoginOrReg(@PathVariable("mobile") String mobile) {
        return usersService.ByMobileLoginOrReg(mobile);
    }
    @RequestMapping("/User/ByMobileUpdatePwd/{mobile}/{pwd}")
    public Integer ByMobileUpdatePwd(@PathVariable("mobile")String mobile,@PathVariable("pwd")String pwd) {
        return usersService.ByMobileUpdatePwd(mobile,pwd);
    }
}
