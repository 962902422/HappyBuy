package com.mll.Mapper;

import com.mll.pojo.Details;
import com.mll.pojo.MLL_PRODUCT_CATEGORY;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;


public interface Product_cateMapper {
    //查询所有
    public List<MLL_PRODUCT_CATEGORY> findAll(int id);


    //推荐
    public List<Details> findRandom(int[] mc_id);


    //新品
    public List<Details> NewProduct();

    //热销产品

    public List<Details> FireBuy();
}
