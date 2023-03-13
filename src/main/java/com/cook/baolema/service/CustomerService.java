package com.cook.baolema.service;

import com.cook.baolema.pojo.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> selectAll();
    Customer selectByID(Integer id);
    boolean update(Customer customer);
    boolean save(Customer customer);
    boolean deleteByID(Integer id);
}
