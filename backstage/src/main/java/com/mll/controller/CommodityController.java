package com.mll.controller;

import com.github.pagehelper.Page;
import com.mll.pojo.Details;
import com.mll.service.impl.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class CommodityController {

    @Autowired
    private CommodityServiceImpl commodityService;

    @RequestMapping("/allCommodity")
    @ResponseBody
    public String allCommodity(Integer currentPage,Integer size){
        Page<Details> page= commodityService.selAllCommodity(currentPage,size);
        String kong = "";
        List<Details> result = page.getResult();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (int i=0;i<page.getResult().size();i++){
            /*kong+="{\"mp_id\":"+result.get(i).getMp_id()+",\"mp_name\":\""+result.get(i).getMp_name()+"\"},";*/
            kong += "{\"mp_id\":"+result.get(i).getMp_id()+",\"mp_name\":\""+result.get(i).getMp_name()+"\",\"mp_descpiption\":\""+result.get(i).getMp_descpiption()+"\",\"mp_price\":"+result.get(i).getMp_price()
                    +",\"mp_stock\":"+result.get(i).getMp_stock()+",\"mp_time\":\""+sdf.format(result.get(i).getMp_time())+"\",\"mp_buy_id\":"+result.get(i).getMp_buy_id()+"},";
        }
        String details = kong.substring(0,kong.length()-1);
        String str="[{\"code\": 0,\"msg\": \"\",\"count\": "+page.getTotal()+",\"data\":["+details+"]}]";
        return str;
    }
}
