package com.cook.baolema.service.imps;

import com.cook.baolema.dao.OrderInfoDao;
import com.cook.baolema.pojo.Customer;
import com.cook.baolema.pojo.OrderInfo;
import com.cook.baolema.service.OrderInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImp implements OrderInfoService {
    @Autowired
    private OrderInfoDao orderInfoDao;

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
    public PageInfo<OrderInfo> selectAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderInfo> orderInfos = orderInfoDao.selectAll();
        PageInfo<OrderInfo> pageInfo = new PageInfo<OrderInfo>(orderInfos);
        return pageInfo;
    }

    @Override
    public Integer checkOrderID(Integer customerID) {
        return orderInfoDao.checkOrderID(customerID);
    }

}
