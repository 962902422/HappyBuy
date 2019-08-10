package com.mll.controller;

import com.github.pagehelper.Page;
import com.mll.pojo.MLL_Order;
import com.mll.pojo.Order;
import com.mll.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("/sel")
    @ResponseBody
    public String sel(Integer currentPage,Integer size){
        Page<Order> page = orderService.sel(currentPage, size);
        String kong="";
        List<Order> result = page.getResult();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i=0;i<result.size();i++){
            kong += "{\"mo_id\":"+result.get(i).getMo_id()+",\"mo_uuid\":\""+result.get(i).getMo_uuid()+"\",\"mo_user_name\":\""+result.get(i).getMo_user_name()+"\",\"mo_user_address\":\""+result.get(i).getMo_user_address()+"\",\"mo_create_time\":\""+sdf.format(result.get(i).getMo_create_time())
                    +"\",\"mo_sum\":\""+result.get(i).getMo_sum()+"\",\"mo_shouji\":\""+result.get(i).getMo_shouji()+"\",\"mo_fangshi\":\""+result.get(i).getMo_fangshi()+"\",\"mo_type\":\""+result.get(i).getMo_type()+"\"},";
        }
        String newStr=kong.substring(0,kong.length()-1);
        String str="[{\"code\": 0,\"msg\": \"\",\"count\": "+page.getTotal()+",\"data\":["+newStr+"]}]";
        return str;
    }

    @RequestMapping("/selById/{id}")
    @ResponseBody
    public String selById(@PathVariable("id") Integer id, Integer currentPage, Integer size){
        Page<Order> page = orderService.selById(id,currentPage, size);
        String kong="";
        List<Order> result = page.getResult();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i=0;i<result.size();i++){
            kong += "{\"mo_id\":"+result.get(i).getMo_id()+",\"mo_uuid\":\""+result.get(i).getMo_uuid()+"\",\"mo_user_name\":\""+result.get(i).getMo_user_name()+"\",\"mo_user_address\":\""+result.get(i).getMo_user_address()+"\",\"mo_create_time\":\""+sdf.format(result.get(i).getMo_create_time())
                    +"\",\"mo_sum\":\""+result.get(i).getMo_sum()+"\",\"mo_shouji\":\""+result.get(i).getMo_shouji()+"\",\"mo_fangshi\":\""+result.get(i).getMo_fangshi()+"\",\"mo_type\":\""+result.get(i).getMo_type()+"\"},";
        }
        String newStr=kong.substring(0,kong.length()-1);
        String str="[{\"code\": 0,\"msg\": \"\",\"count\": "+page.getTotal()+",\"data\":["+newStr+"]}]";
        return str;
    }

    @RequestMapping("/updOrderName")
    @ResponseBody
    public String updName(){
        return "";
    }

    @RequestMapping("/updOrderAddress")
    @ResponseBody
    public String updAddress(){
        return "";
    }

    @RequestMapping("/updOrderMobile")
    @ResponseBody
    public String updMobile(){
        return "";
    }
}
