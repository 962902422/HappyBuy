package com.mll.service;

import com.github.pagehelper.Page;
import com.mll.pojo.Details;


public interface CommodityService {

    Page<Details> selAllCommodity(int pageIndex,int size);

}
