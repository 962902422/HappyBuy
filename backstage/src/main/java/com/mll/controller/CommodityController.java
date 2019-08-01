package com.mll.controller;

import com.mll.pojo.Details;
import com.mll.service.impl.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommodityController {

    @Autowired
    private CommodityServiceImpl commodityService;

    @RequestMapping("/allCommodity")
    @ResponseBody
    public List<Details> allCommodity(int pageIndex){
        return commodityService.selAllCommodity(pageIndex);
    }
}
