package com.mll.controller;

import com.mll.pojo.MLL_PRODUCT_CATEGORY;
import com.mll.service.impl.CommodityClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
public class CommodityClassController {

    @Autowired
    private CommodityClassServiceImpl commodityClassService;

    @RequestMapping("selCommodityClass")
    @ResponseBody
    public String selCommodityClass(){
        List<MLL_PRODUCT_CATEGORY> list = commodityClassService.sel();
        String kong = "";
        for (int i=0;i<list.size();i++){
            kong+="{\"id\":"+list.get(i).getMpc_id()+",\"name\":\""+list.get(i).getMpc_name()+"\",\"pid\":"+list.get(i).getParent_id()+"},";
        }
        String newstr = kong.substring(0,kong.length()-1);
        String str="{\"code\": 0,\"msg\": \"ok\",\"data\":["+newstr+"]}";
        return str;
    }

    @RequestMapping("count")
    @ResponseBody
    public String count(Integer id){
        if(commodityClassService.count(id)>0){
            System.out.println("succeed");
            return "succeed";
        }
        System.out.println("error");
        return "error";
    }

    @RequestMapping("del")
    @ResponseBody
    public String del(Integer id){
        if(commodityClassService.del(id)>0){
            return "succeed";
        }
        return "error";
    }

    @RequestMapping("upd")
    @ResponseBody
    public String upd(int id,String name){
        System.out.println(id+":"+name);
        if(commodityClassService.upd(id,name)>0){
            return "succeed";
        }
        return "error";
    }

    @RequestMapping("selByid")
    @ResponseBody
    public List<MLL_PRODUCT_CATEGORY> selByid(){
        return commodityClassService.selByid();
    }

    @RequestMapping("selBypid")
    @ResponseBody
    public List<MLL_PRODUCT_CATEGORY> selBypid(Integer pid){
        return commodityClassService.selBypid(pid);
    }


    @RequestMapping("add")
    public String add(String name, Integer pid,Integer pid2, HttpSession session){
        System.out.println(name+"\t"+pid+"\t"+pid2);

        if("".equals(name)){
            session.setAttribute("succeed","null");
        }else{
            boolean b=false;
            List<MLL_PRODUCT_CATEGORY> list=new ArrayList<>();
            System.out.println("添加一级分类");
            if(pid==0){
                list = commodityClassService.selOneClass();
            }else {
                if(pid2==0){
                    list = commodityClassService.selBypid(pid);
                }else{
                    list = commodityClassService.selBypid(pid2);
                }
            }
            for (int i=0;i<list.size();i++){
                if(list.get(i).getMpc_name().equals(name)){
                    b=true;
                    break;
                }
            }
            if(b){
                session.setAttribute("succeed","reduplication");
            }else{
                int add=0;
                if(pid2==null||pid2==0){
                    add = commodityClassService.add(pid, name);
                }else{
                    add = commodityClassService.add(pid2, name);
                }
                if(add>0){
                    session.setAttribute("succeed","true");
                }else{
                    session.setAttribute("succeed","false");
                }
            }
        }
        return "commoditytype.html";
    }
}
