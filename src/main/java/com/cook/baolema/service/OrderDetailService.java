package com.cook.baolema.service;

import com.cook.baolema.pojo.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> selectAll();
    OrderDetail selectByID(Integer id);
    boolean update(OrderDetail orderDetail);
    boolean save(OrderDetail orderDetail);
    boolean deleteByID(Integer id);
}
