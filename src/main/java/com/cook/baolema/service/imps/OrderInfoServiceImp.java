package com.cook.baolema.service.imps;

import com.cook.baolema.dao.OrderInfoDao;
import com.cook.baolema.pojo.OrderInfo;
import com.cook.baolema.service.OrderInfoService;
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
    public OrderInfo selectByID(Integer id) {
        return orderInfoDao.selectByID(id);
    }

    @Override
    public boolean update(OrderInfo orderInfo) {
        return orderInfoDao.update(orderInfo)>0;
    }

    @Override
    public boolean save(OrderInfo orderInfo) {
        return orderInfoDao.save(orderInfo)>0;
    }

    @Override
    public boolean deleteByID(Integer id) {
        return orderInfoDao.deleteByID(id)>0;
    }
}
