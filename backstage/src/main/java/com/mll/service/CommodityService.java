package com.mll.service;

import com.github.pagehelper.Page;
import com.mll.pojo.Details;

import java.util.List;


public interface CommodityService {

    Page<Details> selAllCommodity(int pageIndex,int size);

    List<Details> sel();
}
