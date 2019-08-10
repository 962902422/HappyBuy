package com.mll.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mll.mapper.OrderMapper;
import com.mll.pojo.MLL_Order;
import com.mll.pojo.Order;
import com.mll.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Page<Order> sel(Integer index, Integer size) {
        Page<Order> page= PageHelper.startPage(index,size);
        orderMapper.sel();
        return page;
    }

    @Override
    public Page<Order> selById(int id,Integer index, Integer size) {
        Page<Order> page= PageHelper.startPage(index,size);
        orderMapper.selById(id);
        return page;
    }

    @Override
    public int shipping(int oid) {
        return orderMapper.shipping(oid);
    }

    @Override
    public int updName(int oid, String name) {
        return orderMapper.updName(oid,name);
    }

    @Override
    public int updAddress(int oid, String address) {
        return orderMapper.updAddress(oid,address);
    }

    @Override
    public int updPhone(int oid, String phone) {
        return orderMapper.updPhone(oid,phone);
    }
}
