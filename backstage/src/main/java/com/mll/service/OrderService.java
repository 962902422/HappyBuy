package com.mll.service;

import com.github.pagehelper.Page;
import com.mll.pojo.Order;

public interface OrderService {

    Page<Order> sel(Integer index, Integer size);

    Page<Order> selById(int id,Integer index, Integer size);

    int shipping(int oid);

    int updName(int oid,String name);

    int updAddress(int oid,String address);

    int updPhone(int oid,String phone);
}
