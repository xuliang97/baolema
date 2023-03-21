//package com.cook.baolema.service.imps;
//
//import com.cook.baolema.dao.CustomerDao;
//import com.cook.baolema.pojo.Customer;
//import com.cook.baolema.utils.RandomNumberGenerator;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Currency;
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class CustomerServiceImpTest {
//
//    @Autowired
//    private CustomerDao customerDao;
//
//    @Test
//    void save() {
//        for (int i = 100; i < 200; i++) {
//            System.out.println(i);
//            StringBuilder username= new StringBuilder("test_");
//            username.append(i);
//
//            Customer customer=new Customer();
//            customer.setCustomer(username.toString());
//
//            customer.setGender("男");
//            customer.setPhoneNumber(RandomNumberGenerator.getTel());
//            customer.setPassword("123456");
//            customer.setAccumulatedAmount(100.0f);
//            customer.setCreatedTime(new Date());
//            System.out.println(customer);
//            customerDao.save(customer);
//        }
//    }
//}