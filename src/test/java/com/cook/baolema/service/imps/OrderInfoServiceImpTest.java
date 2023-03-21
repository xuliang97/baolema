package com.cook.baolema.service.imps;

import com.cook.baolema.dao.OrderInfoDao;
import com.cook.baolema.service.OrderInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderInfoServiceImpTest {

    @Autowired
    private OrderInfoService orderInfoService;

    @Test
    void updateStatus() {
        orderInfoService.updateGrade(5,4);
    }


    @Test
    void updateStatusByOrderID() {
        orderInfoService.updateStatusByOrderID(5, (short) 2);
    }

    @Test
    void getMonthTotalAmount() {
        System.out.println(orderInfoService.getMonthTotalAmount());
    }

    @Test
    void getUnpreparedOrders() {
        System.out.println(orderInfoService.getUnpreparedOrders());
    }
}