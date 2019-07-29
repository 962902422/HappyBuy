package com.mll.controller;

import com.mll.pojo.MLL_PRODUCT_CATEGORY;
import com.mll.service.MLLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
public class ProductController {


    @Autowired
    private MLLService detailsService;//注入service层

    @RequestMapping("/product_cate/all/{id}")
    public List<MLL_PRODUCT_CATEGORY> All(@PathVariable int id){
        return  detailsService.findAll(id);
    }

}
