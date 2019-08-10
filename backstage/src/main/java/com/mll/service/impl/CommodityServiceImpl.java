package com.mll.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mll.mapper.CommodityMapper;
import com.mll.pojo.Details;
import com.mll.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public Page<Details> selAllCommodity(int pageIndex,int size) {
        Page<Details> page = PageHelper.startPage(pageIndex, size);
        commodityMapper.selAllCommodity();
        return page;
    }

    @Override
    public List<Details> sel() {
        return commodityMapper.sel();
    }
}
