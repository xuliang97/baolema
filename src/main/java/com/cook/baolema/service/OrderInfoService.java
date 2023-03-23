package com.cook.baolema.service;

import com.cook.baolema.pojo.OrderInfo;

import com.cook.baolema.respdata.GradeNumber;

import com.cook.baolema.respdata.HourAndOrderNumber;
import com.cook.baolema.respdata.NumberAndAmount;

import com.cook.baolema.respdata.RespOrderDetail3;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoService {
    List<OrderInfo> selectAll();

    List<OrderInfo> selectLimit(short status, Integer limit);

    OrderInfo selectByID(Integer id);

    boolean update(OrderInfo orderInfo);

    boolean save(OrderInfo orderInfo);

    boolean deleteByID(Integer id);

    boolean updateStatusByOrderID(Integer orderID, short status);

    PageInfo<RespOrderDetail3> selectAllByPage(int pageNum, int pageSize);

    Integer checkOrderID(Integer customerID);

    List<OrderInfo> selectHistoryOrder(Integer customerID);

    Integer checkOrderIDByuuid(String uuid);

    boolean updateGrade(Integer orderID, Integer grade);

    Float getMonthTotalAmount();

    Integer getUnpreparedOrders();


    List<GradeNumber> selectGradeNumber();

    NumberAndAmount selectAmountAndNumberOfToday(String year, String month, String day);

    List<HourAndOrderNumber> selectOrderOfHour();



}
