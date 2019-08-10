package com.mll.service.impl;

import com.mll.mapper.CommodityClassMapper;
import com.mll.pojo.MLL_PRODUCT_CATEGORY;
import com.mll.service.CommodityClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommodityClassServiceImpl implements CommodityClassService {

    @Autowired
    private CommodityClassMapper commodityClassMapper;

    @Override
    public List<MLL_PRODUCT_CATEGORY> sel() {
        return commodityClassMapper.sel();
    }

    @Override
    public Integer count(int id) {
        return commodityClassMapper.count(id);
    }

    @Override
    public Integer del(int id) {
        return commodityClassMapper.del(id);
    }

    @Override
    public Integer upd(int id, String name) {
        return commodityClassMapper.upd(id,name);
    }

    @Override
    public List<MLL_PRODUCT_CATEGORY> selByid() {
        return commodityClassMapper.selByid();
    }

    @Override
    public List<MLL_PRODUCT_CATEGORY> selBypid(int pid) {
        return commodityClassMapper.selBypid(pid);
    }

    @Override
    public int add(int pid, String name) {
        return commodityClassMapper.add(pid,name);
    }

    @Override
    public List<MLL_PRODUCT_CATEGORY> selOneClass() {
        return commodityClassMapper.selOneClass();
    }

}
