package com.cook.baolema.dao;

import com.cook.baolema.pojo.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerDao {
    @Select("select * from tb_customer")
    List<Customer> selectAll();

    @Select("select * from tb_customer where customerID=#{id}")
    Customer selectByID(Integer id);

    @Insert("insert into tb_customer values (null,#{customer},#{gender},#{profilePhoto},#{phoneNumber},#{password},#{accumulatedAmount},#{createdTime})")
    int save(Customer customer);

    @Update("update tb_customer set customer=#{customer},gender=#{gender},profilePhoto=#{profilePhoto},phoneNumber=#{phoneNumber},password=#{password},accumulatedAmount=#{accumulatedAmount},createdTime=#{createdTime} where customerID=#{customerID}")
    int update(Customer newCustomer);

    @Delete("delete from tb_customer where customerID=#{id}")
    int deleteByID(Integer id);
}
