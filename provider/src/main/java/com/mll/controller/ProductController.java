package com.mll.controller;


import com.mll.pojo.MLL_PRODUCT_CATEGORY;
import java.util.List;

import com.mll.service.Product_cateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ProductController {

    @Autowired
    private Product_cateService ps;

    @RequestMapping("/product/all/{id}")
    @ResponseBody
   public List<MLL_PRODUCT_CATEGORY> findAll(@PathVariable int id){
        System.out.println("sssssssssssssssssssss");
      return ps.findAll(id);
   }

}
