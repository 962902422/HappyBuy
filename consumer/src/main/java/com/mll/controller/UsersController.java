package com.mll.controller;

import com.mll.pojo.MLL_User;
import com.mll.pojo.Message;
import com.mll.service.MLLService;
import com.mll.shiro.ShiroEncryption;
import com.mll.util.ISNAN;
import com.mll.util.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
public class UsersController {
    @Autowired
    private MLLService usersService;
    //登录
    @RequestMapping("/login/User/{username}/{password}")
    public Message login(@PathVariable("username") String username, @PathVariable("password") String password,HttpServletRequest request){
        Message message=new Message();
        HttpSession session = request.getSession();
        ServletContext application = session.getServletContext();
        List<String> Users=(List<String>)application.getAttribute("users");
        System.out.println(Users);
        if(Users.contains(username)){//用户在线
            message.setFlag(false);
            message.setMess("当前用户在线");
            return message;
        }else {
            if(ISNAN.isNAN(username)){// true 手机号
                MLL_User mll_user = usersService.ByMobileLoginOrReg(username);
                if(Users.contains(mll_user.getMu_user_name())){//用户在线
                    message.setFlag(false);
                    message.setMess("当前用户在线");
                    return message;
                }else {
                    if(mll_user==null){
                        message.setFlag(false);
                        message.setMess("当前手机号未注册用户");
                        return message;
                    }else {
                      return Login.login(mll_user.getMu_user_name(),password,message,usersService,request);
                    }
                }
            }else {
                return Login.login(username,password,message,usersService,request);
            }
        }
    }
    //验证名字是否存在
    @RequestMapping("/User/checkusername/{username}")
    public Message checkUserName(@PathVariable("username") String username){
        Message mess=new Message();
        mess.setFlag(true);
        if(usersService.checkUserName(username)>0){//名字重复
            mess.setFlag(false);
            mess.setMess("用户名已存在");
        }
        return mess;
    }
    //验证手机号是否注册
    @RequestMapping("/User/checkmobile/{mobile}")
    public Message checkMobile(@PathVariable("mobile")String mobile){
        Message mess=new Message();
        mess.setFlag(true);
        if(usersService.checkMobile(mobile)>0){//该手机号已注册
            mess.setFlag(false);
            mess.setMess("该手机号已注册");
        }
        return mess;
    }
    //注册验证码
    @RequestMapping("/User/getVerification/{mobile}")
    public Integer getVerification(@PathVariable("mobile") String mobile){
        if(usersService.checkMobile(mobile)>0){//该手机号已被注册
            return 000000;
        }else {
            System.out.println("mobile"+mobile);
            //return VerificationCode.getVerificationCode(mobile);
            return 123456;
        }
    }
    //忘记密码验证码
    @RequestMapping("/User/getVerification3/{mobile}")
    public Integer getVerification3(@PathVariable("mobile") String mobile){
        System.out.println("mobile"+mobile);
        if(usersService.checkMobile(mobile)>0){//该手机号已被注册 被注册才可更改密码
            //return VerificationCode.getVerificationCode(mobile);
            return 123456;
        }else {
            return 000000;
        }
    }
    //登录验证码
    @RequestMapping("/User/getVerification2/{mobile}")
    public Integer getVerification2(@PathVariable("mobile") String mobile){
            System.out.println("mobile"+mobile);
            //return VerificationCode.getVerificationCode(mobile);
            return 123456;
    }
    //注册
    @RequestMapping("/User/Register/{username}/{password}/{mobile}/{email}")
    public Message userRegister(@PathVariable("username") String username,@PathVariable("password")String password,@PathVariable("mobile")String mobile,@PathVariable("email")String email){
       System.out.println("注册");
        MLL_User mll_user=new MLL_User();
        mll_user.setMu_user_name(username);
        mll_user.setMu_password(ShiroEncryption.MD5Pwd(username,password));
        mll_user.setMu_mobile(mobile);
        mll_user.setMu_email(email);
        mll_user.setMu_status("1");
        mll_user.setMu_headphoto("img/defaultphoto.jpg");
        mll_user.setMu_registerTime(new Date());
        Message mess=new Message();
        if(usersService.registerUser(mll_user)>0){
            mess.setFlag(true);
            mess.setMess("注册成功");
        }else{
            mess.setFlag(false);
            mess.setMess("注册失败");
        }
        return mess;
    }
    //登录OR注册
    @RequestMapping("/User/ByMobileLoginOrReg/{mobile}")
    public Message ByMobileLoginOrReg(@PathVariable("mobile")String mobile){
        MLL_User mll_user =usersService.ByMobileLoginOrReg(mobile);
        Message message=new Message();
        if(mll_user==null){//用户未注册  注册
            mll_user=new MLL_User();
            UUID uuid=UUID.randomUUID();
            String username=(uuid+"").substring(0,8);
            String pwd=ShiroEncryption.MD5Pwd(username,"123456");
            mll_user.setMu_user_name(username);
            mll_user.setMu_password(pwd);
            mll_user.setMu_headphoto("img/defaultphoto.jpg");
            mll_user.setMu_registerTime(new Date());
            mll_user.setMu_email("暂未填写邮箱");
            mll_user.setMu_mobile(mobile);
            mll_user.setMu_status("1");
            usersService.registerUser(mll_user);
            message.setFlag(true);
            message.setMess("注册成功");
        }else{
            System.out.println("username\t"+mll_user.getMu_user_name()+"pwd\t"+mll_user.getMu_password());
            message.setFlag(true);
            message.setMess("登录成功");
        }
        return  message;
    }
    @RequestMapping("/User/ByMobileUpdatePwd/{mobile}/{pwd}")
    public  Message ByMobileUpdatePwd(@PathVariable("mobile")String mobile,@PathVariable("pwd")String pwd){
        Message message=new Message();
        MLL_User mll_user =usersService.ByMobileLoginOrReg(mobile);
        if(usersService.ByMobileUpdatePwd(mobile,ShiroEncryption.MD5Pwd(mll_user.getMu_user_name(),pwd))>0){
            message.setFlag(true);
            message.setMess("密码修改成功,请重新登录");
        }else {
            message.setFlag(false);
            message.setMess("密码修改失败");
        }
        return  message;
    }
    @RequestMapping("/getUser")//获取当前登录对象
    public MLL_User getUser(HttpSession session) {
        MLL_User user = (MLL_User) session.getAttribute("user");
        return user;
    }
}
