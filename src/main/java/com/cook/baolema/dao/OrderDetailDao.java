package com.cook.baolema.dao;

import com.cook.baolema.pojo.OrderDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDetailDao {
    @Select("select * from tb_order_detail")
    List<OrderDetail> selectAll();

    @Select("select * from tb_order_detail where orderDetailID=#{id}")
    OrderDetail selectByID(Integer id);

    @Insert("insert into tb_order_detail values (null,#{orderID},#{dishID},#{number},#{dishAmount})")
    int save(OrderDetail newOrderDetail);

    @Update("update tb_order_detail set orderID=#{orderID},dishID=#{dishID},number=#{number},dishAmount=#{dishAmount} where orderDetailID=#{orderDetailID}")
    int update(OrderDetail newOrderDetail);

    @Delete("delete from tb_order_detail where orderDetailID=#{id}")
    int deleteByID(Integer id);
}
