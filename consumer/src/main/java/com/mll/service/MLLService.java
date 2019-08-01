package com.mll.service;

import com.mll.pojo.Details;
import com.mll.pojo.MLL_PRODUCT_CATEGORY;
import com.mll.pojo.MLL_User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

//@FeignClient("microservice-zuul-gateway")
@FeignClient("microservice-mll")
public interface MLLService {
    /**
     * 苏白 Service
     *
     * */
    //登录
    @PostMapping("/login/User/{username}")
    public MLL_User login(@PathVariable("username") String username);
    //验证名字是否存在
    @RequestMapping("/User/checkusername/{username}")
    public int checkUserName(@PathVariable("username") String username);
    //验证手机号是否注册
    @RequestMapping("/User/checkmobile/{mobile}")
    public int checkMobile(@PathVariable("mobile")String mobile);
    //注册
    @RequestMapping("/User/RegisterUser")
    int registerUser(MLL_User mll_user);
    @RequestMapping("/User/ByMobileLoginOrReg/{mobile}")
    public MLL_User ByMobileLoginOrReg(@PathVariable("mobile") String mobile);
    @RequestMapping("/User/ByMobileUpdatePwd/{mobile}/{pwd}")
    public Integer ByMobileUpdatePwd(@PathVariable("mobile")String mobile,@PathVariable("pwd")String pwd);
    @RequestMapping("/details/list/{id}")

    /*
    PG Service
    **/
    public List<Details> detailsAll(@PathVariable("id") Integer id);//查询对应的商品详情信息

    /*
    God Service
    **/
    @RequestMapping("/product/all/{id}")
    public List<MLL_PRODUCT_CATEGORY> findAll(@PathVariable("id") int id);

    @RequestMapping("/product/random")
    public List<Details> findRandom(@RequestBody  int[] mc_id);

    @RequestMapping("/product/newproduct")
    public List<Details> NewProduct();

    @RequestMapping("/product/firebuy")
    public List<Details> FireBuy();
}
