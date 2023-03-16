package com.cook.baolema.service;

import com.cook.baolema.pojo.Customer;
import com.github.pagehelper.*;



import java.util.List;

public interface CustomerService {
    List<Customer> selectAll();
    Customer selectByID(Integer id);
    boolean update(Customer customer);
    boolean save(Customer customer);
    boolean deleteByID(Integer id);

    Customer selectByPhoneAndPwd(String phoneNumber, String password);
    Customer selectByPhoneNumber(String phoneNumber);
    PageInfo<Customer> selectAllByPage(int pageNum, int pageSize);
    boolean updatePwd(String password,Integer customerID);

}
