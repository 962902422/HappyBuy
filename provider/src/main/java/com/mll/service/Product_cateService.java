package com.mll.service;

import com.mll.pojo.MLL_PRODUCT_CATEGORY;
import java.util.List;


public interface Product_cateService {

    public List<MLL_PRODUCT_CATEGORY> findAll(int id);

}
