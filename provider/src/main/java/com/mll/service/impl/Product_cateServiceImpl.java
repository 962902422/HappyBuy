package com.mll.service.impl;

import com.mll.Mapper.Product_cateMapper;
import com.mll.pojo.MLL_PRODUCT_CATEGORY;
import java.util.List;

import com.mll.service.Product_cateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class Product_cateServiceImpl implements Product_cateService {

    @Autowired
    private Product_cateMapper pdao;


    @Cacheable(value = "mycate")
    @Override
    public List<MLL_PRODUCT_CATEGORY> findAll(int id) {

        List<MLL_PRODUCT_CATEGORY> all = pdao.findAll(id);
        for (MLL_PRODUCT_CATEGORY mll : all) {

            mll.setChildList(pdao.findAll(mll.getMpc_id()));

                List<MLL_PRODUCT_CATEGORY> childList = mll.getChildList();
                for (MLL_PRODUCT_CATEGORY mll_product_category : childList) {

                    mll_product_category.setChildList(pdao.findAll(mll.getMpc_id()));

                }


            System.out.println(mll);
        }
        return all;

    }

}
