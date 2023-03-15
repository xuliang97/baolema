package com.cook.baolema.service.imps;

import com.cook.baolema.dao.CustomerDao;
import com.cook.baolema.pojo.Customer;
import com.cook.baolema.pojo.Manager;
import com.cook.baolema.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> selectAll() {
        return customerDao.selectAll();
    }

    @Override
    public Customer selectByID(Integer id) {
        return customerDao.selectByID(id);
    }

    @Override
    public boolean update(Customer customer) {
        return customerDao.update(customer)>0;
    }

    @Override
    public boolean save(Customer customer) {
        return customerDao.save(customer)>0;
    }

    @Override
    public boolean deleteByID(Integer id) {
        return customerDao.deleteByID(id)>0;
    }

    @Override
    public Customer selectByPhoneAndPwd(String phoneNumber, String password) {
        return customerDao.selectByPhoneAndPwd(phoneNumber,password);
    }

    @Override
    public PageInfo<Customer> selectAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Customer> customers = customerDao.selectAll();
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(customers);
        return pageInfo;
    }


}
