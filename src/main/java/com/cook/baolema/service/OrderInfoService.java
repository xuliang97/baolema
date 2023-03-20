package com.cook.baolema.service;

import com.cook.baolema.pojo.Customer;
import com.cook.baolema.pojo.OrderInfo;
import com.cook.baolema.pojo.RespOrderDetail3;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderInfoService {
    List<OrderInfo> selectAll();
    List<OrderInfo> selectLimit(short status,Integer limit);
    OrderInfo selectByID(Integer id);
    boolean update(OrderInfo orderInfo);
    boolean save(OrderInfo orderInfo);
    boolean deleteByID(Integer id);

    boolean updateStatusByOrderID(Integer orderID,short status);

    PageInfo<RespOrderDetail3> selectAllByPage(int pageNum, int pageSize);

    Integer checkOrderID(Integer customerID);

    List<OrderInfo> selectHistoryOrder(Integer customerID);

}
