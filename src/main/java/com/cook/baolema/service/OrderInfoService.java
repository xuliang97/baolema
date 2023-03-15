package com.cook.baolema.service;

import com.cook.baolema.pojo.OrderInfo;

import java.util.List;

public interface OrderInfoService {
    List<OrderInfo> selectAll();
    List<OrderInfo> selectLimit(short status,Integer limit);
    OrderInfo selectByID(Integer id);
    boolean update(OrderInfo orderInfo);
    boolean save(OrderInfo orderInfo);
    boolean deleteByID(Integer id);

}
