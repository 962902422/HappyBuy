package com.mll.controller;

import com.github.pagehelper.Page;
import com.mll.pojo.Details;
import com.mll.service.impl.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@CrossOrigin
public class CommodityController {

    @Autowired
    private CommodityServiceImpl commodityService;

    @RequestMapping("/commoditybuy")
    @ResponseBody
    public List<Details> commoditybuy(){
        System.out.println(commodityService.sel());
        return commodityService.sel();
    }

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

    private String Image;

    @RequestMapping("/addShopingImage")
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
            Image=fileName;
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

    @RequestMapping("/addShoping")
    public String addShoping(String title,String info,Integer quiz1,Integer quiz2,Integer quiz3,double price_min,Integer stock,String image){
        System.out.println(title+"\t"+info+"\t"+quiz1+"\t"+quiz2+"\t"+quiz3+"\t"+price_min+"\t"+stock+"\t"+image);
        return "allcommodity.html";
    }
}
