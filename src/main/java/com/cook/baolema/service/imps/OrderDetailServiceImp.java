package com.cook.baolema.service.imps;

import com.cook.baolema.dao.OrderDetailDao;
import com.cook.baolema.pojo.OrderDetail;
import com.cook.baolema.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImp implements OrderDetailService {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public List<OrderDetail> selectAll() {
        return orderDetailDao.selectAll();
    }

    @Override
    public OrderDetail selectByID(Integer id) {
        return orderDetailDao.selectByID(id);
    }

    @Override
    public boolean update(OrderDetail orderDetail) {
        return orderDetailDao.update(orderDetail)>0;
    }

    @Override
    public boolean save(OrderDetail orderDetail) {
        return orderDetailDao.save(orderDetail)>0;
    }

    @Override
    public boolean deleteByID(Integer id) {
        return orderDetailDao.deleteByID(id)>0;
    }
}
