package com.mll.service;

import com.mll.pojo.MLL_PRODUCT_CATEGORY;

import java.util.List;

public interface CommodityClassService {

    List<MLL_PRODUCT_CATEGORY> sel();

    Integer count(int id);

    Integer del(int id);

    Integer upd(int id,String name);

    List<MLL_PRODUCT_CATEGORY> selByid();

    List<MLL_PRODUCT_CATEGORY> selBypid(int pid);

    int add(int pid,String name);

    List<MLL_PRODUCT_CATEGORY> selOneClass();
}
