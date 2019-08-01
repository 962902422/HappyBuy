package com.mll.controller;

import com.alibaba.druid.support.json.JSONParser;
import com.mll.pojo.MLL_User;
import com.mll.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String userName,String password){
        if("admin".equals(userName)&&userService.userinfo().getMu_password().equals(password)){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/index")
    public String index(){
        return "/login.html";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "login.html";
    }


    @RequestMapping("/selAllUser")
    @ResponseBody
    public List<MLL_User> sellAllUser(){
        String str="[{\"code\": 0,\"msg\": \"\",\"count\": page.count,\"data\":"+userService.selAllUser()+"}]";
        System.out.println(str);
        return userService.selAllUser();
    }

    @RequestMapping("/userinfo")
    @ResponseBody
    public MLL_User userinfo(){
        return userService.userinfo();
    }
}