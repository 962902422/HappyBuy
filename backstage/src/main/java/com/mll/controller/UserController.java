package com.mll.controller;

import com.github.pagehelper.Page;
import com.mll.pojo.MLL_User;
import com.mll.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@CrossOrigin
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i=1;i<page.getResult().size();i++){
            if(result.get(i).getMr_name()==null){
                result.get(i).setMr_name("空");
            }
            if(result.get(i).getMr_mobile()==null){
                result.get(i).setMr_mobile("空");
            }
            if(result.get(i).getMr_postal_code()==null){
                result.get(i).setMr_postal_code("空");
            }
            String address="";
            if(result.get(i).getMr_address()==null&&result.get(i).getMr_detail_address()==null){
                address="空";
            }else if(result.get(i).getMr_address()!=null&&result.get(i).getMr_detail_address()==null){
                address=result.get(i).getMr_address();
            }else if(result.get(i).getMr_address()==null&&result.get(i).getMr_detail_address()!=null){
                address=result.get(i).getMr_detail_address();
            }else {
                address=result.get(i).getMr_address()+"/"+result.get(i).getMr_detail_address();
            }

            kong += "{\"mu_user_id\":"+result.get(i).getMu_user_id()+",\"mu_user_name\":\""+result.get(i).getMu_user_name()+"\",\"mu_password\":\""+result.get(i).getMu_password()+"\",\"mu_headphoto\":\""+result.get(i).getMu_headphoto()
            +"\",\"mu_registerTime\":\""+sdf.format(result.get(i).getMu_registerTime())+"\",\"mu_email\":\""+result.get(i).getMu_email()+"\",\"mr_name\":\""+result.get(i).getMr_name()+"\",\"mr_mobile\":\""+result.get(i).getMr_mobile()
                    +"\",\"mr_address\":\""+address+"\",\"mr_postal_code\":\""+result.get(i).getMr_postal_code()+"\"},";
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

    @RequestMapping("/updEmail")
    @ResponseBody
    public String updEmail(Integer uid,String email){
        System.out.println(uid+"\t"+email);
        if(userService.updEmail(uid,email)>0){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/updMobile")
    @ResponseBody
    public String updMobile(Integer uid,String mobile){
        System.out.println(uid+"\t"+mobile);
        if(userService.updMobile(uid,mobile)>0){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/updAddress")
    @ResponseBody
    public String updAddress(Integer uid,String address){
        System.out.println(uid+"\t"+address);
        if(userService.updAddress(uid,address)>0){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/updName")
    @ResponseBody
    public String updName(Integer uid,String name){
        System.out.println(uid+"\t"+name);
        if(userService.updName(uid,name)>0){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/updCode")
    @ResponseBody
    public String updCode(Integer uid,Integer code){
        System.out.println(uid+"\t"+code);
        if(userService.updCode(uid,code)>0){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/updAdmin")
    public String updAdmin(String password,String email,String phone,String username,String address,String addressInfo,String code){
        userService.updUser(password,email,phone);
        userService.updUserInfo(username,address,addressInfo,code);
        return "userinfo.html";
    }

    @RequestMapping("/updimage")
    @ResponseBody
    public Map<String,Object> updimage(MultipartFile file, HttpServletRequest request){
        Map<String, Object> map=new HashMap<>();
        //"http://182.92.194.216:2202/GJStatic/headphoto/";
        String path = "E:/HappyBuy/backstage/src/main/resources/image";//request.getSession().getServletContext().getRealPath("/");
        String image= null;
        try {
            String name=file.getOriginalFilename();
            String suffixName=name.substring(name.lastIndexOf("."));
            String hash = Integer.toHexString(new Random().nextInt());
            String fileName=hash+suffixName;
            userService.updHerdImage(fileName);
            File tempFile = new File(path,fileName);
            tempFile.createNewFile();
            file.transferTo(tempFile);
            image = tempFile.getName();
            map.put("code",0);
            map.put("image",image);
        } catch (Exception e) {
            map.put("code",1);
            e.printStackTrace();
        }
        return map;
    }
}