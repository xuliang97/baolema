package com.cook.baolema.service;

import com.cook.baolema.pojo.Customer;
import com.cook.baolema.pojo.OrderInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderInfoService {
    List<OrderInfo> selectAll();
    OrderInfo selectByID(Integer id);
    boolean update(OrderInfo orderInfo);
    boolean save(OrderInfo orderInfo);
    boolean deleteByID(Integer id);

    PageInfo<OrderInfo> selectAllByPage(int pageNum, int pageSize);

}
