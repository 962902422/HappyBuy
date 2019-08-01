package com.mll.controller;

import com.mll.pojo.Details;
import com.mll.pojo.MLL_PRODUCT_CATEGORY;
import com.mll.service.MLLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@Controller
public class ProductController {


    @Autowired
    private MLLService detailsService;//注入service层
    @ResponseBody
    @RequestMapping("/product_cate/all/{id}")

    public List<MLL_PRODUCT_CATEGORY> All(@PathVariable int id){

        List<MLL_PRODUCT_CATEGORY> al = detailsService.findAll(id);



        return  detailsService.findAll(id);

    }


    @RequestMapping("/product/random")
    @ResponseBody
    public List<Details> Ramdom(){

        int mc_id[]=new int[5];


        Set<Integer> set = new HashSet<Integer>();
        while(set.size()<5){
            set.add((int)((19)*Math.random()+1));
        }

        Object[] ints = set.toArray();



        for(int i = 0;i<ints.length;i++){

            mc_id[i]=(int)ints[i];
        }


//        for(int i = 0;i < 5;i ++){
//            mc_id[i] = (int)(Math.random()*10+1);
//        }



        return detailsService.findRandom(mc_id);

    }


    @RequestMapping("/product/newproduct")
    @ResponseBody
    public List<Details> NewProduct(){

        return detailsService.NewProduct();
    };

    @RequestMapping("/product/firebuy")
    @ResponseBody
    public List<Details> FireBuy(){

        return detailsService.FireBuy();

    }
}
