package com.cook.baolema.service;

import com.cook.baolema.pojo.Customer;
import com.cook.baolema.pojo.Manager;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

}
