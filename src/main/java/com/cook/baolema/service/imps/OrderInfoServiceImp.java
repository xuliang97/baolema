package com.cook.baolema.service.imps;

import com.cook.baolema.dao.CustomerDao;
import com.cook.baolema.dao.DishDao;
import com.cook.baolema.dao.OrderDetailDao;
import com.cook.baolema.dao.OrderInfoDao;
import com.cook.baolema.pojo.*;

import com.cook.baolema.respdata.*;

import com.cook.baolema.service.OrderInfoService;
import com.cook.baolema.utils.Status2Message;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderInfoServiceImp implements OrderInfoService {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private DishDao dishDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<OrderInfo> selectAll() {
        return orderInfoDao.selectAll();
    }

    @Override
    public List<OrderInfo> selectLimit(short status, Integer limit) {
        return orderInfoDao.selectLimit(status, limit);
    }

    @Override
    public OrderInfo selectByID(Integer id) {
        return orderInfoDao.selectByID(id);
    }

    @Override
    public boolean update(OrderInfo orderInfo) {
        return orderInfoDao.update(orderInfo) > 0;
    }

    @Override
    public boolean save(OrderInfo orderInfo) {
        return orderInfoDao.save(orderInfo) > 0;
    }

    @Override
    public boolean deleteByID(Integer id) {
        return orderInfoDao.deleteByID(id) > 0;
    }

    @Override
    public boolean updateStatusByOrderID(Integer orderID, short status) {
        return orderInfoDao.updateStatusByOrderID(orderID, status) > 0;
    }

    @Override
    public PageInfo<RespOrderDetail3> selectAllByPage(int pageNum, int pageSize) {
        Page page = PageHelper.startPage(pageNum, pageSize);

        List<OrderInfo> orderInfos = orderInfoDao.selectAll();

        List<RespOrderDetail3> respOrderDetail3List = new ArrayList<>();

        for (OrderInfo oi : orderInfos) {
            RespOrderDetail3 respOrderDetail3 = new RespOrderDetail3();

            OrderInfo2 orderInfo2 = new OrderInfo2();
            orderInfo2.setOrderID(oi.getOrderID());
            orderInfo2.setCustomerID(oi.getCustomerID());
            orderInfo2.setChefID(oi.getChefID());
            orderInfo2.setStatus(oi.getStatus());
            orderInfo2.setComment(oi.getComment());
            orderInfo2.setTotalAmount(oi.getTotalAmount());
            orderInfo2.setCreatedTime(oi.getCreatedTime());
            orderInfo2.setStatusMessage(Status2Message.change(oi.getStatus()));

            Customer customer = customerDao.selectByID(oi.getCustomerID());
            orderInfo2.setPhoneNumber(customer.getPhoneNumber());

            respOrderDetail3.setOrderInfo2(orderInfo2);

            List<RespOrderDetail> respOrderDetails = new ArrayList<>();
            Integer orderID = oi.getOrderID();
            List<OrderDetail> orderDetails = orderDetailDao.selectByOrderID(orderID);

            for (OrderDetail od : orderDetails) {
                RespOrderDetail respOrderDetail = new RespOrderDetail();
                respOrderDetail.setDishAmount(od.getDishAmount());
                respOrderDetail.setNumber(od.getNumber());

                Dish dish = dishDao.selectByID(od.getDishID());
                respOrderDetail.setDishName(dish.getDish());

                respOrderDetails.add(respOrderDetail);
            }

            respOrderDetail3.setRespOrderDetailList(respOrderDetails);

            respOrderDetail3List.add(respOrderDetail3);
        }

        PageInfo<RespOrderDetail3> pageInfo = new PageInfo<RespOrderDetail3>(respOrderDetail3List);
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }

    @Override
    public Integer checkOrderID(Integer customerID) {
        return orderInfoDao.checkOrderID(customerID);
    }

    @Override
    public List<OrderInfo> selectHistoryOrder(Integer customerID) {
        return orderInfoDao.selectHistoryOrder(customerID);
    }

    @Override
    public Integer checkOrderIDByuuid(String uuid) {
        return orderInfoDao.checkOrderIDByuuid(uuid);
    }

    @Override
    public boolean updateGrade(Integer orderID, Integer grade) {
        return orderInfoDao.updateGrade(orderID, grade) > 0;
    }

    @Override
    public List<GradeNumber> selectGradeNumber() {
        return orderInfoDao.selectGradeNumber();
    }

    @Override
    public NumberAndAmount selectAmountAndNumberOfToday(String year, String month, String day) {
        return orderInfoDao.selectAmountAndNumberOfToday(year,month,day);

    }

    @Override
    public List<HourAndOrderNumber> selectOrderOfHour() {
        return orderInfoDao.selectOrderOfHour();
    }

    @Override

    public List<OrderInfo3> selectHistoryOrder2(Integer customerID) {
        return orderInfoDao.selectHistoryOrder2(customerID);
    }
    @Override
    public List<goodDish> selectGoodDishes(Integer limit) {
        return orderInfoDao.getGoodDishes(limit);

    }


    @Override
    public Float getMonthTotalAmount() {
        return orderInfoDao.getMonthTotalAmount();
    }

    @Override
    public Integer getUnpreparedOrders() {
        return orderInfoDao.getUnpreparedOrders();
    }

}
