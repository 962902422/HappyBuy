package com.mll.controller;

import com.alibaba.druid.support.json.JSONParser;
import com.github.pagehelper.Page;
import com.mll.pojo.MLL_User;
import com.mll.pojo.Message;
import com.mll.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username,String password){
        if("admin".equals(username)&&userService.userinfo().getMu_password().equals(password)){
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
    public String sellAllUser(Integer currentPage,Integer size){
        Page<MLL_User> page= userService.selAllUser(currentPage,size);
        String kong = "";
        List<MLL_User> result = page.getResult();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (int i=0;i<page.getResult().size();i++){
            kong += "{\"mu_user_id\":"+result.get(i).getMu_user_id()+",\"mu_user_name\":\""+result.get(i).getMu_user_name()+"\",\"mu_password\":\""+result.get(i).getMu_password()+"\",\"mu_headphoto\":\""+result.get(i).getMu_headphoto()
            +"\",\"mu_registerTime\":\""+sdf.format(result.get(i).getMu_registerTime())+"\",\"mu_email\":\""+result.get(i).getMu_email()+"\",\"mu_mobile\":\""+result.get(i).getMu_mobile()+"\"},";
        }
        String user = kong.substring(0,kong.length()-1);
        String str="[{\"code\": 0,\"msg\": \"\",\"count\": "+page.getTotal()+",\"data\":["+user+"]}]";
        return str;
    }

    @RequestMapping("/userinfo")
    @ResponseBody
    public MLL_User userinfo(){
        return userService.userinfo();
    }
}